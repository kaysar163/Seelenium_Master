package com.magentoapplication.ui.backend.customersmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerGroupPage {
    WebDriver driver;

    public EditCustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



}
