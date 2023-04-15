package com.magentoapplication.ui.backend.catalogmodule;

public class TestHelperCatalog {

    private static String subName;
    private static String rootName;
    private static String changeRootName;

    private static String productName;
    private static  String changedProductName;

    private static String searchQuery;



    public static String getChangedProductName() {
        return changedProductName;
    }

    public static void setChangedProductName(String changedProductName) {
        TestHelperCatalog.changedProductName = changedProductName;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        TestHelperCatalog.productName = productName;
    }


    private static String SynonymFor;


    public static String getSynonymFor() {
        return SynonymFor;
    }

    public static void setSynonymFor(String synonymFor) {
        SynonymFor = synonymFor;
    }

    public static String getSearchQuery() {
        return searchQuery;
    }

    public static void setSearchQuery(String searchQuery) {
        TestHelperCatalog.searchQuery = searchQuery;
    }

    public static String getSubName() {
        return subName;
    }

    public static void setSubName(String subName) {
        TestHelperCatalog.subName = subName;
    }

    public static String getRootName() {
        return rootName;
    }

    public static void setRootName(String rootName) {
        TestHelperCatalog.rootName = rootName;
    }

    public static String getChangeRootName() {
        return changeRootName;
    }

    public static String getsearchQuery() {
        return searchQuery;
    }

    public static void setsearchQuery(String searchQuery) {
        TestHelperCatalog.searchQuery = searchQuery;
}

    public static void setChangeRootName(String changeRootName) {
        TestHelperCatalog.changeRootName = changeRootName;
    }
}
