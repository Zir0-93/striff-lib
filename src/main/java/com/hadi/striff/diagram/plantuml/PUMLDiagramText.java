package com.hadi.striff.diagram.plantuml;

public final class PUMLDiagramText {

    private PUMLDiagramText() {
    }

    /**
     * Returns the PlantUML text for the provided diagram data without rendering.
     */
    public static String build(PUMLDiagramData data) {
        return new PUMLClassDiagramCode(data).code();
    }

    /**
     * Returns the length of the generated PlantUML text.
     */
    public static int buildLength(PUMLDiagramData data) {
        return build(data).length();
    }

    /**
     * Returns true if the generated PlantUML text is empty.
     */
    public static boolean isEmpty(PUMLDiagramData data) {
        return build(data).isEmpty();
    }
}
