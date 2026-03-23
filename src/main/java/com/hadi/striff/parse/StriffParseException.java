package com.hadi.striff.parse;

public class StriffParseException extends Exception {
    public StriffParseException(final String errorMessage) {
        super(errorMessage);
    }

    public StriffParseException(final String errorMessage, final Throwable cause) {
        super(errorMessage, cause);
    }

    /**
     * Creates a parse exception for a specific file.
     */
    public static StriffParseException forFile(String filePath, String reason) {
        return new StriffParseException("Failed to parse file '" + filePath + "': " + reason);
    }

    /**
     * Creates a parse exception for a specific component.
     */
    public static StriffParseException forComponent(String componentName, String reason) {
        return new StriffParseException("Failed to parse component '" + componentName + "': " + reason);
    }
}
