package com.magentoapplication.ui.backend.customersmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerGroupPage {
    WebDriver driver;
    String configFileName="testdatafolder/testdata.properties";

    public EditCustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement customerGroupsLink;




}
