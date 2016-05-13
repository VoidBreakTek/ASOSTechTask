package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Not implemented fields not required for the demo screens
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CategoryProductListingsEntity {
    @SerializedName("Description")
    public String description;
    @SerializedName("ItemCount")
    public int itemCount;
    @SerializedName("SortType")
    public String sortType;
    @SerializedName("Listings")
    public List<ProductListingEntity> productListings;

    public CategoryProductListingsEntity() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public List<ProductListingEntity> getProductListings() {
        return productListings;
    }

    public void setProductListings(List<ProductListingEntity> productListings) {
        this.productListings = productListings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryProductListingsEntity that = (CategoryProductListingsEntity) o;

        if (itemCount != that.itemCount) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (sortType != null ? !sortType.equals(that.sortType) : that.sortType != null)
            return false;
        return productListings != null ? productListings.equals(that.productListings) : that.productListings == null;

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + itemCount;
        result = 31 * result + (sortType != null ? sortType.hashCode() : 0);
        result = 31 * result + (productListings != null ? productListings.hashCode() : 0);
        return result;
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
