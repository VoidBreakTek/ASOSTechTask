package uk.co.breaktek.asosdemo.data.net;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;

/**
 * Remote cloud provider interface
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface CloudProvider {
    Observable<CategoriesEntity> mensCategories();

    Observable<CategoriesEntity> womensCategories();
}
