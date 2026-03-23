package com.hadi.striff;

import com.hadi.clarpse.compiler.Lang;
import com.hadi.striff.diagram.display.DiagramColorScheme;
import com.hadi.striff.diagram.display.DiagramDisplayOverride;
import com.hadi.striff.diagram.display.LightDiagramColorScheme;
import com.hadi.striff.diagram.display.OutputMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Config object used to inform the striff generation process with a fluent
 * interface design.
 */
public class StriffConfig {

    private static final Logger LOGGER = LogManager.getLogger(StriffConfig.class);

    private OutputMode outputMode = OutputMode.DEFAULT;
    /**
     * Optional set of source files to restrict the analysis of architectural
     * differences to *specific* source files. When an empty set is provided,
     * striffs will display architectural differences encountered across all source
     * files.
     */
    private Set<String> filesFilter = Collections.emptySet();
    private Set<Lang> languages = new HashSet<>(Lang.supportedLanguages());
    // Control for SVG code generation
    private boolean metadataOnly = false;
    private DiagramColorScheme colorScheme = new LightDiagramColorScheme();
    private DiagramDisplayOverride displayOverride = null;
    private boolean enableAugmenters = true;
    /**
     * Hard limit to avoid sending extremely large diagrams to PlantUML.
     */
    private int maxComponentsPerDiagram = 120;
    /**
     * Flag to control whether to include internal components in diagrams.
     */
    private boolean includeInternalComponents = true;
    /**
     * Optional custom title for the generated diagram.
     */
    private String diagramTitle = "";
    /**
     * Minimum code similarity threshold for considering components as modified.
     */
    private double similarityThreshold = 0.85;

    public StriffConfig() {
    }

    public static StriffConfig create() {
        return new StriffConfig();
    }

    public StriffConfig setOutputMode(OutputMode outputMode) {
        this.outputMode = outputMode;
        return this;
    }

    public StriffConfig setFilesFilter(List<String> filesFilter) {
        this.filesFilter = filesFilter.stream()
                .filter(file -> Lang.supportedSourceFileExtns().stream().anyMatch(file::endsWith))
                .collect(Collectors.toSet());
        LOGGER.info("Setting list of filter files to: " + this.filesFilter + ".");
        return this;
    }

    public StriffConfig setLanguages(Collection<Lang> languages) {
        this.languages = new HashSet<>(languages);
        return this;
    }


    public StriffConfig setMetadataOnly(boolean metadataOnly) {
        this.metadataOnly = metadataOnly;
        return this;
    }

    public StriffConfig setMaxComponentsPerDiagram(int maxComponentsPerDiagram) {
        if (maxComponentsPerDiagram <= 0) {
            throw new IllegalArgumentException("maxComponentsPerDiagram must be greater than zero.");
        }
        this.maxComponentsPerDiagram = maxComponentsPerDiagram;
        return this;
    }

    public StriffConfig setColorScheme(DiagramColorScheme colorScheme) {
        this.colorScheme = colorScheme;
        return this;
    }

    public StriffConfig setDisplayOverride(DiagramDisplayOverride displayOverride) {
        this.displayOverride = displayOverride;
        return this;
    }

    public StriffConfig setEnableAugmenters(boolean enableAugmenters) {
        this.enableAugmenters = enableAugmenters;
        return this;
    }
    public OutputMode outputMode() {
        return this.outputMode;
    }

    public Set<String> filesFilter() {
        return this.filesFilter;
    }

    public DiagramColorScheme colorScheme() {
        return this.colorScheme;
    }

    public DiagramDisplayOverride displayOverride() {
        return this.displayOverride;
    }

    public boolean enableAugmenters() {
        return this.enableAugmenters;
    }
    public Set<Lang> languages() {
        return this.languages;
    }


    public boolean metadataOnly() {
        return this.metadataOnly;
    }

    public int maxComponentsPerDiagram() {
        return this.maxComponentsPerDiagram;
    }

    public StriffConfig setIncludeInternalComponents(boolean includeInternalComponents) {
        this.includeInternalComponents = includeInternalComponents;
        return this;
    }

    public boolean includeInternalComponents() {
        return this.includeInternalComponents;
    }

    public StriffConfig setDiagramTitle(String diagramTitle) {
        this.diagramTitle = diagramTitle != null ? diagramTitle : "";
        return this;
    }

    public String diagramTitle() {
        return this.diagramTitle;
    }

    public StriffConfig setSimilarityThreshold(double similarityThreshold) {
        if (similarityThreshold < 0.0 || similarityThreshold > 1.0) {
            throw new IllegalArgumentException("similarityThreshold must be between 0.0 and 1.0");
        }
        this.similarityThreshold = similarityThreshold;
        return this;
    }

    public double similarityThreshold() {
        return this.similarityThreshold;
    }

    /**
     * Checks if the config has any file filters set.
     */
    public boolean hasFileFilters() {
        return !this.filesFilter.isEmpty();
    }

    /**
     * Gets a formatted config summary for logging purposes.
     */
    public String getConfigSummary() {
        return String.format("StriffConfig[outputMode=%s, languages=%d, maxComponents=%d]",
                this.outputMode, this.languages.size(), this.maxComponentsPerDiagram);
    }

    @Override
    public String toString() {
        return "Output Mode: " + this.outputMode + ", Languages: " + this.languages + ", Filter Files: "
                + this.filesFilter + ", Max Components/Diagram: " + this.maxComponentsPerDiagram;
    }

    /**
     * Returns true if augmenters are enabled.
     */
    public boolean isAugmentersEnabled() {
        return this.enableAugmenters;
    }

    /**
     * Returns true if the config has a custom diagram title.
     */
    public boolean hasCustomDiagramTitle() {
        return this.diagramTitle != null && !this.diagramTitle.isEmpty();
    }

    /**
     * Returns true if a display override has been set.
     */
    public boolean hasDisplayOverride() {
        return this.displayOverride != null;
    }

    /**
     * Returns true if internal components should be included.
     */
    public boolean shouldIncludeInternalComponents() {
        return this.includeInternalComponents;
    }

    /**
     * Creates a builder-style copy of this config.
     */
    public StriffConfig copy() {
        StriffConfig copy = new StriffConfig();
        copy.outputMode = this.outputMode;
        copy.filesFilter = new HashSet<>(this.filesFilter);
        copy.languages = new HashSet<>(this.languages);
        copy.metadataOnly = this.metadataOnly;
        copy.colorScheme = this.colorScheme;
        copy.displayOverride = this.displayOverride;
        copy.enableAugmenters = this.enableAugmenters;
        copy.maxComponentsPerDiagram = this.maxComponentsPerDiagram;
        copy.includeInternalComponents = this.includeInternalComponents;
        copy.diagramTitle = this.diagramTitle;
        copy.similarityThreshold = this.similarityThreshold;
        return copy;
    }
}
