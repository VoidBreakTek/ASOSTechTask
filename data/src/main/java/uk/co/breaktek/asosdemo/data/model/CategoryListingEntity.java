package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;
import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@RealmClass
public class CategoryListingEntity implements RealmModel {
    @SerializedName("CategoryId")
    public String categoryId;
    @SerializedName("Name")
    public String categoryName;
    @SerializedName("ProductCount")
    public int productCount;

    public CategoryListingEntity() {
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
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
                .append(categoryName, that.categoryName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(categoryId)
                .append(categoryName)
                .append(productCount)
                .toHashCode();
    }


    @Override
    public String toString() {
        return new CustomToStringBuilder(this)
                .append("categoryId", categoryId)
                .append("categoryName", categoryName)
                .append("productCount", productCount)
                .toString();
    }
}
