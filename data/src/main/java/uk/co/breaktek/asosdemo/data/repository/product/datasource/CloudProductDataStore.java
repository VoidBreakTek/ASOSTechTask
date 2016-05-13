package uk.co.breaktek.asosdemo.data.repository.product.datasource;

import javax.inject.Inject;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.CategoryProductListingsEntity;
import uk.co.breaktek.asosdemo.data.net.CloudProvider;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CloudProductDataStore implements ProductDataStore {
    private final CloudProvider mCloudProvider;

    @Inject
    public CloudProductDataStore(CloudProvider cloudProvider) {
        this.mCloudProvider = cloudProvider;
    }

    @Override
    public Observable<CategoryProductListingsEntity> categoryProductListings(String categoryId) {
        return mCloudProvider.categoryProductListings(categoryId);
    }
}
