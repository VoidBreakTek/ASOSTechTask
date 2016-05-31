package uk.co.breaktek.asosdemo.mvp;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface AndroidLifecyclePresenter<ViewType extends MvpView> extends Presenter<ViewType> {
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
