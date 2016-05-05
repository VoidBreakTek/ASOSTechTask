package uk.co.breaktek.asosdemo.data.net;

import rx.Observable;
import uk.co.breaktek.asosdemo.data.model.Categories;

/**
 * Remote cloud provider interface
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface CloudProvider {
    Observable<Categories> mensCategories();

    Observable<Categories> womensCategories();
}
