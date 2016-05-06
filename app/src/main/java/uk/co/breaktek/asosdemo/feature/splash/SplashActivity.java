package uk.co.breaktek.asosdemo.feature.splash;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import uk.co.breaktek.asosdemo.ASOSDemoApplication;
import uk.co.breaktek.asosdemo.R;
import uk.co.breaktek.asosdemo.di.base.DaggerActivity;
import uk.co.breaktek.asosdemo.di.base.MvpActivity;
import uk.co.breaktek.asosdemo.di.component.activity.ActivityComponent;
import uk.co.breaktek.asosdemo.di.component.activity.SplashComponent;
import uk.co.breaktek.asosdemo.di.module.activity.SplashModule;
import uk.co.breaktek.asosdemo.mvp.ActivityPresenter;

public class SplashActivity extends MvpActivity implements SplashView {
    private final Handler mHandler = new Handler();

    private final Runnable mHomeScreenRunnable = new Runnable() {
        @Override
        public void run() {
            startHomeActivity();
            SplashActivity.this.finish();
        }
    };

    @Inject
    SplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mPresenter.bind(this);
        mPresenter.initialize();
    }

    @Override
    protected ActivityComponent setupActivityComponent() {
        // Here the Activity's SubComponent is constructed with the base Application Component as
        // it's parent. This allows access to the global dependencies supplied by the Application
        // Component's modules.
        SplashComponent component = ASOSDemoApplication.get(this)
                .getAppComponent()
                .with(new SplashModule(this));

        component.inject(this);
        return component;
    }

    @Override
    public void showHomeScreen(int delayMs) {
        mHandler.postDelayed(mHomeScreenRunnable, delayMs);
    }

    @Override
    public void showRefreshFailedError() {
        Toast.makeText(this, getString(R.string.activity_splash_refresh_error_toast_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void closeApp() {
        Log.i(TAG, "closeApp");
        finish();
    }

    private void startHomeActivity() {
//        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mHomeScreenRunnable);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // This Activity is finished when Paused as a precaution so the Splash screen cannot be
        // interrupted when backgrounded to ensure a full, stable startup is completed before
        // continuing
        finish();
    }

    @Override
    protected ActivityPresenter getPresenter() {
        return mPresenter;
    }
}
