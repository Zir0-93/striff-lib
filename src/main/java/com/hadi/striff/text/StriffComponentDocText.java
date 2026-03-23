package com.hadi.striff.text;

/**
 * The component documentation in Striff Diagrams.
 */
public final class StriffComponentDocText implements Text {

    private final String text;
    private final int lineLength;

    public StriffComponentDocText(String text, int lineLength) {
        this.text = text;
        this.lineLength = lineLength;
    }

    @Override
    public String value() {
        return new BoldedLineText(
                new LineBreakedText(
                        new NormalizedSpaceText(
                                new PlantUMLFriendlyText(
                                        new DocCommentCharacterStrippedText(
                                                new HtmlTagsStrippedText(
                                                        new DefaultText(this.text.trim()))))), lineLength)).value();
    }

    /**
     * Returns the line length used for formatting.
     */
    public int getLineLength() {
        return this.lineLength;
    }

    /**
     * Returns the original text before formatting.
     */
    public String getOriginalText() {
        return this.text;
    }

    /**
     * Returns true if the original text is empty.
     */
    public boolean isOriginalEmpty() {
        return this.text == null || this.text.trim().isEmpty();
    }
}
