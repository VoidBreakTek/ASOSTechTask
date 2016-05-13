package uk.co.breaktek.asosdemo.di.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import uk.co.breaktek.asosdemo.di.component.fragment.FragmentComponent;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class DaggerFragment extends Fragment {
    private FragmentComponent mComponent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mComponent = setupComponent();
    }

    //Called in onCreate of subclasses to obtain activity dependencies
    protected abstract FragmentComponent setupComponent();

    public FragmentComponent getFragmentComponent() {
        return mComponent;
    }

}
