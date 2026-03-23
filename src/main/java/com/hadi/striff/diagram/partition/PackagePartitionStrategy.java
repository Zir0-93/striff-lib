package com.hadi.striff.diagram.partition;

import com.hadi.striff.diagram.ComponentHelper;
import com.hadi.striff.diagram.DiagramComponent;
import com.hadi.striff.diagram.StriffDiagramModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

/**
 * Partitions components based on what package they belong to.
 */
public final class PackagePartitionStrategy implements PartitionStrategy {

    private final List<Set<DiagramComponent>> partitions = new ArrayList<>();

    public PackagePartitionStrategy(StriffDiagramModel striffDiagramModel) {
        Map<String, List<DiagramComponent>> packagePartitions = striffDiagramModel.diagramCmps().stream()
                .collect(groupingBy(cmp -> ComponentHelper.packagePath(cmp.pkg())));
        // Convert map to list of hash sets.
        packagePartitions.values().forEach(
                diagramComponents -> partitions.add(new HashSet<>(diagramComponents)));
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
     * Returns the number of partitions created.
     */
    public int partitionCount() {
        return this.partitions.size();
    }

    /**
     * Returns the total number of components across all partitions.
     */
    public int totalComponentCount() {
        return this.partitions.stream()
                .mapToInt(Set::size)
                .sum();
    }
}
