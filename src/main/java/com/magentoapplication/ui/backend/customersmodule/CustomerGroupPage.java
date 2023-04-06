package com.magentoapplication.ui.backend.customersmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerGroupPage {

    WebDriver driver;

    public CustomerGroupPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement customerGroupsLink;



}
