package com.hadi.striff.extractor;

/**
 * Represents the multiplicity that can exist between two classes, implied
 * context is a UML Class Diagram.
 */
public class ComponentAssociationMultiplicity {

    private String value;

    public ComponentAssociationMultiplicity(final DiagramConstants.DefaultClassMultiplicities multiplicity) {
        this.value = multiplicity.value();
    }

    public final String value() {
        return this.value;
    }

    public final void setValue(final String multiplicityValue) {
        this.value = multiplicityValue;
    }

    /**
     * Returns true if this multiplicity represents a many-valued association.
     */
    public boolean isMany() {
        return this.value != null && this.value.contains("*");
    }

    /**
     * Returns true if this multiplicity represents a single-valued association.
     */
    public boolean isSingle() {
        return this.value != null && !this.value.contains("*")
                && !this.value.contains("..") && !this.value.isEmpty();
    }

    /**
     * Returns true if this multiplicity is unspecified (NONE).
     */
    public boolean isNone() {
        return this.value == null || this.value.isEmpty();
    }

    @Override
    public String toString() {
        return this.value;
    }
}
