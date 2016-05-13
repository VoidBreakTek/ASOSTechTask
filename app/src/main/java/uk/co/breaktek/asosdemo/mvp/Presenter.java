package uk.co.breaktek.asosdemo.mvp;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface Presenter<ViewType extends MvpView> {
    void bind(ViewType view);
}