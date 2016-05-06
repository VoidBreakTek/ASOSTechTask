package uk.co.breaktek.asosdemo.di.component.activity;
import dagger.Subcomponent;
import uk.co.breaktek.asosdemo.common.annotation.ActivityScope;
import uk.co.breaktek.asosdemo.di.module.activity.SplashModule;
import uk.co.breaktek.asosdemo.feature.splash.SplashActivity;

/**
 * Dagger2 component for Splash screen
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@ActivityScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent extends ActivityComponent {
    void inject(SplashActivity activity);
}
