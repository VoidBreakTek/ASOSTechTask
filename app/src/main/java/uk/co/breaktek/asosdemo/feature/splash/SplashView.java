package uk.co.breaktek.asosdemo.feature.splash;

import uk.co.breaktek.asosdemo.mvp.ActivityMvpView;

/**
 * MVP view interface for Splash screen
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface SplashView extends ActivityMvpView {
    /**
     * Open the home screen with a given delay
     *
     * @param delayMs Delay in milliseconds
     */
    void showHomeScreen(int delayMs);

    void showRefreshFailedError();

    void closeApp();
}
