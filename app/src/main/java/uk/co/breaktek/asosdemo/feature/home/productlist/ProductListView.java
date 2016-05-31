package uk.co.breaktek.asosdemo.feature.home.productlist;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.Set;

import uk.co.breaktek.asosdemo.domain.model.ProductListing;
import uk.co.breaktek.asosdemo.mvp.FragmentMvpView;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface ProductListView extends FragmentMvpView {
    void setHeaderText(@NonNull String headerText);

    void setProductList(@NonNull List<ProductListing> productList);

    void setFavouriteIds(@NonNull Set<Long> favouriteIds);
}
