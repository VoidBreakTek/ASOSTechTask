package uk.co.breaktek.asosdemo.mvp;

/**
 * Presenter interface for MVP cases where the view is full Activity
 * Convenience class for view type safety
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface ActivityPresenter<ActivityViewType extends ActivityMvpView> extends AndroidLifecyclePresenter<ActivityViewType> {
}
