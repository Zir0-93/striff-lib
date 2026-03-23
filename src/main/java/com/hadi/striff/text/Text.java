package com.hadi.striff.text;

public interface Text {

    String value();

    /**
     * Returns true if the text value is empty.
     */
    default boolean isEmpty() {
        String val = value();
        return val == null || val.isEmpty();
    }

    /**
     * Returns the length of the text value.
     */
    default int length() {
        String val = value();
        return val != null ? val.length() : 0;
    }
}
