package uk.co.breaktek.asosdemo.data.repository.category.datasource;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.Categories;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface CategoryDataStore {
    Observable<Categories> mensCategories();
    Observable<Categories> womensCategories();
}
