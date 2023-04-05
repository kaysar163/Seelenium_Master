package com.magentoapplication.ui.frontend.usermodule;


import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutOrderPage {
    WebDriver driver;

    FunctionClass functionClass;
    FrontEndDashboardPage dashboardPage;

    public CheckOutOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dashboardPage = new FrontEndDashboardPage(driver);
        functionClass = new FunctionClass(driver);
    }

    @FindBy(xpath = "//span[normalize-space()=\'Cart\']")
    WebElement cartButton;
    @FindBy(css = ".button.checkout-button")
    WebElement checkOutButton;
    @FindBy(css = "button[title=\'Continue\']")
    WebElement continueButton;
    @FindBy(xpath = "//label[@for='s_method_freeshipping_freeshipping']")
    WebElement freeShppingButton;
    @FindBy(xpath = "//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]")
    WebElement verifyShippingButton;
    @FindBy(css = "#p_method_cashondelivery")
    WebElement cashOnDeliveryButton;
    @FindBy(css = "button[onclick=\'payment.save()\'] span span")
    WebElement continueButton2;
    @FindBy(css = "button[title=\'Place Order\'] span span")
    WebElement placeOrderButton;
    @FindBy(css = ".sub-title")
    WebElement successMessage;

    @FindBy(id = "billing:street1")
    WebElement addressField;

    @FindBy(id = "billing:city")
    WebElement cityField;

    @FindBy(id = "billing:region_id")
    WebElement stateDropdown;

    @FindBy(id = "billing:postcode")
    WebElement zipcodeField;

    @FindBy(id = "billing:country_id")
    WebElement countryDropdown;

    @FindBy(id = "billing:telephone")
    WebElement telephoneField;

    public void CheckOutOrderTest() {
        functionClass.waitUntilElementPresent(cartButton);
        cartButton.click();
        functionClass.waitUntilElementPresent(checkOutButton);
        checkOutButton.click();
        functionClass.waitUntilElementPresent(addressField);
        addressField.sendKeys(functionClass.generateStreetName());
        cityField.sendKeys(functionClass.generateCityName());
        Select select=new Select(stateDropdown);
        select.selectByValue("1");
        zipcodeField.sendKeys(functionClass.generateZipCode());
        Select select1=new Select(countryDropdown);
        select1.selectByValue("AX");
        telephoneField.sendKeys(functionClass.generateTelephoneNumber());
        functionClass.waitUntilElementPresent(continueButton);
        continueButton.click();
        functionClass.sleep(10);
        functionClass.waitUntilElementPresent(freeShppingButton);
        freeShppingButton.click();
        functionClass.waitUntilElementPresent(verifyShippingButton);
        verifyShippingButton.click();
        functionClass.waitUntilElementPresent(cashOnDeliveryButton);
        cashOnDeliveryButton.click();
        functionClass.waitUntilElementPresent(continueButton2);
        continueButton2.click();
        functionClass.waitUntilElementPresent(placeOrderButton);
        placeOrderButton.click();

    }
    public boolean verifyCheckOutOrder(){
        functionClass.waitUntilElementPresent(successMessage);
        if (successMessage.isDisplayed())
            return true;
        else return false;
    }
}