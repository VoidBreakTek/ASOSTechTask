package uk.co.breaktek.asosdemo.data.repository.product.datasource;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.CategoryProductListingsEntity;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface ProductDataStore {
    Observable<CategoryProductListingsEntity> categoryProductListings(String categoryId);
}
