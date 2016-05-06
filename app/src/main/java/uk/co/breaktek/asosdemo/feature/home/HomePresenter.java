package uk.co.breaktek.asosdemo.feature.home;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Subscriber;
import uk.co.breaktek.asosdemo.domain.interactor.EmptyInteractorParams;
import uk.co.breaktek.asosdemo.domain.interactor.Interactor;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.mvp.ActivityPresenter;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class HomePresenter implements ActivityPresenter<HomeView> {
    public static final String TAG = HomePresenter.class.getSimpleName();

    @Inject
    @Named("GetMensCategories")
    Interactor mGetMensCategories;

    @Inject
    @Named("GetWomensCategories")
    Interactor mGetWomensCategories;

    private HomeView mView;

    @Inject
    public HomePresenter() {

    }

    @Override
    public void initialize() {
        Log.d(TAG, "Presenter initialize");
        mGetWomensCategories.execute(new MenuOptionsSubscriber(), new EmptyInteractorParams());
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
        mGetMensCategories.unsubscribe();
        mGetWomensCategories.unsubscribe();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void bind(HomeView view) {
        this.mView = view;
    }

    public void onClickNavBarWomensTab() {
        mGetWomensCategories.execute(new MenuOptionsSubscriber(), new EmptyInteractorParams());
    }

    public void onClickNavBarMensTab() {
        mGetMensCategories.execute(new MenuOptionsSubscriber(), new EmptyInteractorParams());
    }

    private class MenuOptionsSubscriber extends Subscriber<Categories> {
        private Categories mCategories;

        @Override
        public void onCompleted() {
            mView.setMenuCategories(mCategories);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onNext(Categories categories) {
            this.mCategories = categories;
        }
    }
}
