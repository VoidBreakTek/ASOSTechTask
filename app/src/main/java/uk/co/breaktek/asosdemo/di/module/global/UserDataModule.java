package uk.co.breaktek.asosdemo.di.module.global;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.user.ProductFavouritesManager;
import uk.co.breaktek.asosdemo.user.SharedPrefsProductFavouritesManager;

/**
 * User data dependencies module
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class UserDataModule {
    private static final String SHARED_PREFS_KEY = "UserPrefs";
    private Context mContext;

    public UserDataModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    ProductFavouritesManager productFavouritesManager(SharedPreferences prefs) {
        return new SharedPrefsProductFavouritesManager(prefs);
    }

    @Provides
    @Singleton
    public SharedPreferences sharedPreferences() {
        return mContext.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
    }
}
