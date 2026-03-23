package com.hadi.striff.text;

public class DefaultText implements Text {

    private final String text;

    public DefaultText(String text) {
        this.text = text;
    }

    @Override
    public String value() {
        return this.text;
    }

    /**
     * Returns the length of the text.
     */
    public int length() {
        return this.text != null ? this.text.length() : 0;
    }

    /**
     * Returns true if the text is empty or null.
     */
    public boolean isEmpty() {
        return this.text == null || this.text.isEmpty();
    }

    @Override
    public String toString() {
        return this.text;
    }
}
