package com.hadi.striff.spi;

import com.hadi.striff.diagram.display.DiagramDisplay;

import java.util.List;

public interface DiagramDecorator {

    List<String> decorateDiagram(DiagramDisplay display);

    default int order() {
        return 100;
    }

    /**
     * Returns whether this decorator should be enabled by default.
     */
    default boolean isEnabledByDefault() {
        return true;
    }

    /**
     * Returns a display name for this decorator.
     */
    default String displayName() {
        return this.getClass().getSimpleName();
    }
}
