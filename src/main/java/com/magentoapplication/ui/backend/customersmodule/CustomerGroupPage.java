package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerGroupPage {

    WebDriver driver;
    FunctionClass functionClass;
    CustomersManagerPage customersManagerPage;
        public CustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass = new FunctionClass(driver);
        customersManagerPage=new CustomersManagerPage(driver);
    }

    @FindBy(xpath = "//td[contains(text(),\"Brenda11\")]")
    WebElement existingGroupName;

    String config = "testdatafolder/testdata.properties";

    @FindBy(id = "tax_class_id")
    WebElement TaxClass;

    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customerLink;
        @FindBy(xpath ="//span[text()='Customer Groups']")
    WebElement customerGroupsLink;



    @FindBy( xpath = "(//span[contains(text(),'Add New Customer Group')])[1]")
    WebElement addNewCustomerGroupButton;

    @FindBy(id="customer_group_code")
    WebElement groupNameField;

    @FindBy(id="tax_class_id")
    WebElement taxClassDropdown;

    @FindBy(xpath = "//button[@class='scalable save' and @title='Save Customer Group']")
    WebElement saveCustomerGroupButton;

    @FindBy(id="customerGroupGrid_filter_type")
    WebElement groupFilterField;

    @FindBy(xpath = "//span[contains(text(),'The customer group has been saved.')]")
    WebElement theCustomerGroupHasBeenSavedMessage;
    @FindBy(xpath="//button[@class=\"scalable task\"]")
    WebElement groupSearchButton;

    @FindBy(xpath = "//span[contains(text(),'The customer group has been saved.')]")
    WebElement TheCustomerGroupHasBeenSavedMessage;

    @FindBy(xpath = "//button[@class='scalable save' and @title='Save Customer Group']")
    WebElement SaveCustomerGroupButton;
    //gulzar-customer -group


    public void addNewCustomerGroup(){
        functionClass.sleep(2);
        Actions actions=new Actions(driver);
        actions.moveToElement(customersManagerPage.customerLink).moveToElement(customerGroupsLink).click().build().perform();
        addNewCustomerGroupButton.click();
        groupNameField.clear();
        TestHelperClass.setGroupName(functionClass.generateFakeName());
        groupNameField.sendKeys(TestHelperClass.getGroupName());
        Select select=new Select(taxClassDropdown);
        select.selectByValue("5");
        functionClass.waitUntilElementPresent(saveCustomerGroupButton);
        saveCustomerGroupButton.click();

    }

    public boolean verifyTheCustomerGroupHasBeenSaved() {
       if (theCustomerGroupHasBeenSavedMessage.isDisplayed()){
           return true;}
       else
           return false;}


    public void updateExistingCustomerGroups( ){
        Actions actions=new Actions(driver);
        actions.moveToElement(customersManagerPage.customerLink).moveToElement(customerGroupsLink).click().build().perform();
        functionClass.waitUntilElementPresent(groupFilterField);
       // groupFilterField.click();
        groupFilterField.sendKeys(TestHelperClass.getGroupName());
        functionClass.waitUntilElementPresent(groupSearchButton);
        groupSearchButton.click();
        WebElement existingGroupName=driver.findElement(By.xpath(String.format("//tbody/tr/td[2][contains(text(),'%s')]",TestHelperClass.getGroupName())));
        functionClass.waitUntilElementPresent(existingGroupName);
        existingGroupName.click();
        //existingGroupName.sendKeys(functionClass.generateFakeName());

        functionClass.waitUntilElementPresent(TaxClass);
        TaxClass.click();
        Select select=new Select(TaxClass);
        select.selectByIndex(3);
        functionClass.waitUntilElementPresent(SaveCustomerGroupButton);
        SaveCustomerGroupButton.click();

    }
    public boolean verifyUpdateExistingCustomerGroups(){
        functionClass.waitUntilElementPresent(TheCustomerGroupHasBeenSavedMessage);
        if (TheCustomerGroupHasBeenSavedMessage.getText().contains("saved")){
            return true;
        }else
            return false;
}

}





