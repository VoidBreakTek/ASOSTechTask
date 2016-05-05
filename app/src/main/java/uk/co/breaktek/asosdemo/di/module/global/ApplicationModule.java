package uk.co.breaktek.asosdemo.di.module.global;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.ASOSDemoApplication;
import uk.co.breaktek.asosdemo.common.annotation.ApplicationContext;

/**
 * Dagger module to provide global dependencies
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class ApplicationModule {
    private final ASOSDemoApplication mApplication;

    public ApplicationModule(ASOSDemoApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideApplicationContext() {
        return mApplication;
    }
}