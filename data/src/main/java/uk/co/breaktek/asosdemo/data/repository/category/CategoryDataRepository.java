package uk.co.breaktek.asosdemo.data.repository.category;

import javax.inject.Singleton;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.Categories;
import uk.co.breaktek.asosdemo.data.repository.CategoryRepository;
import uk.co.breaktek.asosdemo.data.repository.category.datasource.CategoryDataStoreFactory;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class CategoryDataRepository implements CategoryRepository {
    private CategoryDataStoreFactory mCategoryDataStoreFactory;

    /*
    for women:
https://dl.dropboxusercontent.com/u/1559445/ASOS/SampleApi/cats_women.json
for men:
https://dl.dropboxusercontent.com/u/1559445/ASOS/SampleApi/cats_men.json
    */

    @Override
    public Observable<Categories> mensCategories() {
        //Any additional mapping can occur here in chained observables
        return mCategoryDataStoreFactory.createCloudDataStore().mensCategories();
    }

    @Override
    public Observable<Categories> womensCategories() {
        return mCategoryDataStoreFactory.createCloudDataStore().womensCategories();
    }
}
