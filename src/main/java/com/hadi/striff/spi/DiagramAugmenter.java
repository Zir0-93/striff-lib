package com.hadi.striff.spi;

import com.hadi.striff.diagram.DiagramComponent;
import com.hadi.striff.parse.CodeDiff;

import java.util.Set;

public interface DiagramAugmenter {

    void augment(CodeDiff diff, Set<DiagramComponent> components);

    default int order() {
        return 100;
    }

    /**
     * Returns whether this augmenter should be enabled by default.
     */
    default boolean isEnabledByDefault() {
        return true;
    }

    /**
     * Returns a display name for this augmenter.
     */
    default String displayName() {
        return this.getClass().getSimpleName();
    }
}
