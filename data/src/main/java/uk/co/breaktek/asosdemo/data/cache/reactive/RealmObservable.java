package uk.co.breaktek.asosdemo.data.cache.reactive;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmModel;
import rx.Observable;
import rx.functions.Func1;

/**
 * https://realm.io/news/using-realm-with-rxjava/
 */
public final class RealmObservable {
    private RealmObservable() {
    }

    public static <T extends RealmModel> Observable<T> object(Context context, final Func1<Realm, T> function) {
        return Observable.create(new OnSubscribeRealm<T>(context) {
            @Override
            public T get(Realm realm) {
                return function.call(realm);
            }
        });
    }

    public static <T extends RealmList> Observable<T> list(Context context, final Func1<Realm, T> function) {
        return Observable.create(new OnSubscribeRealm<T>(context) {
            @Override
            public T get(Realm realm) {
                return function.call(realm);
            }
        });
    }
}
