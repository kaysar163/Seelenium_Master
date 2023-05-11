package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(id="//a[text()='Edit']")
    WebElement customerEditButton;
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
    @FindBy(xpath = "//a[@id='customer_info_tabs_account' and @title='Account Information']")
    WebElement accountInformation;
    @FindBy(xpath = "//input[@id='account-send-pass' and @name='account[new_password]']")
    WebElement accountInformationCheckBox;
    @FindBy(css = "input#_accountcurrent_password")
    WebElement accountPassword;
    @FindBy(xpath = "(//button[@class='scalable save' and @title='Save Customer'])[2]")
    WebElement saveCustomerButton;
    //Add to the new address element
    @FindBy(id = "customer_info_tabs_addresses")
    WebElement addressesButton;

    @FindBy(name = "add_address_button")
    WebElement addAddressesButton;

    @FindBy(id = "address_item_billing_item1")
    WebElement defualtBilling;

    @FindBy(id = "address_item_shipping_item1")
    WebElement defaultShpping;

    @FindBy(xpath = "(//*[contains(@id,'street0')])[2]")
    WebElement streetAddress;

    @FindBy(id = "_item1city")
    WebElement city;

    @FindBy(css = ".input-text.required-entry.validate-select")
    WebElement stateProvince;

    @FindBy(css = "input[id='_item1postcode']")
    WebElement zipPostalCode;

    @FindBy(css = "input[id='_item1telephone']")
    WebElement telephone;

    @FindBy(xpath = "(//button[@class='scalable save'])[1]")
    WebElement saveButton2;

    @FindBy(xpath = "//span[text()='The customer has been saved.']")
    WebElement verifyAddNewAddress;

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
//        functionClass.waitUntilElementPresent(customersManagerPage.resetFilterButton);
//        functionClass.sleep(2);
//        customersManagerPage.resetFilterButton.click();
//        functionClass.waitUntilElementPresent(customersManagerPage.emailField);
//        customersManagerPage.emailField.sendKeys(TestHelperClass.getEmail());
//        functionClass.waitUntilElementPresent(customersManagerPage.searchButton);
//        functionClass.sleep(2);
//        customersManagerPage.searchButton.click();
        WebElement cusEditButt=driver.findElement(By.xpath(String.format("//tbody/tr/td[contains(text(),'%s')]//following::td[8]//a[text()='Edit']",TestHelperClass.getEmail())));
        System.out.println(cusEditButt+"email editing");
        functionClass.waitUntilElementPresent(cusEditButt);
        functionClass.sleep(1);
        Actions actions=new Actions(driver);
        actions.click(cusEditButt).build().perform();
        accountInformation.click();
        accountInformationCheckBox.click();
        accountPassword.sendKeys(ApplicationConfig.readFromConfigProperties("config.properties","backEndPassword"));
//        saveCustomerButton.click();
        functionClass.clickOnJavaScript(saveCustomerButton);
    }
    public boolean passwordSuccessfullyChanged(){
        functionClass.waitUntilElementPresent(customersManagerPage.passwordChangeSuccessMessage);
        if(customersManagerPage.passwordChangeSuccessMessage.isDisplayed())
            return true;
        else return false;
    }
    public void customerManagerCanAddANewAddressForACustomer() {
        functionClass.waitUntilElementPresent(customersManagerPage.customerLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(customersManagerPage.customerLink).moveToElement(customersManagerPage.manageCustomersLink).click().build().perform();
        WebElement cusEditButt = driver.findElement(By.xpath(String.format
                ("//tbody/tr/td[contains(text(),'%s')]//following::td[8]//a[text()='Edit']",TestHelperClass.getEmail())));
        System.out.println(cusEditButt+"email add address");
        functionClass.waitUntilElementPresent(cusEditButt);
        cusEditButt.click();
        functionClass.waitUntilElementPresent(addressesButton);
        addressesButton.click();
        functionClass.waitUntilElementPresent(addAddressesButton);
        addAddressesButton.click();
        functionClass.waitUntilElementPresent(defualtBilling);
        defualtBilling.click();
        functionClass.waitUntilElementPresent(defaultShpping);
        defaultShpping.click();
        functionClass.sleep(1);
        functionClass.waitUntilElementPresent(streetAddress);
        //streetAddress.clear();
        streetAddress.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(city);
        city.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(stateProvince);
        Select select = new Select(stateProvince);
        select.selectByValue("12");
        zipPostalCode.sendKeys(functionClass.generateZipCode());
        telephone.sendKeys(functionClass.generateTelephoneNumber());
        //functionClass.waitUntilElementPresent(saveCustomerButton);
        functionClass.sleep(1);
        Actions actions1=new Actions(driver);
        actions1.click(saveButton2).build().perform();
        //saveCustomerButton.click();

    }
    public boolean verifyAddNewAddress() {
        functionClass.waitUntilElementPresent(verifyAddNewAddress);
        if (verifyAddNewAddress.isDisplayed())
            return true;
        else return false;
    }
}
