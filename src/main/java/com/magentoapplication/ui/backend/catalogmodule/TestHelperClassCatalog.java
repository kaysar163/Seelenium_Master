package com.magentoapplication.ui.backend.catalogmodule;

public class TestHelperClassCatalog {

    private static String subName;

    private static String searchQuery ;
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
        TestHelperClassCatalog.searchQuery = searchQuery;
    }

    public static String getSubName() {
        return subName;
    }

    public static void setSubName(String subName) {
        TestHelperClassCatalog.subName = subName;
    }
}
