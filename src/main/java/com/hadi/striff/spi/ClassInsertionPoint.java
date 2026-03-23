package com.hadi.striff.spi;

public enum ClassInsertionPoint {
    TOP,
    AFTER_FIELDS,
    AFTER_METHODS,
    BOTTOM;

    /**
     * Returns true if this insertion point is at the beginning of the class.
     */
    public boolean isTop() {
        return this == TOP;
    }

    /**
     * Returns true if this insertion point is at the end of the class.
     */
    public boolean isBottom() {
        return this == BOTTOM;
    }

    /**
     * Returns true if this insertion point is after fields.
     */
    public boolean isAfterFields() {
        return this == AFTER_FIELDS;
    }

    /**
     * Returns true if this insertion point is after methods.
     */
    public boolean isAfterMethods() {
        return this == AFTER_METHODS;
    }
}
