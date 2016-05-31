package uk.co.breaktek.asosdemo.data.net;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.data.model.CategoryProductListingsEntity;
import uk.co.breaktek.asosdemo.domain.model.CategoryProductListings;

/**
 * Remote cloud provider interface
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface CloudProvider {
    Observable<CategoriesEntity> mensCategories();

    Observable<CategoriesEntity> womensCategories();

    Observable<CategoryProductListingsEntity> categoryProductListings(String categoryId);
}
