package com.magentoapplication.ui.backend.catalogmodule;

public class TestHelperClassCatalog {

    private static String subName;
    private static String rootName;
    private static String changeRootName;

    private static String productName;
    private static  String changedProductName;

    public static String getChangedProductName() {
        return changedProductName;
    }

    public static void setChangedProductName(String changedProductName) {
        TestHelperClassCatalog.changedProductName = changedProductName;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        TestHelperClassCatalog.productName = productName;
    }

    public static String getSubName() {
        return subName;
    }

    public static void setSubName(String subName) {
        TestHelperClassCatalog.subName = subName;
    }

    public static String getRootName() {
        return rootName;
    }

    public static void setRootName(String rootName) {
        TestHelperClassCatalog.rootName = rootName;
    }

    public static String getChangeRootName() {
        return changeRootName;
    }

    public static void setChangeRootName(String changeRootName) {
        TestHelperClassCatalog.changeRootName = changeRootName;
    }
}
