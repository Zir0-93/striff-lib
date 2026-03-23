package com.hadi.striff.text;

import org.apache.commons.lang.WordUtils;

/**
 * A piece of text with line breaks in it. Assumes input Text object does not
 * have any existing line breaks.
 *
 */
public class LineBreakedText implements Text {

    private final Text text;
    private final int maxCharsPerLine;

    public LineBreakedText(Text text, int maxCharsPerLine) {
        this.text = text;
        this.maxCharsPerLine = maxCharsPerLine;
    }

    @Override
    public String value() {
        return WordUtils.wrap(this.text.value(), this.maxCharsPerLine).trim();
    }

    /**
     * Returns the maximum characters per line.
     */
    public int getMaxCharsPerLine() {
        return this.maxCharsPerLine;
    }

    /**
     * Returns the original text before line breaking.
     */
    public String getOriginalText() {
        return this.text.value();
    }

    /**
     * Returns true if the text will be wrapped.
     */
    public boolean willWrap() {
        return this.text.value().length() > this.maxCharsPerLine;
    }
}
