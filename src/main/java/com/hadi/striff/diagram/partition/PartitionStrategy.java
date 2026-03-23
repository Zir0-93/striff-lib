package com.hadi.striff.diagram.partition;

import com.hadi.striff.diagram.DiagramComponent;

import java.util.List;
import java.util.Set;

public interface PartitionStrategy {

    /**
     * Returns the final set of partitioned components.
     */
    List<Set<DiagramComponent>> apply();

    /**
     * Returns the number of partitions.
     */
    default int partitionCount() {
        return apply().size();
    }

    /**
     * Returns the total number of components across all partitions.
     */
    default int totalComponentCount() {
        return apply().stream()
                .mapToInt(Set::size)
                .sum();
    }
}
