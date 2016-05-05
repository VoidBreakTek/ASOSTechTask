package uk.co.breaktek.asosdemo.feature.splash;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import uk.co.breaktek.asosdemo.mvp.ActivityPresenter;

/**
 * MVP Presenter for Splash screen. May seem excessive in this demo but would perform any startup
 * logic such as connectivity checks or retrieving remote config data such as feature switches.
 * <p>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class SplashPresenter implements ActivityPresenter<SplashView> {
    public static final String TAG = SplashPresenter.class.getSimpleName();
    private static int SPLASH_TIME_OUT = 1500;

    private SplashView mView;

    @Inject
    public SplashPresenter() {
        // Empty constructor with @Inject annotation allows Dagger to construct new instances on
        // request without an explicit module @Provides method

    }

    @Override
    public void initialize() {
        Log.d(TAG, "Presenter initialize");
        mView.showHomeScreen(SPLASH_TIME_OUT);
    }

    @Override
    public void bind(SplashView view) {
        this.mView = view;
    }

    @Override
    public void resume() {
        Log.d(TAG, "Presenter resume");
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
