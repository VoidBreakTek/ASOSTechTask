package uk.co.breaktek.asosdemo.data.cache;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;

/**
 * Local cache provider interface
 * <p>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface LocalDataProvider {
    Observable<CategoriesEntity> mensCategories();

    Observable<CategoriesEntity> womensCategories();

    void clearCachedMensCategories();

    void clearCachedWomensCategories();

    void cacheCategories(CategoriesEntity categories);
}
