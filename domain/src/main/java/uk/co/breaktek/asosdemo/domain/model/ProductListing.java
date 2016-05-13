package uk.co.breaktek.asosdemo.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductListing {
    public final long basePrice;
    public final String brand;
    public final String currentPrice;
    public final boolean hasMoreColours;
    public final boolean isInSet;
    public final String previousPrice;
    public final long productId;
    public final List<String> productImageUrl;
    public final String rrp;
    public final String title;

    private ProductListing(ProductListingBuilder builder) {
        this.basePrice = builder.basePrice;
        this.brand = builder.brand;
        this.currentPrice = builder.currentPrice;
        this.hasMoreColours = builder.hasMoreColours;
        this.isInSet = builder.isInSet;
        this.previousPrice = builder.previousPrice;
        this.productId = builder.productId;
        this.productImageUrl = builder.productImageUrl;
        this.rrp = builder.rrp;
        this.title = builder.title;
    }

    public static class ProductListingBuilder {
        private long basePrice;
        private String brand;
        private String currentPrice;
        private boolean hasMoreColours;
        private boolean isInSet;
        private String previousPrice;
        private long productId;
        private List<String> productImageUrl;
        private String rrp;
        private String title;

        public ProductListingBuilder() {

        }

        public ProductListingBuilder basePrice(long basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public ProductListingBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public ProductListingBuilder currentPrice(String currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        public ProductListingBuilder hasMoreColours(boolean hasMoreColours) {
            this.hasMoreColours = hasMoreColours;
            return this;
        }

        public ProductListingBuilder isInSet(boolean isInSet) {
            this.isInSet = isInSet;
            return this;
        }

        public ProductListingBuilder previousPrice(String previousPrice) {
            this.previousPrice = previousPrice;
            return this;
        }

        public ProductListingBuilder productId(long productId) {
            this.productId = productId;
            return this;
        }

        public ProductListingBuilder productImageUrl(List<String> productImageUrl) {
            this.productImageUrl = productImageUrl;
            return this;
        }

        public ProductListingBuilder rrp(String rrp) {
            this.rrp = rrp;
            return this;
        }

        public ProductListingBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProductListing build() {
            return new ProductListing(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductListing that = (ProductListing) o;

        return new EqualsBuilder()
                .append(basePrice, that.basePrice)
                .append(hasMoreColours, that.hasMoreColours)
                .append(isInSet, that.isInSet)
                .append(productId, that.productId)
                .append(brand, that.brand)
                .append(currentPrice, that.currentPrice)
                .append(previousPrice, that.previousPrice)
                .append(productImageUrl, that.productImageUrl)
                .append(rrp, that.rrp)
                .append(title, that.title)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(basePrice)
                .append(brand)
                .append(currentPrice)
                .append(hasMoreColours)
                .append(isInSet)
                .append(previousPrice)
                .append(productId)
                .append(productImageUrl)
                .append(rrp)
                .append(title)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new CustomToStringBuilder(this)
                .append("basePrice", basePrice)
                .append("brand", brand)
                .append("currentPrice", currentPrice)
                .append("hasMoreColours", hasMoreColours)
                .append("isInSet", isInSet)
                .append("previousPrice", previousPrice)
                .append("productId", productId)
                .append("productImageUrl", productImageUrl)
                .append("rrp", rrp)
                .append("title", title)
                .toString();
    }
}
