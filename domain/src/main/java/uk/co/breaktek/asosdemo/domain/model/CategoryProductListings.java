package uk.co.breaktek.asosdemo.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;
import uk.co.breaktek.asosdemo.domain.enums.ProductSortType;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryProductListings {
    public final String description;
    public final int itemCount;
    public final ProductSortType sortType;
    public final List<ProductListing> productListings;

    public CategoryProductListings(CategoryProductListingsBuilder builder) {
        this.description = builder.description;
        this.itemCount = builder.itemCount;
        this.sortType = builder.sortType;
        this.productListings = builder.productListings;
    }

    public static class CategoryProductListingsBuilder {
        private String description;
        private int itemCount;
        private ProductSortType sortType;
        private List<ProductListing> productListings;

        public CategoryProductListingsBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryProductListingsBuilder itemCount(int itemCount) {
            this.itemCount = itemCount;
            return this;
        }

        public CategoryProductListingsBuilder sortType(ProductSortType sortType) {
            this.sortType = sortType;
            return this;
        }

        public CategoryProductListingsBuilder productListings(List<ProductListing> productListings) {
            this.productListings = productListings;
            return this;
        }

        public CategoryProductListings build() {
            return new CategoryProductListings(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CategoryProductListings that = (CategoryProductListings) o;

        return new EqualsBuilder()
                .append(itemCount, that.itemCount)
                .append(description, that.description)
                .append(sortType, that.sortType)
                .append(productListings, that.productListings)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(description)
                .append(itemCount)
                .append(sortType)
                .append(productListings)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new CustomToStringBuilder(this)
                .append("description", description)
                .append("itemCount", itemCount)
                .append("sortType", sortType)
                .append("productListings", productListings)
                .toString();
    }
}
