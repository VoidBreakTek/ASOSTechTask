package uk.co.breaktek.asosdemo.data.mapping;

import javax.inject.Inject;
import javax.inject.Singleton;

import uk.co.breaktek.asosdemo.common.util.ListMappable;
import uk.co.breaktek.asosdemo.data.model.CategoryListing;
import uk.co.breaktek.asosdemo.data.model.CategoryListingEntity;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@Singleton
public class CategoryListingEntityMapper extends ListMappable<CategoryListingEntity, CategoryListing> {
    @Inject
    public CategoryListingEntityMapper() {

    }

    @Override
    public CategoryListing transform(CategoryListingEntity item) {
        CategoryListing listing = null;
        if (item != null) {
            listing = new CategoryListing.CategoryListingBuilder()
                    .id(item.categoryId)
                    .name(item.name)
                    .productCount(item.productCount)
                    .build();
        }
        return listing;
    }
}
