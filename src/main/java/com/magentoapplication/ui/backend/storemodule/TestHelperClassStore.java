package com.magentoapplication.ui.backend.storemodule;

public class TestHelperClassStore {
    private static String productName;
    private static String storeName;
    private static String firstname;

    private static  String changedProductName;
    private  static String categoryName;

    public static String getCategoryName() {
        return categoryName;
    }

    public static void setCategoryName(String categoryName) {
        TestHelperClassStore.categoryName = categoryName;
    }

    public static String getChangedProductName() {
        return changedProductName;
    }

    public static String getFirstname() {
        return firstname;
    }

    public static void setFirstname(String firstname) {
        TestHelperClassStore.firstname = firstname;
    }

    public static void setChangedProductName(String changedProductName) {
        TestHelperClassStore.changedProductName = changedProductName;

    }

    public static String getCategoryProductName() {
        return CategoryProductName;
    }

    public static void setCategoryProductName(String categoryProductName) {
        CategoryProductName = categoryProductName;
    }

    private  static String CategoryProductName;

    public static String getStoreName() {
        return storeName;
    }

    public static void setStoreName(String storeName) {
        TestHelperClassStore.storeName = storeName;
    }

    public static String getWebsiteName() {
        return websiteName;
    }

    public static void setWebsiteName(String websiteName) {
        TestHelperClassStore.websiteName = websiteName;
    }

    private static String websiteName;



    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        TestHelperClassStore.productName = productName;
    }
}
