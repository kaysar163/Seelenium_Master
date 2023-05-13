package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
//    @FindBy(xpath = "//table[@id=\"customerGroupGrid_table\"]//tbody/tr//td[contains(text(),'728')]")
//    WebElement editCustomerGroupButton;
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

    @FindBy(id = "customerGroupGrid_filter_type")
    WebElement groupNameSearchField;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searButton;
    @FindBy(xpath = "//span[text()='The customer group has been deleted.']")
    WebElement verifyCustomerGroupDeletedMessage;
    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customerLink;
    @FindBy(xpath = "//tbody/tr/td[contains(text(),'Reinaldo')]//following::td[9]//a[text()='Edit']")
    WebElement customerEditButton;
    //    WebElement cusEditButt=driver.findElement(By.xpath(String.format("//tbody/tr/td[contains(text(),'%s')]//following::td[9]//a[text()='Edit']",customerInformationPage.firstName)));
    @FindBy(xpath = "//*[text()='The customer has been saved.']")
    WebElement passwordChangeSuccessMessage;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;
    @FindBy(xpath = "//span[text()='Search']//parent::span//parent::span//parent::button")
    WebElement searchButton;

    public void editCustomerGroupInfo() {
        customersManagerPage.customerLink.click();
        customerGroupsLink.click();
        //Actions actions=new Actions(driver);

        /*functionClass.waitUntilElementPresent(customerLink);
        actions.click(customerLink).build().perform();
        functionClass.waitUntilElementPresent(manageCustomersLink);
        manageCustomersLink.click();*/
        functionClass.waitUntilElementPresent(groupNameSearchField);
        groupNameSearchField.sendKeys(TestHelperClass.getGroupName());
        functionClass.waitUntilElementPresent(searButton);
        searButton.click();
        WebElement editCustomerGroupButton=driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]",TestHelperClass.getGroupName())));
        functionClass.waitUntilElementPresent(editCustomerGroupButton);
        functionClass.sleep(1);
        editCustomerGroupButton.click();
        groupNameFiled.clear();
        TestHelperClass.setChangedGroupName(functionClass.generateFakeName());
        groupNameFiled.sendKeys(TestHelperClass.getChangedGroupName());
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
        functionClass.waitUntilElementPresent(customerLink);
        customerLink.click();
        functionClass.waitUntilElementPresent(manageCustomersLink);
        manageCustomersLink.click();
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(groupNameSearchField);
        groupNameSearchField.clear();
        groupNameSearchField.sendKeys(TestHelperClass.getChangedGroupName());
        functionClass.waitUntilElementPresent(searButton);
        searButton.click();
        WebElement editCustomerGroupButton=driver.findElement(By.xpath(String.format("//td[contains(text(),'%s')]",TestHelperClass.getChangedGroupName())));
        functionClass.waitUntilElementPresent(editCustomerGroupButton);
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