package com.magentoapplication.ui.backend.salesmodule;

public class TestHelperSales {

    private static  String taxRuleName;

    public static String getTaxRuleName() {
        return taxRuleName;
    }

    public static void setTaxRuleName(String taxRuleName) {
        TestHelperSales.taxRuleName = taxRuleName;
    }

    public static String getFirstNameField() {
        return firstNameField;
    }

    public static void setFirstNameField(String firstNameField) {
        TestHelperSales.firstNameField = firstNameField;
    }

    private static String firstNameField;

}