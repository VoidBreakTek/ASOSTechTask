package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class ProductListingEntity {
    @SerializedName("BasePrice")
    public long basePrice;
    @SerializedName("Brand")
    public String brand;
    @SerializedName("CurrentPrice")
    public String currentPrice;
    @SerializedName("HasMoreColours")
    public boolean hasMoreColours;
    @SerializedName("IsInSet")
    public boolean isInSet;
    @SerializedName("PreviousPrice")
    public String previousPrice;
    @SerializedName("ProductId")
    public long productId;
    @SerializedName("ProductImageUrl")
    public List<String> productImageUrl;
    @SerializedName("RRP")
    public String rrp;
    @SerializedName("Title")
    public String title;

    public ProductListingEntity() {

    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public boolean hasMoreColours() {
        return hasMoreColours;
    }

    public void setHasMoreColours(boolean hasMoreColours) {
        this.hasMoreColours = hasMoreColours;
    }

    public boolean isInSet() {
        return isInSet;
    }

    public void setInSet(boolean inSet) {
        isInSet = inSet;
    }

    public String getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(String previousPrice) {
        this.previousPrice = previousPrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public List<String> getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(List<String> productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getRrp() {
        return rrp;
    }

    public void setRrp(String rrp) {
        this.rrp = rrp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductListingEntity that = (ProductListingEntity) o;

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
