package uk.co.breaktek.asosdemo.data.mapping;

import javax.inject.Inject;

import uk.co.breaktek.asosdemo.common.util.ListMappable;
import uk.co.breaktek.asosdemo.data.model.ProductListingEntity;
import uk.co.breaktek.asosdemo.domain.model.ProductListing;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductListingEntityMapper extends ListMappable<ProductListingEntity, ProductListing> {

    @Inject
    public ProductListingEntityMapper() {

    }

    @Override
    public ProductListing transform(ProductListingEntity item) {
        ProductListing productListing = null;
        if (item != null) {
            productListing = new ProductListing.ProductListingBuilder()
                    .basePrice(item.getBasePrice())
                    .brand(item.getBrand())
                    .currentPrice(item.getCurrentPrice())
                    .hasMoreColours(item.hasMoreColours())
                    .isInSet(item.isInSet())
                    .previousPrice(item.getPreviousPrice())
                    .productId(item.getProductId())
                    .productImageUrl(item.getProductImageUrl())
                    .rrp(item.getRrp())
                    .title(item.getTitle())
                    .build();
        }
        return productListing;
    }
}
