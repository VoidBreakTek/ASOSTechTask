package uk.co.breaktek.asosdemo.data.di;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.breaktek.asosdemo.data.net.CloudProvider;
import uk.co.breaktek.asosdemo.data.net.DummyCloudProvider;

/**
 * Dummy cloud provider module uses a local JSON file so can dev independent of network quickly from read in file JSON
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Module
public class CloudProviderModule implements BaseCloudProviderModule {
    private final Context mContext;

    public CloudProviderModule(Context context) {
        this.mContext = context;
    }

    @Override
    @Provides
    @Singleton
    public CloudProvider provideCloudProvider() {
        return new DummyCloudProvider(mContext);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        //Use a single Gson instance throughout this layer
        return new Gson();
    }
}
