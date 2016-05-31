package uk.co.breaktek.asosdemo.di.component.fragment;

import uk.co.breaktek.asosdemo.mvp.base.MvpFragment;

/**
 * Base DaggerFragment component interface to reference an Fragment's component in the abstract DaggerFragment base class
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface FragmentComponent<FragmentType extends MvpFragment> {
    void inject(FragmentType fragment);
}
