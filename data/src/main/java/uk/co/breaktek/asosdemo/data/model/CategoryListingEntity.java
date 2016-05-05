package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryListingEntity {
    @SerializedName("CategoryId") public final String categoryId;
    @SerializedName("Name") public final String name;
    @SerializedName("ProductCount") public final int productCount;

    public CategoryListingEntity(String categoryId, String name, int productCount) {
        this.categoryId = categoryId;
        this.name = name;
        this.productCount = productCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CategoryListingEntity that = (CategoryListingEntity) o;

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
}
