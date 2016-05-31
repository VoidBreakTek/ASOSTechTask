package uk.co.breaktek.asosdemo.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Base interactor class to provide access to the data layer from the presenter layer. Acts as a
 * wrapper for creating and executing rx actions.
 */
public abstract class Interactor<T extends InteractorParams> {
    private static final String TAG = Interactor.class.getSimpleName();
    private final Scheduler mSubscribeOnScheduler;
    private final Scheduler mObserveOnScheduler;

    private Subscription subscription = Subscriptions.empty();

    protected Interactor(Scheduler subscribeOnScheduler, Scheduler observeOnScheduler) {
        this.mSubscribeOnScheduler = subscribeOnScheduler;
        this.mObserveOnScheduler = observeOnScheduler;
    }

    /**
     * Builds an {@Link rx.Observable} which is used when executing this {@Link Interactor}
     */
    protected abstract Observable buildInteractorObservable(T params);

    public void execute(Subscriber interactorSubscriber, T interactorParams) {
        //Unsubscribe first if there is an active subscription in case the user hammerclicks as
        // subscriptions will be leaked
        if (this.subscription != Subscriptions.empty()) {
            this.subscription.unsubscribe();
        }

        this.subscription = this.buildInteractorObservable(interactorParams)
                .subscribeOn(mSubscribeOnScheduler)
                .observeOn(mObserveOnScheduler)
                .subscribe(interactorSubscriber);
    }

    /**
     * Unsubscribes from current {@Link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!this.subscription.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
    }
}