package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.ui.backend.marketingmodule.TestHelperMarketing;
import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "//a[normalize-space()='Get shipping methods and rates']")
    WebElement shippingMethodBut;
    @FindBy(xpath = "//input[@id='s_method_freeshipping_freeshipping']")
    WebElement freeShippingBut;
    @FindBy(xpath = "(//span[text()='Submit Order'])[2]")
    WebElement submitOrderBut;
    @FindBy(xpath = "//span[text()='The order has been created.']")
    WebElement successMessage;

    @FindBy(xpath = "//a[normalize-space()='View']")

    WebElement viewButton;
    @FindBy(xpath="(//a[contains(text(),'Edit')])[1]")
    WebElement EditButton;
    @FindBy(id = "prefix")
    WebElement PrefixField;
    @FindBy(xpath = "(//button[@class='scalable save'])[1]")
    WebElement SaveOrderAdressButton;
    @FindBy(xpath = "//span[contains(text(),'The order address has been updated.')]")
    WebElement SuccessfulMessage;


    public void createNewOrder() {
        salesDashboardPage.clickOnOrdersLink();
        functionClass.waitUntilElementPresent(CreateNewOrderLink);
        CreateNewOrderLink.click();
        functionClass.waitUntilElementPresent(CreateNewCustomerLink);
        CreateNewCustomerLink.click();
        functionClass.waitUntilElementPresent(storeName);
        storeName.click();
        functionClass.waitUntilElementPresent(AddProductsLink);
        AddProductsLink.click();
        functionClass.waitUntilElementPresent(selectBox);
        selectBox.click();
        functionClass.waitUntilElementPresent(addSelectedPrdcLink);
        addSelectedPrdcLink.click();
        TestHelperSales.setFirstNameField(functionClass.generateFakeName());
        firstNameField.sendKeys(TestHelperSales.getFirstNameField());
        functionClass.waitUntilElementPresent(lastNameField);
        lastNameField.sendKeys(functionClass.generateFakeLastName());
        functionClass.waitUntilElementPresent(streetAddressField);
        streetAddressField.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(cityField);
        cityField.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(countryField);
        countryField.sendKeys(functionClass.generateCountryName());
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
    public void UpdateOrderStorePicup() {
        salesDashboardPage.clickOnOrdersLink();
        functionClass.sleep(2);
        WebElement viewButton=driver.findElement
                (By.xpath(String.format("(//td[contains(@class,'')][contains(text(),'Lawanna')])//following-sibling::td[5]",
                        TestHelperSales.getFirstNameField())));

        //Actions actions=new Actions(driver);
       // actions.click(viewButton).build().perform();
        viewButton.click();
        functionClass.waitUntilElementPresent(EditButton);
        EditButton.click();
        functionClass.waitUntilElementPresent(PrefixField);
        PrefixField.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(SaveOrderAdressButton);
        SaveOrderAdressButton.click();

    }

    public boolean verifySuccessfulMessage() {
        functionClass.waitUntilElementPresent(SuccessfulMessage);
        if (SuccessfulMessage.isDisplayed()) {
            return true;
        } else return false;
    }
}
