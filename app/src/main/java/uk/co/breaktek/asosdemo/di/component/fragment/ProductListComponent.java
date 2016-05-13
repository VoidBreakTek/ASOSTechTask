package uk.co.breaktek.asosdemo.di.component.fragment;

import dagger.Subcomponent;
import uk.co.breaktek.asosdemo.common.annotation.FragmentScope;
import uk.co.breaktek.asosdemo.di.module.fragment.ProductListModule;
import uk.co.breaktek.asosdemo.feature.home.productlist.ProductListFragment;

/**
 * As a subcomponent, this Fragment component inherits access to the root dependency tree, it's parent DaggerActivity's dependency tree and is able to access the additional dependencies in it's constituent modules
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@FragmentScope
@Subcomponent(modules = ProductListModule.class)
public interface ProductListComponent extends FragmentComponent<ProductListFragment> {
}
