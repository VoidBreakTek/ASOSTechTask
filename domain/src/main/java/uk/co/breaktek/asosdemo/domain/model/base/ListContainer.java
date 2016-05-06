package uk.co.breaktek.asosdemo.domain.model.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uk.co.breaktek.asosdemo.common.util.CustomToStringBuilder;

/**
 * Abstract list collection wrapper so base data structure can be easily refactored if needed
 * <p/>
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class ListContainer<ItemType> {

    private List<ItemType> items = new ArrayList<>();

    public ItemType get(int index) {
        return items.get(index);
    }

    public void add(ItemType listing) {
        this.items.add(listing);
    }

    public void addAll(Collection<ItemType> listings) {
        this.items.addAll(listings);
    }

    public void remove(ItemType listing) {
        this.items.remove(listing);
    }

    @Override
    public String toString() {
        return new CustomToStringBuilder(this)
                .append("items", items)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ListContainer<?> that = (ListContainer<?>) o;

        return new EqualsBuilder()
                .append(items, that.items)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(items)
                .toHashCode();
    }
}
