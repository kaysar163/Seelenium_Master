package com.magentoapplication.ui.backend.storemodule;

public class TestHelperClassStore {
    private static String productName;

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        TestHelperClassStore.productName = productName;
    }
}
