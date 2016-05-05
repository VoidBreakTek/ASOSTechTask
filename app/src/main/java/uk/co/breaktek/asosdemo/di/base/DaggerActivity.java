package uk.co.breaktek.asosdemo.di.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.breaktek.asosdemo.di.component.activity.ActivityComponent;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class DaggerActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = setupActivityComponent();
    }

    //Called in onCreate of subclasses to obtain activity dependencies
    protected abstract ActivityComponent setupActivityComponent();

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public Activity getActivity() {
        return this;
    }
}
