package uk.co.breaktek.asosdemo.data.repository.category.datasource;

import javax.inject.Singleton;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.cache.LocalDataProvider;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;

/**
 * Local implementation of the CategoryDataStore interface plus methods relating only to local data
 * like caching
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class LocalCategoryDataStore implements CategoryDataStore {
    private LocalDataProvider mLocalDataProvider;

    public LocalCategoryDataStore(LocalDataProvider localDataProvider) {
        this.mLocalDataProvider = localDataProvider;
    }

    @Override
    public Observable<CategoriesEntity> mensCategories() {
        return mLocalDataProvider.mensCategories();
    }

    @Override
    public Observable<CategoriesEntity> womensCategories() {
        return mLocalDataProvider.womensCategories();
    }

    public void clearCachedWomensCategories() {
        mLocalDataProvider.clearCachedWomensCategories();
    }

    public void clearCachedMensCategories() {
        mLocalDataProvider.clearCachedMensCategories();
    }

    public void cacheCategories(CategoriesEntity categoriesEntity) {
        mLocalDataProvider.cacheCategories(categoriesEntity);
    }
}
