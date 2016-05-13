package uk.co.breaktek.asosdemo.user;

import android.content.SharedPreferences;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implementation of product favourites manager using local shared preferences for storage
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class SharedPrefsProductFavouritesManager implements ProductFavouritesManager {
    private final SharedPreferences mSharedPrefs;
    private static final String PREFS_KEY_FAVOURITE_PRODUCTS = "favourite_products";

    public SharedPrefsProductFavouritesManager(SharedPreferences preferences) {
        this.mSharedPrefs = preferences;
    }

    @Override
    public Set<Long> getFavouriteProductIds() {
        Set<String> stringIds = getFavouriteProductIdStrings();
        Set<Long> longIds = new LinkedHashSet<>();
        for (String id : stringIds) {
            try {
                longIds.add(Long.parseLong(id));
            } catch (NumberFormatException ignore) {
            }
        }
        return longIds;
    }

    private Set<String> getFavouriteProductIdStrings() {
        return mSharedPrefs.getStringSet(PREFS_KEY_FAVOURITE_PRODUCTS, new LinkedHashSet<String>());
    }

    @Override
    public boolean addFavouriteProduct(long productId) {
        Set<String> favourites = getFavouriteProductIdStrings();
        boolean edited = favourites.add(Long.toString(productId));
        if (edited) {
            storeFavourites(favourites);
        }
        return edited;
    }

    @Override
    public boolean removeFavouriteProduct(long productId) {
        Set<String> favourites = getFavouriteProductIdStrings();
        boolean edited = favourites.remove(Long.toString(productId));
        if (edited) {
            storeFavourites(favourites);
        }
        return edited;
    }

    private void storeFavourites(Set<String> favouriteProductIds) {
        mSharedPrefs.edit().putStringSet(PREFS_KEY_FAVOURITE_PRODUCTS, favouriteProductIds).commit();
    }
}
