package uk.co.breaktek.asosdemo.mvp;

/**
 * Presenter interface for MVP cases where the view is a Fragment
 * Convenience class for view type safety
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface FragmentPresenter<FragmentViewType extends FragmentMvpView> extends AndroidLifecyclePresenter<FragmentViewType> {
    void detach();

    void attach();
}
