package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersManagerPage {
    WebDriver driver;

    FunctionClass functionClass;

    public CustomersManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
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

    @FindBy(xpath = "//span[text()='Total of 1 record(s) were updated.']")
    WebElement verifyUpdateMessage;
    @FindBy(id = "customerGrid_filter_email")
    WebElement emailField;
    @FindBy(xpath = "(//span[contains(text(),'Search')])[2]")
    WebElement searchButton;

    @FindBy(xpath = "//select[@id=\"customerGrid_filter_group\"]")
    WebElement groupFilterDropdown;


    @FindBy(xpath = "//a[text()='Select All']")
    WebElement SelectAll;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportButton;



    public void FilterCustomersByEmail() {
        functionClass.waitUntilElementPresent(emailField);
        emailField.sendKeys(functionClass.generateFakeEmail());
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
    }

    public void filterTheCustomerByGroup() {
        functionClass.waitUntilElementPresent(groupFilterDropdown);
        groupFilterDropdown.click();
        Select selectGroup = new Select(groupFilterDropdown);
        selectGroup.selectByVisibleText("sabahet");
        functionClass.sleep(2);
        searchButton.click();

    }

    public boolean verifyFilterTheCustomerByGroup() {
        if (driver.getPageSource().contains("sabahet")) {
            return true;
        } else {
            return false;
        }
    }

        public void assignGroupToCustomer() {
            functionClass.waitUntilElementPresent(customerLink);
            customerLink.click();
            functionClass.waitUntilElementPresent(manageCustomersLink);
            manageCustomersLink.click();
            Select select = new Select(actionsDropdown);
            select.selectByValue("Assign a Customer Group");
            functionClass.waitUntilElementPresent(groupsDropdown);
            Select select1 = new Select(groupsDropdown);
            select1.selectByValue("Team1apitesttttt");
            submitButton.click();
        }

        public boolean verifyUpdate() {
            if (verifyUpdateMessage.isDisplayed())
                return true;
            else return false;
        }

    public void exportCustomers() {
        functionClass.waitUntilElementPresent(SelectAll);
        SelectAll.click();
        functionClass.waitUntilElementPresent(exportButton);
        exportButton.click();

    }

    public boolean verifyExportCustomer() {
        if (exportButton.isEnabled()) {
            return true;
        } else
            return false;
    }

    }


