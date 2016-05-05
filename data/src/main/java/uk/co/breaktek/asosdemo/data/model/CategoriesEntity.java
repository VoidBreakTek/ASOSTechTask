package uk.co.breaktek.asosdemo.data.model;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.RealmClass;
import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Realm models are used for local caching. Realm models must extend RealmObject or implement the
 * Realm model interface and have an empty constructor and non-final fields. These are awkward
 * models that break encapsulation when passed around so are converted to immutable Domain models
 * when passed to and from the cache
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
@RealmClass
public class CategoriesEntity implements RealmModel {
    @SerializedName("Description")
    public String description;
    @SerializedName("SortType")
    public String sortType;
    @SerializedName("Listing")
    public RealmList<CategoryListingEntity> categoryListings;

    public CategoriesEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public List<CategoryListingEntity> getCategoryListings() {
        return categoryListings;
    }

    public void setCategoryListings(RealmList<CategoryListingEntity> categoryListings) {
        this.categoryListings = categoryListings;
    }

    public void setCategoryListings(List<CategoryListingEntity> categoryListings) {
        RealmList<CategoryListingEntity> categoryListingEntities = new RealmList<>();
        if (categoryListings != null && categoryListings.size() > 0) {
            categoryListingEntities.addAll(categoryListings);
        }
        this.categoryListings = categoryListingEntities;
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

