package uk.co.breaktek.asosdemo.mvp.base;

import android.os.Bundle;
import android.util.Log;

import uk.co.breaktek.asosdemo.di.base.DaggerActivity;
import uk.co.breaktek.asosdemo.mvp.ActivityMvpView;
import uk.co.breaktek.asosdemo.mvp.ActivityPresenter;

/**
 * Base Activity to pass Activity lifecycle events to bound presenter
 * Extends DaggerActivity as DaggerActivity onCreate will inject the presenter
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class MvpActivity extends DaggerActivity implements ActivityMvpView {
    public static final String TAG = MvpActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        bindPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().destroy();
    }

    protected abstract ActivityPresenter getPresenter();

    protected abstract void bindPresenter();
}
