package uk.co.breaktek.asosdemo.user;

import java.util.Set;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public interface ProductFavouritesManager {
    /**
     * Returns a list of product IDs which have been previously marked as favourites
     */
    Set<Long> getFavouriteProductIds();

    boolean addFavouriteProduct(long productId);

    boolean removeFavouriteProduct(long productId);
}
