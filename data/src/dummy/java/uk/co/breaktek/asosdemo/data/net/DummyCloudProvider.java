package uk.co.breaktek.asosdemo.data.net;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import rx.Observable;
import rx.Subscriber;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.data.model.CategoryProductListingsEntity;
import uk.co.breaktek.asosdemo.domain.model.CategoryProductListings;

/**
 * Dummy cloud provider to build out UX before settling on a remote client implementation
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class DummyCloudProvider implements CloudProvider {
    public final static String TAG = DummyCloudProvider.class.getSimpleName();
    private final Context mContext;
    private final Gson mGson;

    public DummyCloudProvider(Context context, Gson gson) {
        this.mContext = context;
        this.mGson = gson;
    }

    @Override
    public Observable<CategoriesEntity> mensCategories() {
        return Observable.create(new Observable.OnSubscribe<CategoriesEntity>() {
            @Override
            public void call(Subscriber<? super CategoriesEntity> subscriber) {
                subscriber.onNext(getDummyCategories("dummy_mens_categories.json"));
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<CategoriesEntity> womensCategories() {
        return Observable.create(new Observable.OnSubscribe<CategoriesEntity>() {
            @Override
            public void call(Subscriber<? super CategoriesEntity> subscriber) {
                subscriber.onNext(getDummyCategories("dummy_womens_categories.json"));
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<CategoryProductListingsEntity> categoryProductListings(String categoryId) {
        return Observable.create(new Observable.OnSubscribe<CategoryProductListingsEntity>() {
            @Override
            public void call(Subscriber<? super CategoryProductListingsEntity> subscriber) {
                subscriber.onNext(getDummyCategoryProductListings("dummy_category_product_listings.json"));
                subscriber.onCompleted();
            }
        });
    }

    private CategoryProductListingsEntity getDummyCategoryProductListings(String jsonFilePath) {
        return mGson.fromJson(getDummyJsonString(jsonFilePath), CategoryProductListingsEntity.class);
    }

    private CategoriesEntity getDummyCategories(String jsonFilePath) {
        return mGson.fromJson(getDummyJsonString(jsonFilePath), CategoriesEntity.class);
    }

    private String getDummyJsonString(String jsonFilePath) {
        StringBuilder buf = new StringBuilder();
        InputStream json = null;
        try {
            json = mContext.getAssets().open(jsonFilePath);

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }

            in.close();
        } catch (IOException e) {
            Log.e(TAG, "Failed to read Dummy JSON asset file");
            e.printStackTrace();
        }
        return buf.toString();
    }
}