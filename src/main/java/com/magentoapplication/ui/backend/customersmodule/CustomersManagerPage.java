package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersManagerPage {
    WebDriver driver;

    FunctionClass functionClass;
    final static String configFile="testdatafolder/testdata.properties";

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
    
    
    //Locate elements for delete customer function
    @FindBy(id="customerGrid_filter_name")
    WebElement nameFilter;
    @FindBy(xpath = "//button//span[contains(text(),'Search')]")
    WebElement searchButton;
    @FindBy(xpath = "//tr//td[contains(text(),'495')]/following-sibling::td//a[contains(text(),'Edit')]")
    WebElement editButtonNotRandom;
    @FindBy(xpath = "//span[contains(text(),'Delete Customer')][1]")
    WebElement deleteCustomer;
    @FindBy(xpath = "//span[contains(text(),'The customer has been deleted.')]")
    WebElement deleteSuccessMessage;


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

    public void deleteCustomer(){
        functionClass.waitUntilElementPresent(nameFilter);
        nameFilter.sendKeys("Irshad01 Toghraq01");
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        functionClass.waitUntilElementPresent(editButtonNotRandom);
        editButtonNotRandom.click();
        functionClass.waitUntilElementPresent(deleteCustomer);
        deleteCustomer.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    
    public boolean verifyDeleteCustomer(){
        if(deleteSuccessMessage.isDisplayed()){
            System.out.println("Customer was deleted.");
            return true;
        }
        else
            return false;
    }
    
    public boolean verifyUpdate(){
        if (verifyUpdateMessage.isDisplayed())
            return true;
        else return false;
    }

}
