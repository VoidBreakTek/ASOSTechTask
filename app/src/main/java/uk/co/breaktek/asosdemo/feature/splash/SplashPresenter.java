package uk.co.breaktek.asosdemo.feature.splash;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import uk.co.breaktek.asosdemo.domain.interactor.EmptyInteractorParams;
import uk.co.breaktek.asosdemo.domain.interactor.Interactor;
import uk.co.breaktek.asosdemo.mvp.ActivityPresenter;
import uk.co.breaktek.asosdemo.reactive.RefreshSubscriber;

/**
 * MVP Presenter for Splash screen. May seem excessive in this demo but would perform any startup
 * logic such as connectivity checks or retrieving remote config data such as feature switches.
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class SplashPresenter implements ActivityPresenter<SplashView> {
    public static final String TAG = SplashPresenter.class.getSimpleName();
    private static final int SPLASH_TIME_OUT = 1500;

    @Inject
    @Named("RefreshMensCategories")
    Interactor mRefreshMensCategories;

    @Inject
    @Named("RefreshWomensCategories")
    Interactor mRefreshWomensCategories;

    private SplashView mView;
    private int mCategoriesRefreshed = 0;

    @Inject
    public SplashPresenter() {
        // Empty constructor with @Inject annotation allows Dagger to construct new instances on
        // request without an explicit module @Provides method
    }

    @Override
    public void initialize() {
        Log.d(TAG, "Presenter initialize");
    }

    @Override
    public void bind(SplashView view) {
        this.mView = view;
    }

    @Override
    public void resume() {
        Log.d(TAG, "Presenter resume");
        refreshAllCategories();
    }

    private void refreshAllCategories() {
        mCategoriesRefreshed = 0;
        refreshWomensCategories();
        refreshMensCategories();
    }

    private void refreshMensCategories() {
        mRefreshMensCategories.execute(new RefreshSubscriber() {
            @Override
            public void onRefreshed() {
                Log.i(TAG, "refreshMensCategories - onRefreshed");
                singleRefreshComplete();
            }

            @Override
            public void onError(Throwable e) {
                refreshFailed();
                e.printStackTrace();
            }
        }, new EmptyInteractorParams());
    }

    private void refreshWomensCategories() {
        mRefreshWomensCategories.execute(new RefreshSubscriber() {
            @Override
            public void onRefreshed() {
                Log.i(TAG, "refreshWomensCategories - onRefreshed");
                singleRefreshComplete();
            }

            @Override
            public void onError(Throwable e) {
                refreshFailed();
                e.printStackTrace();
            }
        }, new EmptyInteractorParams());
    }

    private synchronized void singleRefreshComplete() {
        mCategoriesRefreshed++;
        Log.i(TAG, "singleRefreshComplete - " + mCategoriesRefreshed);
        if (mCategoriesRefreshed >= 2) {
            refreshComplete();
        }
    }

    private void refreshComplete() {
        Log.i(TAG, "refreshComplete");
        mView.showHomeScreen(SPLASH_TIME_OUT);
    }

    private void refreshFailed() {
        Log.i(TAG, "refreshFailed");
        mView.showRefreshFailedError();
        mView.closeApp();
    }

    @Override
    public void pause() {
        //When the Activity is paused, unsubscribe it's presenter from any existing Observable
        // subscriptions to prevent invalid callbacks
        mRefreshMensCategories.unsubscribe();
        mRefreshWomensCategories.unsubscribe();
    }

    @Override
    public void destroy() {

    }
}
