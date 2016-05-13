package uk.co.breaktek.asosdemo.di.component.activity;

import uk.co.breaktek.asosdemo.di.base.DaggerActivity;

/**
 * Base DaggerActivity component interface to reference an Activities component in the abstract DaggerActivity base class
 * <p>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface ActivityComponent<ActivityType extends DaggerActivity> {
    void inject(ActivityType activity);
}
