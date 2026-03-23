package com.hadi.striff.text;

final class DocCommentCharacterStrippedText implements Text {

    private final Text text;

    DocCommentCharacterStrippedText(Text text) {
        this.text = text;
    }

    @Override
    public String value() {
        return this.text.value()
            .replace("/*", "")
            .replace("*/", "")
            .replace("*", "");
    }

    /**
     * Returns the original text before stripping.
     */
    public String getOriginalText() {
        return this.text.value();
    }

    /**
     * Returns true if the original text contains comment characters.
     */
    public boolean containsCommentChars() {
        String val = this.text.value();
        return val != null && (val.contains("/*") || val.contains("*/") || val.contains("*"));
    }
}
