package uk.co.breaktek.asosdemo.data;

import java.util.ArrayList;
import java.util.List;

import uk.co.breaktek.asosdemo.data.enums.CategorySortType;
import uk.co.breaktek.asosdemo.data.model.Categories;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.data.model.CategoryListing;
import uk.co.breaktek.asosdemo.data.model.CategoryListingEntity;
import uk.co.breaktek.asosdemo.data.model.CategoryListings;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryTestModelConstants {
    public static String description = "DESCRIPTION";
    public static String categoryId = "CATEGORYID";
    public static String name = "NAME";
    public static int productCount = 101;
    public static String sortType = "AlphaAscending";
    public static CategorySortType sortTypeEnum = CategorySortType.ALPHA_ASCENDING;

    public static String categoryTestJson() {
        return "{\"Description\":\"" + description + "\",\"Listing\":[{\"CategoryId\":\"" + categoryId + "\",\"Name\":\"" + name + "\",\"ProductCount\":" + productCount + "}],\"SortType\":\"" + sortType + "\"}";
    }

    public static CategoryListingEntity categoryListingEntity1() {
        return new CategoryListingEntity(categoryId, name, productCount);
    }

    public static CategoriesEntity categoriesEntity1() {
        List<CategoryListingEntity> listings = new ArrayList();
        listings.add(categoryListingEntity1());
        return new CategoriesEntity(description, sortType, listings);
    }

    public static CategoryListing categoryListing1() {
        return new CategoryListing.CategoryListingBuilder()
                .name(name)
                .productCount(productCount)
                .id(categoryId)
                .build();
    }

    public static CategoryListings categoryListings1() {
        CategoryListings listings = new CategoryListings();
        listings.add(categoryListing1());
        return listings;
    }

    public static List<CategoryListing> categoryListingsList1() {
        List<CategoryListing> listings = new ArrayList<>();
        listings.add(categoryListing1());
        return listings;
    }

    public static Categories categories1() {
        List<CategoryListing> listings = new ArrayList();
        listings.add(categoryListing1());
        return new Categories.CategoriesBuilder()
                .description(description)
                .sortType(sortTypeEnum)
                .categoryListings(categoryListings1())
                .build();
    }
}
