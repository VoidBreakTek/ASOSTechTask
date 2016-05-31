package uk.co.breaktek.asosdemo.data.mapping;

import javax.inject.Inject;

import uk.co.breaktek.asosdemo.data.model.CategoryProductListingsEntity;
import uk.co.breaktek.asosdemo.domain.enums.CategorySortType;
import uk.co.breaktek.asosdemo.domain.enums.ProductSortType;
import uk.co.breaktek.asosdemo.domain.model.CategoryProductListings;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryProductListingsEntityMapper {
    @Inject
    ProductListingEntityMapper mProductListingEntityMapper;

    @Inject
    public CategoryProductListingsEntityMapper() {

    }

    public CategoryProductListings transform(CategoryProductListingsEntity item) {
        CategoryProductListings categoryProductListings = null;
        if (item != null) {
            categoryProductListings = new CategoryProductListings.CategoryProductListingsBuilder()
                    .description(item.getDescription())
                    .itemCount(item.getItemCount())
                    .productListings(mProductListingEntityMapper.transform(item.getProductListings()))
                    .sortType(resolveSortTypeEnum(item.getSortType()))
                    .build();
        }
        return categoryProductListings;
    }

    private ProductSortType resolveSortTypeEnum(String sortType) {
        switch (sortType) {
            case "PriceAscending":
                return ProductSortType.PRICE_ASCENDING;
            default:
                return ProductSortType.UNSORTED;
        }
    }

}
