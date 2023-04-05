package com.magentoapplication.usermodule;


import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(css = "#p_method_cashondelivery")
    WebElement cashOnDeliveryButton;
    @FindBy(css = "button[onclick=\'payment.save()\'] span span")
    WebElement continueButton2;
    @FindBy(css = "button[title=\'Place Order\'] span span")
    WebElement placeOrderButton;
    @FindBy(css = ".sub-title")
    WebElement successMessage;

    public void CheckOutOrderPage() {
        functionClass.waitUntilElementPresent(cartButton);
        cartButton.click();
        functionClass.waitUntilElementPresent(checkOutButton);
        checkOutButton.click();
        functionClass.waitUntilElementPresent(continueButton);
        continueButton.click();
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