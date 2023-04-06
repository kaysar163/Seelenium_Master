package com.magentoapplication.ui.backend.customersmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersManagerPage {
    WebDriver driver;

    public CustomersManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customerLink;

    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;

    @FindBy(css = "#customerGrid_massaction-select")
    WebElement actionsDropdown;

    @FindBy(xpath = "//select[@id='visibility']")
    WebElement groupsDropdown;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;





}
