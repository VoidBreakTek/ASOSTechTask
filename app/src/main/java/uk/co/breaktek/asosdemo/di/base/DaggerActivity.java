package uk.co.breaktek.asosdemo.di.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import uk.co.breaktek.asosdemo.di.component.activity.ActivityComponent;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class DaggerActivity extends AppCompatActivity {
    public static final String TAG = DaggerActivity.class.getSimpleName();
    private ActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        mComponent = setupComponent();
    }

    //Called in onCreate of subclasses to obtain activity dependencies
    protected abstract ActivityComponent setupComponent();

    public ActivityComponent getActivityComponent() {
        return mComponent;
    }

    public Activity getActivity() {
        return this;
    }
}
