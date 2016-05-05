package uk.co.breaktek.asosdemo.data.net;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.inject.Inject;

import dagger.Module;
import rx.Observable;
import rx.Subscriber;
import uk.co.breaktek.asosdemo.data.mapping.CategoriesEntityMapper;
import uk.co.breaktek.asosdemo.data.model.Categories;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;

/**
 * Dummy cloud provider to build out UX before settling on a remote client implementation
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class DummyCloudProvider implements CloudProvider {
    public final static String TAG = DummyCloudProvider.class.getSimpleName();
    private final Context mContext;

    @Inject Gson mGson;
    @Inject CategoriesEntityMapper mCategoriesEntityMapper;

    public DummyCloudProvider(Context context) {
        this.mContext = context;
    }

    @Override
    public Observable<Categories> mensCategories() {
        return Observable.create(new Observable.OnSubscribe<Categories>() {
            @Override
            public void call(Subscriber<? super Categories> subscriber) {
                mCategoriesEntityMapper.transform(getDummyCategories());
            }
        });
    }

    @Override
    public Observable<Categories> womensCategories() {
        return null;
    }

    private CategoriesEntity getDummyCategories() {
        return mGson.fromJson(getDummyJsonString(), CategoriesEntity.class);
    }

    private String getDummyJsonString() {
        StringBuilder buf = new StringBuilder();
        InputStream json = null;
        try {
            json = mContext.getAssets().open("dummy_dev_categories.json");

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