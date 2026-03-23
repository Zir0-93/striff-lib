package com.hadi.striff.diagram.display;

/**
 * Represents the various ways Striffs can be generated.
 */
public enum PartitionPlacement {
    /**
     * Displays a single partition for each diagram.
     */
    ONE_PER_DIAGRAM,

    /**
     * Displays all partitions in a single diagram.
     */
    CONDENSED;

    /**
     * Returns whether this placement mode is condensed.
     */
    public boolean isCondensed() {
        return this == CONDENSED;
    }

    /**
     * Returns whether this placement mode is one-per-diagram.
     */
    public boolean isOnePerDiagram() {
        return this == ONE_PER_DIAGRAM;
    }
}
