package com.magentoapplication.ui.frontend.usermodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndDashboardPage {

    WebDriver driver;

    FunctionClass functionClass;

    public FrontEndDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);

    }

    @FindBy(css = ".skip-link.skip-account")
    WebElement accountLink;

    @FindBy(css = "[title='Log In']")
    WebElement loginLink;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//a[@title='My Wishlist']//parent::li//parent::ul//a[@title='My Account']")
    WebElement myAccountLink;

    public void clickOnMyAccountLink() {
        functionClass.waitUntilElementPresent(myAccountLink);
        myAccountLink.click();
    }

    public void clickOnAccountLink() {
        functionClass.waitUntilElementPresent(accountLink);
        accountLink.click();
    }
    public void clickOnRegisterLink() {
        functionClass.waitUntilElementPresent(registerLink);
        registerLink.click();
}
    public void clickOnLoginLink(){
        functionClass.waitUntilElementPresent(loginLink);
        loginLink.click();
    }
}
