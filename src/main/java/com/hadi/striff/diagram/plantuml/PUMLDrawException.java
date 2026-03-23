package com.hadi.striff.diagram.plantuml;

public class PUMLDrawException extends Exception {

    public PUMLDrawException(String message, Exception e) {
        super(message, e);
    }

    public PUMLDrawException(String message) {
        super(message);
    }

    /**
     * Creates a PUMLDrawException for a syntax error.
     */
    public static PUMLDrawException syntaxError(String details) {
        return new PUMLDrawException("PlantUML syntax error: " + details);
    }

    /**
     * Creates a PUMLDrawException for a generation error.
     */
    public static PUMLDrawException generationError(String details, Throwable cause) {
        return new PUMLDrawException("Failed to generate PlantUML diagram: " + details, cause);
    }
}
