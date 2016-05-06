package uk.co.breaktek.asosdemo.data.repository.category.datasource;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface CategoryDataStore {
    Observable<CategoriesEntity> mensCategories();

    Observable<CategoriesEntity> womensCategories();
}
