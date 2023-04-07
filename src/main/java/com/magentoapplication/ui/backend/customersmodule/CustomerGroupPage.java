package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerGroupPage {

    WebDriver driver;
    FunctionClass functionClass;
    public CustomerGroupPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement customerGroupsLink;

    @FindBy(xpath = "//button[@title='Add New Customer Group']")
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
        customerGroupsLink.click();
        functionClass.waitUntilElementPresent(customerGroupsLink);
        AddNewCustomerGroupButton.click();
        functionClass.waitUntilElementPresent(AddNewCustomerGroupButton);
        GroupNameField.clear();
        GroupNameField.sendKeys(functionClass.generateFakeName());
        Select select=new Select(TaxClassDropdown);
        select.selectByValue("5");
        SaveCustomerGroupButton.click();
        functionClass.waitUntilElementPresent(SaveCustomerGroupButton);

    }

    public boolean verifyTheCustomerGroupHasBeenSaved() {
        return (TheCustomerGroupHasBeenSavedMessage.isDisplayed());




    }





}
