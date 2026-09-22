package com.hadi.striff.diagram;

import java.util.ArrayList;
import java.util.List;

/**
 * Smoke-test fixture for the Striffs browser extension: the change of a merged pull request whose
 * head branch has been deleted.
 */
public class DiagramLegend {

    private final List<DiagramComponent> entries = new ArrayList<>();

    public void add(DiagramComponent component) {
        entries.add(component);
    }

    public int size() {
        return entries.size();
    }
}
