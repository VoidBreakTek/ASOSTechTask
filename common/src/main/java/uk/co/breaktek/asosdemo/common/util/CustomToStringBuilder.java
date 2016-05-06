package uk.co.breaktek.asosdemo.common.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Extension of ToStringBuilder so formatting of toString methods can be changed globally
 * Chris Shotton (voidbreaktek@gmail.com)
 */
public class CustomToStringBuilder extends ToStringBuilder {
    private static final ToStringStyle toStringStyle = ToStringStyle.MULTI_LINE_STYLE;

    public CustomToStringBuilder(Object object) {
        super(object, toStringStyle);
    }

    public CustomToStringBuilder(Object object, ToStringStyle style) {
        super(object, toStringStyle);
    }

    public CustomToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer) {
        super(object, toStringStyle, buffer);
    }
}
