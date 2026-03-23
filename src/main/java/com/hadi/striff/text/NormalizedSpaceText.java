package com.hadi.striff.text;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents text with normalized spacing.
 */
final class NormalizedSpaceText implements Text {

    private final Text text;

    NormalizedSpaceText(Text text) {
        this.text = text;
    }

    @Override
    public String value() {
        return StringUtils.normalizeSpace(this.text.value());
    }

    /**
     * Returns the original text before normalization.
     */
    public String getOriginalText() {
        return this.text.value();
    }

    /**
     * Returns true if the original text has non-normalized spaces.
     */
    public boolean needsNormalization() {
        String val = this.text.value();
        return val != null && !val.equals(StringUtils.normalizeSpace(val));
    }
}
