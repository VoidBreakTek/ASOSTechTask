package uk.co.breaktek.asosdemo.data.cache.reactive;

import android.content.Context;

import java.util.concurrent.atomic.AtomicBoolean;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmException;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

/**
 * Custom subscriber for use when accessing the Realm local data store
 * <p/>
 * Note: There is no shared interface between RealmList and RealmObject which are the intended uses
 * for this class hence the instanceof block in call
 * <p/>
 * Class based on:
 * https://realm.io/news/using-realm-with-rxjava/
 * with modifications from here to enable manual unsubscribe without Realm closed on wrong thread
 * exception
 * https://github.com/kboyarshinov/realm-rxjava-example/blob/master/app/src/main/java/com
 * /kboyarshinov/realmrxjavaexample/rx/OnSubscribeRealm.java
 */
public abstract class OnSubscribeRealm<T> implements Observable.OnSubscribe<T> {
    private Context context;

    private final AtomicBoolean canceled = new AtomicBoolean();
    private final Object lock = new Object();

    public OnSubscribeRealm(Context context) {
        this.context = context;
    }

    @Override
    public void call(final Subscriber<? super T> subscriber) {
        boolean withError = false;
        synchronized (lock) {
            boolean canceled = this.canceled.get();
            if (canceled) {
                return;
            }
        }

        subscriber.add(newUnsubscribeAction());

        final Realm realm = Realm.getInstance(new RealmConfiguration.Builder(context).build());

        T object = null;

        try {
            if (!this.canceled.get()) {
                realm.beginTransaction();
                object = get(realm);
                if (object != null && !this.canceled.get()) {
                    realm.commitTransaction();
                } else {
                    realm.cancelTransaction();
                }
            }
        } catch (RuntimeException e) {
            realm.cancelTransaction();
            subscriber.onError(new RealmException("Error during transaction.", e));
            e.printStackTrace();
            // Use error flag instead of return as need to hit the realm.close() block at the end
            // . Can't put in an unsubscribe block as may need to unsubscribe manually which will
            // occur in a different thread and cause a Realm exception.
            withError = true;
        } catch (Error e) {
            realm.cancelTransaction();
            subscriber.onError(e);
            withError = true;
        }

        if (object != null && !this.canceled.get() && !withError) {
            subscriber.onNext(object);
        }

        try {
            realm.close();
        } catch (RealmException ex) {
            subscriber.onError(ex);
            withError = true;
        }

        if (!withError) {
            subscriber.onCompleted();
        }

        this.canceled.set(false);
    }

    private Subscription newUnsubscribeAction() {
        return Subscriptions.create(new Action0() {
            @Override
            public void call() {
                synchronized (lock) {
                    canceled.set(true);
                }
            }
        });
    }

    public abstract T get(Realm realm);
}