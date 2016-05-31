package uk.co.breaktek.asosdemo.data.repository.product.datasource;

import javax.inject.Inject;

import uk.co.breaktek.asosdemo.data.net.CloudProvider;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductDataStoreFactory {
    private final CloudProvider mCloudProvider;

    @Inject
    public ProductDataStoreFactory(CloudProvider cloudProvider) {
        this.mCloudProvider = cloudProvider;
    }

    public CloudProductDataStore createCloudDataStore() {
        return new CloudProductDataStore(mCloudProvider);
    }
}
