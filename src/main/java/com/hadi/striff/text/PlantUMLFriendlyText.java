package com.hadi.striff.text;

/**
 * Represents text that can be displayed in a PlantUML diagram.
 */
final class PlantUMLFriendlyText implements Text {

    private final Text text;

    PlantUMLFriendlyText(Text text) {
        this.text = text;
    }

    @Override
    public String value() {
        return this.text.value().replaceAll("\\(", "[").replaceAll("\\)", "]");
    }

    /**
     * Returns the original text before PlantUML formatting.
     */
    public String originalValue() {
        return this.text.value();
    }

    /**
     * Returns true if the text contains characters that need escaping.
     */
    public boolean needsEscaping() {
        String val = this.text.value();
        return val != null && (val.contains("(") || val.contains(")"));
    }
}
