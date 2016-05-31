package uk.co.breaktek.asosdemo.di.module.fragment;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.common.annotation.FragmentScope;
import uk.co.breaktek.asosdemo.feature.home.productlist.ProductListFragment;
import uk.co.breaktek.asosdemo.feature.home.productlist.ProductListView;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class ProductListModule {
    ProductListFragment mFragment;

    public ProductListModule(ProductListFragment fragment) {
        this.mFragment = fragment;
    }

    @FragmentScope
    @Provides
    ProductListView view() {
        return mFragment;
    }
}
