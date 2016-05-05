package uk.co.breaktek.asosdemo.data.di;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.data.mapping.CategoriesEntityMapper;
import uk.co.breaktek.asosdemo.data.net.CloudProvider;
import uk.co.breaktek.asosdemo.data.net.DummyCloudProvider;

/**
 * Dummy cloud provider module uses a local JSON file so can dev independent of network quickly
 * from read in file JSON
 * <p>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class CloudProviderModule {
    private final Context mContext;

    public CloudProviderModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public CloudProvider provideCloudProvider(Gson gson, CategoriesEntityMapper mapper) {
        return new DummyCloudProvider(mContext, gson, mapper);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        //Use a single Gson instance throughout this layer
        return new Gson();
    }
}
