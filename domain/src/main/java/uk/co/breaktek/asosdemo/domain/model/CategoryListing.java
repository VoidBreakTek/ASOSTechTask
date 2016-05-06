package uk.co.breaktek.asosdemo.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryListing {
    private final String categoryId;
    private final String name;
    private final int productCount;

    public CategoryListing(CategoryListingBuilder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.productCount = builder.productCount;
    }

    public String getCategoryId() {
        return categoryId;
    }


    public String getCategoryName() {
        return name;
    }


    public int getProductCount() {
        return productCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CategoryListing that = (CategoryListing) o;

        return new EqualsBuilder()
                .append(productCount, that.productCount)
                .append(categoryId, that.categoryId)
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(categoryId)
                .append(name)
                .append(productCount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new CustomToStringBuilder(this)
                .append("categoryId", categoryId)
                .append("name", name)
                .append("productCount", productCount)
                .toString();
    }

    public static class CategoryListingBuilder {
        String categoryId;
        String name;
        int productCount;

        public CategoryListingBuilder() {

        }

        public CategoryListingBuilder id(String id) {
            this.categoryId = id;
            return this;
        }

        public CategoryListingBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryListingBuilder productCount(int productCount) {
            this.productCount = productCount;
            return this;
        }

        public CategoryListing build() {
            return new CategoryListing(this);
        }
    }
}
