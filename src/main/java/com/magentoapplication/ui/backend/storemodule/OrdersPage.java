package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

    WebDriver driver;

    FunctionClass functionClass;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }

    //Elements Meryem Create A new order
















    //Elements Meryem edit orders










    //Meryem create Order Method












    //Meryem create Order Method




}
