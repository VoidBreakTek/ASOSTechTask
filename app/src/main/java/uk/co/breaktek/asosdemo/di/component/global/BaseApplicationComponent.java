package uk.co.breaktek.asosdemo.di.component.global;

import android.content.Context;

import uk.co.breaktek.asosdemo.ASOSDemoApplication;
import uk.co.breaktek.asosdemo.common.annotation.ApplicationContext;
import uk.co.breaktek.asosdemo.di.component.activity.SplashComponent;
import uk.co.breaktek.asosdemo.di.module.activity.SplashModule;

/**
 * Base application interface to be extended by build variant flavors
 *
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface BaseApplicationComponent {
    void inject(ASOSDemoApplication application);

    @ApplicationContext
    Context context();

    SplashComponent with(SplashModule module);
}
