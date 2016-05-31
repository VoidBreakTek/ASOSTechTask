package uk.co.breaktek.asosdemo.domain.repository;

import rx.Observable;
import uk.co.breaktek.asosdemo.domain.model.CategoryProductListings;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface ProductRepository {
    Observable<CategoryProductListings> categoryProductListings(String categoryId);
}
