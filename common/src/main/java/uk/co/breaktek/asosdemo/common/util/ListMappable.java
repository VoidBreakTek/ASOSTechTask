package uk.co.breaktek.asosdemo.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public abstract class ListMappable<TA, TB> {

    public abstract TB transform(TA item);

    public List<TB> transform(Collection<TA> items) {
        List<TB> itemList;
        if (items != null && !items.isEmpty()) {
            itemList = new ArrayList<>();
            for (TA item : items) {
                if (item != null) {
                    itemList.add(transform(item));
                }
            }
        } else {
            itemList = Collections.emptyList();
        }
        return itemList;
    }
}
