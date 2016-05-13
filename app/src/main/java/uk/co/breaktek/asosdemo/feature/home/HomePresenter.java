package uk.co.breaktek.asosdemo.feature.home;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Subscriber;
import uk.co.breaktek.asosdemo.domain.interactor.EmptyInteractorParams;
import uk.co.breaktek.asosdemo.domain.interactor.Interactor;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.domain.model.CategoryListing;
import uk.co.breaktek.asosdemo.mvp.ActivityPresenter;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class HomePresenter implements ActivityPresenter<HomeView> {
    public static final String TAG = HomePresenter.class.getSimpleName();
    private Categories mCurrentlyShownCategories;

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
        mView = view;
    }


    public void onNavigationCategorySelected(NavigationCategory navigationCategory) {
        switch (navigationCategory) {
            case MENS:
                mGetWomensCategories.execute(new MenuOptionsSubscriber(), new EmptyInteractorParams());
                break;
            case WOMENS:
                mGetMensCategories.execute(new MenuOptionsSubscriber(), new EmptyInteractorParams());
                break;
        }
    }

    public String getMenuCategoryId(int index) {
        return mCurrentlyShownCategories.getCategoryListings().get(index).getCategoryId();
    }

    private class MenuOptionsSubscriber extends Subscriber<Categories> {
        private Categories mCategories;

        @Override
        public void onCompleted() {
            mCurrentlyShownCategories = mCategories;
            mView.showMenuCategories(mCategories);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onNext(Categories categories) {
            mCategories = categories;
        }
    }
}
