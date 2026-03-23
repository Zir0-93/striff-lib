package com.hadi.striff.diagram;

import com.hadi.clarpse.sourcemodel.Package;

public class ComponentHelper {

    public static String packagePath(Package pkg) {
        if (pkg != null) {
            if (!pkg.ellipsisSeparatedPkgPath().isEmpty()) {
                return pkg.ellipsisSeparatedPkgPath();
            } else {
                return pkg.name();
            }
        } else {
            return "";
        }
    }

    /**
     * Returns true if the given package is a default (unnamed) package.
     */
    public static boolean isDefaultPackage(Package pkg) {
        return pkg == null || pkg.name().isEmpty();
    }

    /**
     * Returns the simple package name (last segment only).
     */
    public static String simplePackageName(Package pkg) {
        String fullPath = packagePath(pkg);
        if (fullPath.isEmpty()) {
            return "";
        }
        int lastDot = fullPath.lastIndexOf('.');
        return lastDot >= 0 ? fullPath.substring(lastDot + 1) : fullPath;
    }
}
