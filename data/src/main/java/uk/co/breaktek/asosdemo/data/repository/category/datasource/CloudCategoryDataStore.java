package uk.co.breaktek.asosdemo.data.repository.category.datasource;

import javax.inject.Inject;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.data.net.CloudProvider;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CloudCategoryDataStore implements CategoryDataStore {
    private final CloudProvider mCloudProvider;

    @Inject
    public CloudCategoryDataStore(CloudProvider cloudProvider) {
        this.mCloudProvider = cloudProvider;
    }

    @Override
    public Observable<CategoriesEntity> mensCategories() {
        return mCloudProvider.mensCategories();
    }

    @Override
    public Observable<CategoriesEntity> womensCategories() {
        return mCloudProvider.womensCategories();
    }
}