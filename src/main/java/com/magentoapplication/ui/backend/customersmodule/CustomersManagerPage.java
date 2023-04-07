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
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
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

    @FindBy(id = "customerGrid_filter_billing_country_id")
    WebElement CountryDropdown;

    @FindBy(css = "button[title='Search']")
    WebElement SearchButton;

    @FindBy(id = "customerGrid-total-count")
    WebElement verifyFilteredMessage;


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


    public void filterCustomerByCountry() {
        functionClass.waitUntilElementPresent(CountryDropdown);
        CountryDropdown.click();
        Select select = new Select(CountryDropdown);
        select.selectByValue("TR");
        functionClass.waitUntilElementPresent(SearchButton);
        SearchButton.click();
    }

    public boolean verifyCustomerFilteredByCountry(){
        if (verifyFilteredMessage.isDisplayed())
           return true;
        else return false;

   }
}
