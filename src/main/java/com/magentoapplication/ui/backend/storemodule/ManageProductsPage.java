package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsPage {
    WebDriver driver;

    FunctionClass functionClass;

    public ManageProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }


    public static boolean CatologPoductDeletete() {
        return false;
    }


    //Elements Muyesser add product
















    //Elements Muyesser edit product










    //Elements Muyesser add method












    //Elements Muyesser edit method




}
