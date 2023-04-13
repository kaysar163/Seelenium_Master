package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderViewPage {

    WebDriver driver;

    FunctionClass functionClass;

    public OrderViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }



}
