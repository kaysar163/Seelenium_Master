package com.magentoapplication.ui.backend.salesmodule;


public class TestHelperSales {

    private  static String taxRuleName;
    
    public static String getTaxRuleName() {
        return taxRuleName;
    }

    public static void setTaxRuleName(String taxRuleName) {
        TestHelperSales.taxRuleName = taxRuleName;
    }


    private static String lastName;
    private static String firstName;

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        TestHelperSales.lastName = lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        TestHelperSales.firstName = firstName;
    }
    
    private static String incrementId;
    
    public static String getIncrementId() { return incrementId;}
    public static void setIncrementId(String incrementId)
    { TestHelperSales.incrementId = incrementId; }
    
    
}
