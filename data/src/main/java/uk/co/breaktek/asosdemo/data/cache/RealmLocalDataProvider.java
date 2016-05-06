package uk.co.breaktek.asosdemo.data.cache;

import android.content.Context;

import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import rx.Observable;
import rx.functions.Func1;
import uk.co.breaktek.asosdemo.data.cache.reactive.RealmObservable;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;

/**
 * Realm local data cache provider implementation to store and retrieve from the local cache
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class RealmLocalDataProvider implements LocalDataProvider {
    private static final String TAG = RealmLocalDataProvider.class.getSimpleName();
    //Replace with enum
    private static final String CATEGORIES_DESCRIPTION_MEN = "MEN";
    private static final String CATEGORIES_DESCRIPTION_WOMEN = "WOMEN";

    private Context mAppContext;
    private RealmConfiguration mRealmConfiguration;

    public RealmLocalDataProvider(Context context) {
        mAppContext = context;
        mRealmConfiguration = new RealmConfiguration.Builder(mAppContext).build();
    }

    private void create(RealmModel model) {
        Realm realm = Realm.getInstance(mRealmConfiguration);
        try {
            realm.beginTransaction();
            realm.copyToRealm(model);
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

    private CategoriesEntity retrieveCategoriesWithDescription(String description) {
        Realm realm = Realm.getInstance(mRealmConfiguration);
        try {
            CategoriesEntity entity = realm.where(CategoriesEntity.class)
                    .equalTo("description", description)
                    .findFirst();
            realm.commitTransaction();
            return entity;
        } finally {
            realm.close();
        }
    }

    private void deleteCategoriesWithDescription(String description) {
        Realm realm = Realm.getInstance(mRealmConfiguration);
        try {
            realm.beginTransaction();
            realm.where(CategoriesEntity.class)
                    .equalTo("description", description)
                    .findAll()
                    .deleteAllFromRealm();
            realm.commitTransaction();
        } finally {
            realm.close();
        }
    }

    @Override
    public Observable<CategoriesEntity> mensCategories() {
        return RealmObservable.object(mAppContext, new Func1<Realm, CategoriesEntity>() {
            @Override
            public CategoriesEntity call(Realm realm) {
                return retrieveCategoriesWithDescription(CATEGORIES_DESCRIPTION_MEN);
            }
        });
    }

    @Override
    public Observable<CategoriesEntity> womensCategories() {
        return RealmObservable.object(mAppContext, new Func1<Realm, CategoriesEntity>() {
            @Override
            public CategoriesEntity call(Realm realm) {
                return retrieveCategoriesWithDescription(CATEGORIES_DESCRIPTION_WOMEN);
            }
        });
    }

    @Override
    public void clearCachedMensCategories() {
        deleteCategoriesWithDescription(CATEGORIES_DESCRIPTION_MEN);
    }

    @Override
    public void clearCachedWomensCategories() {
        deleteCategoriesWithDescription(CATEGORIES_DESCRIPTION_WOMEN);
    }

    @Override
    public void cacheCategories(CategoriesEntity categories) {
        create(categories);
    }
}
