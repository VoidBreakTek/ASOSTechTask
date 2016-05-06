package uk.co.breaktek.asosdemo.data.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.data.cache.LocalDataProvider;
import uk.co.breaktek.asosdemo.data.cache.RealmLocalDataProvider;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class LocalDataProviderModule {
    private final Context mContext;

    public LocalDataProviderModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public LocalDataProvider provideLocalDataProvider() {
        return new RealmLocalDataProvider(mContext);
    }
}
