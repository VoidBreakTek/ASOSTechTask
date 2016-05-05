package uk.co.breaktek.asosdemo.mvp;

/**
 * Presenter interface for MVP cases where the view is full Activity
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface ActivityPresenter<ActivityViewType extends ActivityMvpView> extends Presenter<ActivityViewType> {
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();
}
