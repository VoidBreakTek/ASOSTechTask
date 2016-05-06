package uk.co.breaktek.asosdemo.di.component.activity;

import dagger.Subcomponent;
import uk.co.breaktek.asosdemo.common.annotation.ActivityScope;
import uk.co.breaktek.asosdemo.di.module.activity.HomeModule;
import uk.co.breaktek.asosdemo.di.module.activity.SplashModule;
import uk.co.breaktek.asosdemo.feature.home.HomeActivity;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@ActivityScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent extends ActivityComponent {
    void inject(HomeActivity activity);
}
