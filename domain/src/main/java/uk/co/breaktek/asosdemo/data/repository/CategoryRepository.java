package uk.co.breaktek.asosdemo.data.repository;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.Categories;

/**
 * Repository pattern interface for Categories data
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface CategoryRepository {
    /**
     * Get men's Categories data in full Categories data in full
     */
    Observable<Categories> mensCategories();

    /**
     * Get observable to retrieve women's Categories data in full
     */
    Observable<Categories> womensCategories();
}
