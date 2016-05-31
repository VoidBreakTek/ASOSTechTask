package uk.co.breaktek.asosdemo.data.repository.product;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;
import uk.co.breaktek.asosdemo.data.mapping.CategoryProductListingsEntityMapper;
import uk.co.breaktek.asosdemo.data.model.CategoryProductListingsEntity;
import uk.co.breaktek.asosdemo.data.repository.product.datasource.ProductDataStoreFactory;
import uk.co.breaktek.asosdemo.domain.model.CategoryProductListings;
import uk.co.breaktek.asosdemo.domain.repository.ProductRepository;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class ProductDataRepository implements ProductRepository {
    ProductDataStoreFactory mDataStoreFactory;
    CategoryProductListingsEntityMapper mMapper;

    @Inject
    public ProductDataRepository(ProductDataStoreFactory dataStoreFactory,
                                 CategoryProductListingsEntityMapper mMapper) {
        this.mDataStoreFactory = dataStoreFactory;
        this.mMapper = mMapper;
    }

    @Override
    public Observable<CategoryProductListings> categoryProductListings(String categoryId) {
        return mDataStoreFactory.createCloudDataStore().categoryProductListings(categoryId)
                .map(mapCategoryProductListingsFunc);
    }

    private Func1<CategoryProductListingsEntity, CategoryProductListings> mapCategoryProductListingsFunc
            = new Func1<CategoryProductListingsEntity, CategoryProductListings>() {
        @Override
        public CategoryProductListings call(CategoryProductListingsEntity entity) {
            return mMapper.transform(entity);
        }
    };
}
