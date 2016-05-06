package uk.co.breaktek.asosdemo.feature.home;

import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.mvp.ActivityMvpView;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface HomeView extends ActivityMvpView {
    void setMenuCategories(Categories categories);
}
