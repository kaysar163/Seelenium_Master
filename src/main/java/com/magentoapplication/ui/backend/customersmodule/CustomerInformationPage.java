package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInformationPage {
    WebDriver driver;
    FunctionClass functionClass;
    CustomersManagerPage customersManagerPage;



    public CustomerInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        customersManagerPage=new CustomersManagerPage(driver);
    }
    @FindBy(xpath = "(//*[contains(text(),'Add New Customer')])[1]")
    WebElement addNewCustomerLink;
    @FindBy(id="_accountprefix")
    WebElement prefixField;
    @FindBy(id="_accountfirstname")
    WebElement firstNameField;
    @FindBy(id="_accountlastname")
    WebElement lastNameField;
    @FindBy(id="_accountemail")
    WebElement emailField;
    @FindBy(id="_accounttaxvat")
    WebElement taxNumberField;
    @FindBy(id="_accountpassword")
    WebElement passwordfield;
    @FindBy(xpath = "//*[@class='middle']//button[@title='Save Customer']")
    WebElement SavaCustomerButton;
    @FindBy(xpath = "//*[contains(text(),'The customer has been saved.')]")
    WebElement customerSuccessfullySavadMessage;
    @FindBy(xpath = "//a[@id='customer_info_tabs_account' and @class='tab-item-link']")
    WebElement accountInformation;
    @FindBy(xpath = "//input[@id='account-send-pass' and @name='account[new_password]']")
    WebElement accountInformationCheckBox;
    @FindBy(css = "input#_accountcurrent_password")
    WebElement accountPassword;
    @FindBy(xpath = "(//button[@class='scalable save' and @title='Save Customer'])[2]")
    WebElement saveCustomerButton;

    public void addCustomerMethod(){
        functionClass.waitUntilElementPresent(addNewCustomerLink);
        addNewCustomerLink.click();
        functionClass.waitUntilElementPresent(firstNameField);
        TestHelperClass.setCustomerFirstName(functionClass.generateFakeName());
        firstNameField.sendKeys(TestHelperClass.getCustomerFirstName());
        functionClass.waitUntilElementPresent(lastNameField);
        lastNameField.sendKeys(functionClass.generateFakeLastName());
        functionClass.waitUntilElementPresent(emailField);
        TestHelperClass.setEmail(functionClass.generateFakeEmail());
        emailField.sendKeys(TestHelperClass.getEmail());
        functionClass.waitUntilElementPresent(passwordfield);
        passwordfield.sendKeys(functionClass.generateFakePassword());
        functionClass.waitUntilElementPresent(SavaCustomerButton);
        SavaCustomerButton.click();
}
    public boolean verifyCustomer(){
        functionClass.waitUntilElementPresent(customerSuccessfullySavadMessage);
        if (customerSuccessfullySavadMessage.isDisplayed()) {
            return true;
        } else return false;
    }
    public void customerPasswordChange(){
//        functionClass.waitUntilElementPresent(customersManagerPage.customerLink);
//        Actions actions=new Actions(driver);
//        actions.moveToElement(customersManagerPage.customerLink).moveToElement(customersManagerPage.manageCustomersLink).click().build().perform();
        functionClass.waitUntilElementPresent(customersManagerPage.resetFilterButton);
        functionClass.sleep(2);
        customersManagerPage.resetFilterButton.click();
        functionClass.waitUntilElementPresent(customersManagerPage.emailField);
        customersManagerPage.emailField.sendKeys(TestHelperClass.getEmail());
        functionClass.waitUntilElementPresent(customersManagerPage.searchButton);
        customersManagerPage.searchButton.click();
        WebElement cusEditButt=driver.findElement(By.xpath(String.format("//tbody/tr/td[contains(text(),'%s')]//following::td[9]//a[text()='Edit']",TestHelperClass.getCustomerFirstName())));
        functionClass.waitUntilElementPresent(cusEditButt);
        functionClass.sleep(1);
        cusEditButt.click();
        accountInformation.click();
        accountInformationCheckBox.click();
        accountPassword.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties","backEndPassword"));
        saveCustomerButton.click();
    }
    public boolean passwordSuccessfullyChanged(){
        functionClass.waitUntilElementPresent(customersManagerPage.passwordChangeSuccessMessage);
        if(customersManagerPage.passwordChangeSuccessMessage.isDisplayed())
            return true;
        else return false;
    }
}
