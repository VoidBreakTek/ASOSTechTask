package uk.co.breaktek.asosdemo.data;

import java.util.ArrayList;
import java.util.List;

import uk.co.breaktek.asosdemo.domain.enums.CategorySortType;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.domain.model.CategoryListing;
import uk.co.breaktek.asosdemo.data.model.CategoryListingEntity;
import uk.co.breaktek.asosdemo.domain.model.CategoryListings;

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
        CategoryListingEntity item = new CategoryListingEntity();
        item.setCategoryId(categoryId);
        item.setCategoryName(name);
        item.setProductCount(productCount);
        return item;
    }

    public static CategoriesEntity categoriesEntity1() {
        List<CategoryListingEntity> listings = new ArrayList();
        listings.add(categoryListingEntity1());

        CategoriesEntity item = new CategoriesEntity();
        item.setDescription(description);
        item.setSortType(sortType);
        item.setCategoryListings(listings);
        return item;
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
