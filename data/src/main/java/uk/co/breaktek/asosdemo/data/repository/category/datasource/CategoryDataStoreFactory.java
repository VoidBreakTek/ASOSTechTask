package uk.co.breaktek.asosdemo.data.repository.category.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

import uk.co.breaktek.asosdemo.data.cache.LocalDataProvider;
import uk.co.breaktek.asosdemo.data.net.CloudProvider;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class CategoryDataStoreFactory {
    private final CloudProvider mCloudProvider;
    private final LocalDataProvider mLocalDataProvider;

    @Inject
    public CategoryDataStoreFactory(CloudProvider cloudProvider,
                                    LocalDataProvider localDataProvider) {
        this.mCloudProvider = cloudProvider;
        //For if we want to add cached data later
        this.mLocalDataProvider = localDataProvider;
    }

    public CloudCategoryDataStore createCloudDataStore() {
        return new CloudCategoryDataStore(mCloudProvider);
    }

    public LocalCategoryDataStore createLocalDataStore() {
        return new LocalCategoryDataStore(mLocalDataProvider);
    }
}