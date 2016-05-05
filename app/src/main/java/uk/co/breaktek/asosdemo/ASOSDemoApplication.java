package uk.co.breaktek.asosdemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import uk.co.breaktek.asosdemo.di.component.global.ApplicationComponent;
import uk.co.breaktek.asosdemo.di.component.global.ApplicationComponentFactory;

/**
 * Base Application extension
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ASOSDemoApplication extends Application {
    public static final String TAG = ASOSDemoApplication.class.getSimpleName();
    private ApplicationComponent mAppComponent;

    public static ASOSDemoApplication get(Context context) {
        return (ASOSDemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Build application appComponent and inject it here so dependencies from it are available
        //Where dependencies are required call .inject(this) in the given class
        Log.d(TAG, "Setup Application Component");
        mAppComponent = ApplicationComponentFactory.create(this);
        getAppComponent().inject(this);
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }

    //Support for non-ART mutlidex
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
