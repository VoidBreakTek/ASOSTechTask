package uk.co.breaktek.asosdemo.data.repository.category;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.mapping.CategoriesEntityMapper;
import uk.co.breaktek.asosdemo.data.model.Categories;
import uk.co.breaktek.asosdemo.data.repository.CategoryRepository;
import uk.co.breaktek.asosdemo.data.repository.category.datasource.CategoryDataStoreFactory;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class CategoryDataRepository implements CategoryRepository {
    CategoryDataStoreFactory mDataStoreFactory;
    CategoriesEntityMapper mMapper;

    @Inject
    public CategoryDataRepository(CategoryDataStoreFactory dataStoreFactory,
                                  CategoriesEntityMapper mapper) {
        this.mDataStoreFactory = dataStoreFactory;
        this.mMapper = mapper;
    }

    @Override
    public Observable<Categories> mensCategories() {
        //Any additional mapping can occur here in chained observables
        return mDataStoreFactory.createCloudDataStore().mensCategories();
    }

    @Override
    public Observable<Categories> womensCategories() {
        return mDataStoreFactory.createCloudDataStore().womensCategories();
    }
}
