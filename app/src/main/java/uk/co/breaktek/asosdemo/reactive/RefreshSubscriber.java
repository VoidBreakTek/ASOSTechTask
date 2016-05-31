package uk.co.breaktek.asosdemo.reactive;

import rx.Subscriber;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class RefreshSubscriber extends Subscriber {
    @Override
    public final void onCompleted() {
        onRefreshed();
    }

    public abstract void onRefreshed();

    @Override
    public abstract void onError(Throwable e);

    @Override
    public final void onNext(Object o) {

    }
}
