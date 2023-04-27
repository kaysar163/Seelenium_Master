package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPageSales {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    Actions actions;

    public OrdersPageSales(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        salesDashboardPage = new SalesDashboardPage(driver);
        actions=new Actions(driver);
    }

    @FindBy(xpath = "(//span[text()='Create New Order'])[1]")
    WebElement CreateNewOrderLink;
    @FindBy(xpath = "//span[contains(text(),'Create New Customer')]")
    WebElement CreateNewCustomerLink;
    @FindBy(id = "store_317")
    WebElement storeName;
    @FindBy(xpath = "//span[contains(text(),'Add Products')]")
    WebElement AddProductsLink;
    @FindBy(xpath = "//input[@value='2284']")
    WebElement selectBox;
    @FindBy(xpath = "//span[contains(text(),'Add Selected Product(s) to Order')]")
    WebElement addSelectedPrdcLink;
    @FindBy(id = "order-billing_address_firstname")
    WebElement firstNameField;
    @FindBy(id = "order-billing_address_lastname")
    WebElement lastNameField;
    @FindBy(id = "order-billing_address_street0")
    WebElement streetAddressField;
    @FindBy(id = "order-billing_address_city")
    WebElement cityField;
    @FindBy(id = "order-billing_address_country_id")
    WebElement countryField;
//    @FindBy(css = "select[id='order-billing_address_region_id']")
//    WebElement stateField;
    @FindBy(id = "order-billing_address_postcode")
    WebElement zipCodeField;
    @FindBy(id = "order-billing_address_telephone")
    WebElement telephoneField;
    @FindBy(xpath = "//input[@id='p_method_cashondelivery']")
    WebElement paymentMethodBut;
    @FindBy(xpath = "//a[contains(text(),'Get shipping methods and rates ')]")
    WebElement shippingMethodBut;
    @FindBy(xpath = "//input[@id='s_method_freeshipping_freeshipping']")
    WebElement freeShippingBut;
    @FindBy(xpath = "(//span[text()='Submit Order'])[2]")
    WebElement submitOrderBut;
    @FindBy(xpath = "//span[text()='The order has been created.']")
    WebElement successMessage;

    public void createNewOrder() {
        salesDashboardPage.clickOnOrdersLink();
        functionClass.waitUntilElementPresent(CreateNewOrderLink);
        CreateNewOrderLink.click();
        functionClass.waitUntilElementPresent(CreateNewCustomerLink);
        CreateNewCustomerLink.click();
        functionClass.waitUntilElementPresent(storeName);
        storeName.click();
        functionClass.waitUntilElementPresent(AddProductsLink);
        functionClass.sleep(3);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[0].scrollIntoView()", AddProductsLink);
        //AddProductsLink.click();
        actions.click(AddProductsLink).build().perform();
        functionClass.waitUntilElementPresent(selectBox);
        selectBox.click();
        functionClass.waitUntilElementPresent(addSelectedPrdcLink);
        addSelectedPrdcLink.click();
        functionClass.waitUntilElementPresent(firstNameField);
        firstNameField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties", "firstName"));
        functionClass.waitUntilElementPresent(lastNameField);
        lastNameField.sendKeys(functionClass.generateFakeLastName());
        functionClass.waitUntilElementPresent(streetAddressField);
        streetAddressField.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(cityField);
        cityField.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(countryField);
        countryField.sendKeys(functionClass.generateCountryName());
//        functionClass.waitUntilElementPresent(stateField);
//        //functionClass.sleep(10);
//        Select select=new Select(stateField);
//        select.selectByIndex(13);
        functionClass.waitUntilElementPresent(zipCodeField);
        zipCodeField.sendKeys(functionClass.generateZipCode());
        functionClass.waitUntilElementPresent(telephoneField);
        telephoneField.sendKeys(functionClass.generateTelephoneNumber());
        functionClass.waitUntilElementPresent(paymentMethodBut);
        paymentMethodBut.click();
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(shippingMethodBut);
        shippingMethodBut.click();
        functionClass.waitUntilElementPresent(freeShippingBut);
        freeShippingBut.click();
        functionClass.sleep(5);
        functionClass.waitUntilElementPresent(submitOrderBut);
        submitOrderBut.click();
        functionClass.sleep(2);

    }
    public boolean verifyCreateOrder() {
        functionClass.waitUntilElementPresent(successMessage);
        if (successMessage.isDisplayed())
            return true;
        else return false;
    }
}