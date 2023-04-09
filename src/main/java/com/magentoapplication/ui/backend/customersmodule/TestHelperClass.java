package com.magentoapplication.ui.backend.customersmodule;

public class TestHelperClass {

    private static String customerFirstName;

    private static String groupName;

    private static String changedGroupName;

    private static String email;

    public static String getChangedGroupName() {
        return changedGroupName;
    }

    public static void setChangedGroupName(String changedGroupName) {
        TestHelperClass.changedGroupName = changedGroupName;
    }

    public static String getGroupName() {
        return groupName;
    }

    public static void setGroupName(String groupName) {
        TestHelperClass.groupName = groupName;
    }

    public static String getCustomerFirstName() {
        return customerFirstName;
    }

    public static void setCustomerFirstName(String customerFirstName) {
        TestHelperClass.customerFirstName = customerFirstName;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TestHelperClass.email = email;
    }
}
