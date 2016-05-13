package uk.co.breaktek.asosdemo.feature.home.productlist;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Subscriber;
import uk.co.breaktek.asosdemo.domain.interactor.GetCategoryProductListings;
import uk.co.breaktek.asosdemo.domain.interactor.Interactor;
import uk.co.breaktek.asosdemo.domain.model.CategoryProductListings;
import uk.co.breaktek.asosdemo.domain.model.ProductListing;
import uk.co.breaktek.asosdemo.mvp.FragmentPresenter;
import uk.co.breaktek.asosdemo.user.ProductFavouritesManager;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductListPresenter implements FragmentPresenter<ProductListView> {
    public static final String TAG = ProductListPresenter.class.getSimpleName();
    private ProductListView mView;
    private String mCategoryId;

    @Inject
    @Named("GetCategoryProductListings")
    Interactor mGetCategoryProductListings;

    @Inject
    ProductFavouritesManager mProductFavouritesManager;

    @Inject
    public ProductListPresenter() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {
        mGetCategoryProductListings.unsubscribe();
    }

    @Override
    public void destroy() {

    }

    public void initialize(String categoryId) {
        mCategoryId = categoryId;
        mView.setFavouriteIds(mProductFavouritesManager.getFavouriteProductIds());
        mGetCategoryProductListings.execute(new Subscriber<CategoryProductListings>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(CategoryProductListings categoryProductListings) {
                Log.d(TAG, "onNext");
                Log.d(TAG, categoryProductListings.toString());
                mView.setHeaderText(categoryProductListings.description);
                mView.setProductList(categoryProductListings.productListings);
            }
        }, new GetCategoryProductListings.Params(mCategoryId));
    }

    @Override
    public void bind(ProductListView view) {
        mView = view;
    }

    @Override
    public void detach() {

    }

    @Override
    public void attach() {

    }

    public void onProductListingSelected(ProductListing item) {
        mProductFavouritesManager.addFavouriteProduct(item.productId);
        mView.setFavouriteIds(mProductFavouritesManager.getFavouriteProductIds());
    }
}
