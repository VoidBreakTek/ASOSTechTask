package uk.co.breaktek.asosdemo.data.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;
import uk.co.breaktek.asosdemo.data.enums.CategorySortType;

/**
 * Root category API model
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class Categories {
    private final String description;
    private final CategoryListings categoryListings;
    private final CategorySortType sortType;

    public Categories(CategoriesBuilder builder) {
        this.description = builder.description;
        this.categoryListings = builder.categoryListings;
        this.sortType = builder.sortType;
    }

    public String getDescription() {
        return description;
    }

    public CategoryListings getCategoryListings() {
        return categoryListings;
    }

    public CategorySortType getSortType() {
        return sortType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Categories categories = (Categories) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(description, categories.description)
                .append(categoryListings, categories.categoryListings)
                .append(sortType, categories.sortType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(description)
                .append(categoryListings)
                .append(sortType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new CustomToStringBuilder(this)
                .append("description", description)
                .append("categoryListings", categoryListings)
                .append("sortType", sortType)
                .toString();
    }

    public static class CategoriesBuilder {
        private String description;
        private CategoryListings categoryListings;
        private CategorySortType sortType;

        public CategoriesBuilder() {

        }

        public CategoriesBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoriesBuilder categoryListings(CategoryListings categoryListings) {
            this.categoryListings = categoryListings;
            return this;
        }

        public CategoriesBuilder sortType(CategorySortType sortType) {
            this.sortType = sortType;
            return this;
        }
        public Categories build(){
            return new Categories(this);
        }
    }
}
