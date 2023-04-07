package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
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



    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customerLink;
        @FindBy(xpath ="//span[text()='Customer Groups']")
    WebElement customerGroupsLink;

    @FindBy( xpath = "(//span[contains(text(),'Add New Customer Group')])[1]")
    WebElement AddNewCustomerGroupButton;

    @FindBy(id="customer_group_code")
    WebElement GroupNameField;

    @FindBy(id="tax_class_id")
    WebElement TaxClassDropdown;

    @FindBy(xpath = "//button[@class='scalable save' and @title='Save Customer Group']")
    WebElement SaveCustomerGroupButton;

    @FindBy(xpath = "//span[contains(text(),'The customer group has been saved.')]")
    WebElement TheCustomerGroupHasBeenSavedMessage;


    public void addNewCustomerGroup(){
        Actions actions=new Actions(driver);
        actions.moveToElement(customersManagerPage.customerLink).moveToElement(customerGroupsLink).click().build().perform();
        AddNewCustomerGroupButton.click();
        GroupNameField.clear();
        GroupNameField.sendKeys(functionClass.generateFakeName());
        Select select=new Select(TaxClassDropdown);
        select.selectByValue("5");
        functionClass.waitUntilElementPresent(SaveCustomerGroupButton);
        SaveCustomerGroupButton.click();

    }

    public boolean verifyTheCustomerGroupHasBeenSaved() {
       if (TheCustomerGroupHasBeenSavedMessage.isDisplayed()){
           return true;}
       else
           return false;}




    }







