package com.hadi.striff.diagram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hadi.clarpse.reference.ComponentReference;
import com.hadi.clarpse.sourcemodel.Component;
import com.hadi.clarpse.sourcemodel.OOPSourceCodeModel;
import com.hadi.clarpse.sourcemodel.OOPSourceModelConstants;
import com.hadi.clarpse.sourcemodel.Package;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DiagramComponent {

    private final Component cmp;
    private final List<String> children = new ArrayList<>();
    private final Map<String, Object> augmentations = new HashMap<>();

    /**
     * If serialization only is needed, this no-arg constructor
     * can be omitted. Required if deserialization is needed.
     */
    public DiagramComponent() {
        this.cmp = new Component();
    }

    public DiagramComponent(Component cmp, OOPSourceCodeModel srcModel) {
        if (cmp == null) {
            this.cmp = new Component();
        } else {
            this.cmp = cmp;
        }
        if (srcModel != null) {
            this.cmp.children().stream()
                    .filter(child -> srcModel.getComponent(child).isPresent())
                    .forEach(children::add);
        }
    }

    public DiagramComponent(String componentName) {
        this();
        this.cmp.setComponentName(componentName);
    }

    public DiagramComponent(String cmpName, OOPSourceCodeModel srcModel) {
        this(srcModel.getComponent(cmpName).orElse(new Component()), srcModel);
    }

    @JsonIgnore
    public void putAugmentation(String key, Object value) {
        augmentations.put(key, value);
    }

    @JsonIgnore
    public Optional<Object> augmentation(String key) {
        return Optional.ofNullable(augmentations.get(key));
    }

    public List<String> children() {
        return Collections.unmodifiableList(this.children);
    }

    @JsonProperty("uniqueName")
    public String uniqueName() {
        return cmp.uniqueName();
    }

    public List<ComponentReference> references(OOPSourceModelConstants.TypeReferences implementation) {
        return cmp.references(implementation);
    }

    @JsonProperty("modifiers")
    public Set<String> modifiers() {
        return this.cmp.modifiers();
    }

    @JsonProperty("componentType")
    public OOPSourceModelConstants.ComponentType componentType() {
        return this.cmp.componentType();
    }

    @JsonIgnore
    public String parentUniqueName() {
        return this.cmp.parentUniqueName();
    }

    @JsonProperty("refs")
    private Set<String> refs() {
        return this.cmp.references().stream().map(ref -> ref.toString()).collect(Collectors.toSet());
    }

    public Set<ComponentReference> references() {
        return this.cmp.references();
    }

    @JsonProperty("name")
    public String name() {
        return this.cmp.name();
    }

    @JsonIgnore
    public String codeFragment() {
        return this.cmp.codeFragment();
    }

    @JsonIgnore
    public int componentHashCode() {
        return this.cmp.codeHash();
    }

    @JsonProperty("comment")
    public String comment() {
        return this.cmp.comment();
    }

    @JsonProperty("sourceFile")
    public String sourceFile() {
        return this.cmp.sourceFile();
    }

    @JsonIgnore
    public void setName(String name) {
        this.cmp.setName(name);
    }

    @JsonProperty("package")
    private String packageName() {
        return this.cmp.pkg().toString();
    }

    @JsonIgnore
    public Package pkg() {
        return this.cmp.pkg();
    }

    @JsonProperty("componentName")
    public String componentName() {
        return this.cmp.componentName();
    }

    @Override
    public int hashCode() {
        return this.uniqueName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DiagramComponent)) {
            return false;
        }
        DiagramComponent other = (DiagramComponent) obj;
        return Objects.equals(this.uniqueName(), other.uniqueName());
    }

    @Override
    public String toString() {
        return this.uniqueName();
    }

    /**
     * Returns a qualified display name including package and class name.
     */
    @JsonProperty("displayName")
    public String displayName() {
        return this.cmp.pkg().toString() + "." + this.cmp.name();
    }

    /**
     * Checks if this component has any children.
     */
    @JsonProperty("hasChildren")
    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    /**
     * Gets the count of children for this component.
     */
    @JsonProperty("childrenCount")
    public int childrenCount() {
        return this.children.size();
    }

    /**
     * Checks if this component has any augmentations.
     */
    @JsonIgnore
    public boolean hasAugmentations() {
        return !this.augmentations.isEmpty();
    }

    /**
     * Gets all augmentation keys.
     */
    @JsonIgnore
    public Set<String> augmentationKeys() {
        return this.augmentations.keySet();
    }

    /**
     * Gets a short summary of this component for debugging.
     */
    @JsonIgnore
    public String debugSummary() {
        return String.format("DiagramComponent[type=%s, name=%s, children=%d]",
                this.componentType(), this.name(), this.children.size());
    }

    /**
     * Returns true if this component is a base component type.
     */
    @JsonIgnore
    public boolean isBaseComponent() {
        return this.componentType().isBaseComponent();
    }

    /**
     * Returns true if this component is a method component type.
     */
    @JsonIgnore
    public boolean isMethodComponent() {
        return this.componentType().isMethodComponent();
    }

    /**
     * Returns true if this component is a variable component type.
     */
    @JsonIgnore
    public boolean isVariableComponent() {
        return this.componentType().isVariableComponent();
    }

    /**
     * Returns true if this component has a comment.
     */
    @JsonIgnore
    public boolean hasComment() {
        return this.comment() != null && !this.comment().isEmpty();
    }

    /**
     * Returns true if this component has any references.
     */
    @JsonIgnore
    public boolean hasReferences() {
        return this.references() != null && !this.references().isEmpty();
    }

    /**
     * Returns true if this component has a source file defined.
     */
    @JsonIgnore
    public boolean hasSourceFile() {
        return this.sourceFile() != null && !this.sourceFile().isEmpty();
    }

    /**
     * Gets the number of augmentations on this component.
     */
    @JsonIgnore
    public int augmentationCount() {
        return this.augmentations.size();
    }
}
