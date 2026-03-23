package com.hadi.striff.diagram.display;

/**
 * Represents the various ways Striffs can be generated.
 */
public enum OutputMode {
    /**
     * Outputs a single diagram containing all components and changes.
     */
    DEFAULT;

    /**
     * Returns whether this is the default output mode.
     */
    public boolean isDefault() {
        return this == DEFAULT;
    }
}
