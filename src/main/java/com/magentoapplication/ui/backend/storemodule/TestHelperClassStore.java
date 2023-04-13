package com.magentoapplication.ui.backend.storemodule;

public class TestHelperClassStore {
    private static String productName;
    private static String storeName;

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
