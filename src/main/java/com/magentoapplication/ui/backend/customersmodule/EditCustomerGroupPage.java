package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditCustomerGroupPage {
    WebDriver driver;
    FunctionClass functionClass;
    CustomersManagerPage customersManagerPage;
    String configFileName = "testdatafolder/testdata.properties";

    public EditCustomerGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        customersManagerPage = new CustomersManagerPage(driver);
    }

    //meryem
    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement customerGroupsLink;
    @FindBy(xpath = "//table[@id=\"customerGroupGrid_table\"]//tbody/tr//td[contains(text(),'728')]")
    WebElement editCustomerGroupButton;
    @FindBy(id = "customer_group_code")
    WebElement groupNameFiled;
    @FindBy(id = "tax_class_id")
    WebElement taxDropdown;
    @FindBy(xpath = "//span[text()='Save Customer Group']")
    WebElement saveCustomerButton;
    @FindBy(xpath = "//span[text()='The customer group has been saved.']")
    WebElement verifyCustomerGroupEditedMessage;
    //meryem
    @FindBy(xpath = "(//span[contains(text(),'Delete Customer Group')])[1]")
    WebElement deleteGroupButton;
    @FindBy(xpath = "//span[text()='Delete Customer Group']")
    WebElement deleteCustomerGroup;
    @FindBy(xpath = "//span[text()='The customer group has been deleted.']")
    WebElement verifyCustomerGroupDeletedMessage;

    public void editCustomerGroupInfo() {
        customersManagerPage.customerLink.click();
        customerGroupsLink.click();
        editCustomerGroupButton.click();
        groupNameFiled.clear();
        groupNameFiled.sendKeys(functionClass.generateFakeName());
        Select meryem = new Select(taxDropdown);
        meryem.selectByValue("3");
        saveCustomerButton.click();
    }

    public boolean verifyCustomerGroupEditedTest() {
        if (verifyCustomerGroupEditedMessage.isDisplayed())
            return true;
        else return false;
    }

    public void deleteCustomerGroupInfo() {
        customersManagerPage.customerLink.click();
        customerGroupsLink.click();
        editCustomerGroupButton.click();
        deleteGroupButton.click();
        driver.switchTo().alert().accept();

    }

    public boolean verifyCustomerGroupDeletedTest1() {
        if (verifyCustomerGroupDeletedMessage.isDisplayed())
            return true;
        else return false;

    }
}