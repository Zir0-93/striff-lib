package com.hadi.striff;

/**
 * Smoke-test fixture for the Striffs browser extension: the change of a pull request closed without
 * merging, whose head branch has been deleted.
 */
public final class ChangeSetSummary {

    private final ChangeSet changeSet;

    public ChangeSetSummary(ChangeSet changeSet) {
        this.changeSet = changeSet;
    }

    public ChangeSet changeSet() {
        return changeSet;
    }
}
