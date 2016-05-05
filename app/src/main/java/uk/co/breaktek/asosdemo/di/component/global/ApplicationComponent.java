package uk.co.breaktek.asosdemo.di.component.global;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.breaktek.asosdemo.ASOSDemoApplication;
import uk.co.breaktek.asosdemo.common.annotation.ApplicationContext;
import uk.co.breaktek.asosdemo.di.module.global.ApplicationModule;

/**
 * Root application component to be initialized on startup from the base extended Application
 * instance
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(ASOSDemoApplication application);

    @ApplicationContext
    Context context();

//    SplashComponent with(SplashModule module);
//
//    HomeComponent with(HomeModule module);
}
