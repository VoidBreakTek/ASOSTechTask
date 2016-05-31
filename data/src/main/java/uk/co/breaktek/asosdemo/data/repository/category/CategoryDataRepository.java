package uk.co.breaktek.asosdemo.data.repository.category;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import uk.co.breaktek.asosdemo.data.mapping.CategoriesEntityMapper;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.domain.repository.CategoryRepository;
import uk.co.breaktek.asosdemo.data.repository.category.datasource.CategoryDataStoreFactory;

/**
 * Category repository. Handles Category data and chaining of related observables
 * <p/>
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
        return mDataStoreFactory.createLocalDataStore().mensCategories()
                .map(mapCategoriesEntityFunc);
    }

    @Override
    public Observable<Categories> womensCategories() {
        return mDataStoreFactory.createLocalDataStore().womensCategories()
                .map(mapCategoriesEntityFunc);
    }

    @Override
    public Observable refreshMensCategories() {
        return mDataStoreFactory.createCloudDataStore().mensCategories()
                .doOnNext(cacheMensCategoriesAction)
                //Ignore elements so onNext never called beyond the caching
                .ignoreElements();
    }

    @Override
    public Observable refreshWomensCategories() {
        return mDataStoreFactory.createCloudDataStore().womensCategories()
                .doOnNext(cacheWomensCategoriesAction)
                .ignoreElements();
    }

    private Action1<CategoriesEntity> cacheWomensCategoriesAction = new Action1<CategoriesEntity>() {
        @Override
        public void call(CategoriesEntity categories) {
            mDataStoreFactory.createLocalDataStore().clearCachedWomensCategories();
            mDataStoreFactory.createLocalDataStore().cacheCategories(categories);
        }
    };

    private Action1<CategoriesEntity> cacheMensCategoriesAction = new Action1<CategoriesEntity>() {
        @Override
        public void call(CategoriesEntity categories) {
            mDataStoreFactory.createLocalDataStore().clearCachedMensCategories();
            mDataStoreFactory.createLocalDataStore().cacheCategories(categories);
        }
    };

    private Func1<CategoriesEntity, Categories> mapCategoriesEntityFunc =
            new Func1<CategoriesEntity, Categories>() {
        @Override
        public Categories call(CategoriesEntity entity) {
            return mMapper.transform(entity);
        }
    };
}