package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerGroupPage {

    WebDriver driver;
    FunctionClass functionClass;
        public CustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass = new FunctionClass(driver);
    }


    @FindBy(xpath ="//span[text()='Customer Groups']")
    WebElement customerGroupsLink;

    @FindBy( xpath = "//div[@class='content-header']//button)[1]")
    WebElement AddNewCustomerGroupButton;

    @FindBy(id="customer_group_code")
    WebElement GroupNameField;

    @FindBy(id="tax_class_id")
    WebElement TaxClassDropdown;

    @FindBy(css = ".wrapper>.middle>div>.content-header>p>button[title=\"Save Customer Group\"]")
    WebElement SaveCustomerGroupButton;

    @FindBy(xpath = "//span[contains(text(),'The customer group has been saved.')]")
    WebElement TheCustomerGroupHasBeenSavedMessage;


    public void  AddNewCustomerGroup(){

        functionClass.waitUntilElementPresent(customerGroupsLink);
        AddNewCustomerGroupButton.click();
        functionClass.waitUntilElementPresent(AddNewCustomerGroupButton);
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







