package uk.co.breaktek.asosdemo.data.mapping;

import javax.inject.Inject;
import javax.inject.Singleton;

import uk.co.breaktek.asosdemo.common.util.ListMappable;
import uk.co.breaktek.asosdemo.domain.enums.CategorySortType;
import uk.co.breaktek.asosdemo.domain.model.Categories;
import uk.co.breaktek.asosdemo.data.model.CategoriesEntity;
import uk.co.breaktek.asosdemo.domain.model.CategoryListings;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoriesEntityMapper extends ListMappable<CategoriesEntity, Categories> {
    @Inject CategoryListingEntityMapper mCategoryListingEntityMapper;

    @Inject
    public CategoriesEntityMapper() {

    }

    @Override
    public Categories transform(CategoriesEntity item) {
        Categories categories = null;
        if (item != null) {
            CategoryListings listings = new CategoryListings();
            listings.addAll(mCategoryListingEntityMapper.transform(item.categoryListings));
            categories = new Categories.CategoriesBuilder()
                    .description(item.description)
                    .sortType(resolveSortTypeEnum(item.sortType))
                    .categoryListings(listings)
                    .build();
        }
        return categories;
    }

    private CategorySortType resolveSortTypeEnum(String sortType) {
        switch (sortType) {
            case "AlphaAscending":
                return CategorySortType.ALPHA_ASCENDING;
            default:
                return CategorySortType.UNSORTED;
        }
    }
}
