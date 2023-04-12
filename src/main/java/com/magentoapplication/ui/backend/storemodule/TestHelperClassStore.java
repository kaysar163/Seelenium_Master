package com.magentoapplication.ui.backend.storemodule;

public class TestHelperClassStore {

    private static String websiteName;
    private static String changedWebsiteName;

    public static String getChangedWebsiteName() {
        return changedWebsiteName;
    }

    public static void setChangedWebsiteName(String changedWebsiteName) {
        TestHelperClassStore.changedWebsiteName = changedWebsiteName;
    }

    public static String getWebsiteName() {
        return websiteName;
    }

    public static void setWebsiteName(String websiteName) {
        TestHelperClassStore.websiteName = websiteName;
    }
}
