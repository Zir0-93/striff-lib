package com.hadi.striff.text;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document.OutputSettings;

final class HtmlTagsStrippedText implements Text {

    private final Text   text;
    OutputSettings settings = new OutputSettings();

    HtmlTagsStrippedText(Text text) {
        this.text = text;
        this.settings.prettyPrint(false);
    }

    @Override
    public String value() {
        return Jsoup.parse(this.text.value()).text();
    }

    /**
     * Returns true if the text contains HTML tags.
     */
    public boolean containsHtml() {
        String val = this.text.value();
        return val != null && (val.contains("<") && val.contains(">"));
    }

    /**
     * Returns the original text before HTML stripping.
     */
    public String originalValue() {
        return this.text.value();
    }
}