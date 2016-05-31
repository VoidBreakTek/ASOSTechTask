package uk.co.breaktek.asosdemo.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import uk.co.breaktek.asosdemo.di.base.DaggerFragment;
import uk.co.breaktek.asosdemo.mvp.FragmentMvpView;
import uk.co.breaktek.asosdemo.mvp.FragmentPresenter;

/**
 * Base Fragment to pass Fragment lifecycle events to bound presenter
 * Extends DaggerFragment as DaggerFragment onCreate will inject the presenter
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class MvpFragment extends DaggerFragment implements FragmentMvpView {
    public static final String TAG = MvpFragment.class.getSimpleName();

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().destroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        bindPresenter();
        getPresenter().attach();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getPresenter().detach();
    }

    protected abstract FragmentPresenter getPresenter();

    protected abstract void bindPresenter();
}
