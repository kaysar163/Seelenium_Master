package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "//tbody/tr/td[contains(text(),'Reinaldo')]//following::td[9]//a[text()='Edit']")
    WebElement customerEditButton;
//    WebElement cusEditButt=driver.findElement(By.xpath(String.format("//tbody/tr/td[contains(text(),'%s')]//following::td[9]//a[text()='Edit']",customerInformationPage.firstName)));
    @FindBy(xpath = "//*[text()='The customer has been saved.']")
    WebElement passwordChangeSuccessMessage;
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
    
    //Locate elements for delete customer function
    @FindBy(id="customerGrid_filter_name")
    WebElement nameFilter;
    @FindBy(xpath = "//button//span[contains(text(),'Search')]")
    WebElement searchButtonForDelete;
    @FindBy(xpath = "//tr//td[contains(text(),'495')]/following-sibling::td//a[contains(text(),'Edit')]")
    WebElement editButtonNotRandom;
    @FindBy(xpath = "//span[contains(text(),'Delete Customer')][1]")
    WebElement deleteCustomer;
    @FindBy(xpath = "//span[contains(text(),'The customer has been deleted.')]")
    WebElement deleteSuccessMessage;

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
        
    public void deleteCustomer(){
        functionClass.waitUntilElementPresent(nameFilter);
        nameFilter.sendKeys("Irshad01 Toghraq01");
        functionClass.waitUntilElementPresent(searchButtonForDelete);
        searchButtonForDelete.click();
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


