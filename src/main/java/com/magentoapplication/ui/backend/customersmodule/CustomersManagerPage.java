package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomersManagerPage {
    WebDriver driver;
    FunctionClass functionClass;

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

    @FindBy(xpath = "//select[@id=\"customerGrid_filter_group\"]")
    WebElement groupFilterDropdown;

    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement searchButton;

    public void filterTheCustomerByGroup() {
        functionClass.waitUntilElementPresent(groupFilterDropdown);
        groupFilterDropdown.click();
        Select selectGroup = new Select(groupFilterDropdown);
        selectGroup.selectByVisibleText("sabahat");
        functionClass.sleep(2);
        searchButton.click();

    }

    public boolean verifyFilterTheCustomerByGroup() {
        if (driver.getPageSource().contains("sabahat")) {
            return true;
        } else {
            return false;
        }

    }
}