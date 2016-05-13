package uk.co.breaktek.asosdemo.di.component.activity;

import dagger.Subcomponent;
import uk.co.breaktek.asosdemo.common.annotation.ActivityScope;
import uk.co.breaktek.asosdemo.di.component.fragment.ProductListComponent;
import uk.co.breaktek.asosdemo.di.module.activity.HomeModule;
import uk.co.breaktek.asosdemo.di.module.activity.SplashModule;
import uk.co.breaktek.asosdemo.di.module.fragment.ProductListModule;
import uk.co.breaktek.asosdemo.feature.home.HomeActivity;

/**
 * As a subcomponent, this Activity component inherits access to the root dependency tree as well as being able to access the additional dependencies in it's constituent modules
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@ActivityScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent extends ActivityComponent<HomeActivity> {
    ProductListComponent with(ProductListModule module);
}
