package com.hadi.striff.diagram.partition;

import com.hadi.striff.diagram.DiagramComponent;
import com.hadi.striff.diagram.StriffDiagramModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Partitions all components into a single partition.
 */
public final class SinglePartitionStrategy implements PartitionStrategy {

    List<Set<DiagramComponent>> partitions = new ArrayList<>();

    public SinglePartitionStrategy(StriffDiagramModel striffDiagramModel) {
        this.partitions.add(striffDiagramModel.diagramCmps());
    }

    @Override
    public List<Set<DiagramComponent>> apply() {
        return this.partitions;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    /**
     * Returns the number of partitions (always 1 for this strategy).
     */
    public int partitionCount() {
        return 1;
    }

    /**
     * Returns the total number of components in the single partition.
     */
    public int totalComponentCount() {
        return this.partitions.isEmpty() ? 0 : this.partitions.get(0).size();
    }
}
