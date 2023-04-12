package com.magentoapplication.ui.backend.storemodule;

public class TestHelperClassStore {
    private static String productName;

    private static String storeName;

    public static String getStoreName() {
        return storeName;
    }

    public static void setStoreName(String storeName) {
        TestHelperClassStore.storeName = storeName;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        TestHelperClassStore.productName = productName;
    }
}

