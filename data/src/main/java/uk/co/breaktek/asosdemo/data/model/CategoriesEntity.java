package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoriesEntity {
    @SerializedName("Description") public final String description;
    @SerializedName("SortType") public final String sortType;
    @SerializedName("Listing") public final List<CategoryListingEntity> categoryListings;

    public CategoriesEntity(String description,
                            String sortType,
                            List<CategoryListingEntity> categoryListings) {
        this.description = description;
        this.sortType = sortType;
        this.categoryListings = categoryListings;
    }


    @Override
    public String toString() {
        return new CustomToStringBuilder(this)
                .append("description", description)
                .append("sortType", sortType)
                .append("categoryListings", categoryListings)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CategoriesEntity that = (CategoriesEntity) o;

        return new EqualsBuilder()
                .append(description, that.description)
                .append(sortType, that.sortType)
                .append(categoryListings, that.categoryListings)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(description)
                .append(sortType)
                .append(categoryListings)
                .toHashCode();
    }


}

