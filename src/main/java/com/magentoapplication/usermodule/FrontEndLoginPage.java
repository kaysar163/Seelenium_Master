package com.magentoapplication.usermodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndLoginPage {
    WebDriver driver;

    FrontEndDashboardPage dashboardPage;

    FunctionClass functionClass;

    public FrontEndLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        dashboardPage=new FrontEndDashboardPage(driver);
        functionClass=new FunctionClass(driver);
    }

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#pass")
    WebElement passwordField;

    @FindBy(css = "#send2")
    WebElement loginButton;

    public void login(){
        dashboardPage.clickOnAccountLink();
        dashboardPage.clickOnLoginLink();
        functionClass.waitUntilElementPresent(emailField);
        emailField.sendKeys();
        functionClass.waitUntilElementPresent(passwordField);
        passwordField.sendKeys();
        functionClass.waitUntilElementPresent(loginButton);
        loginButton.click();
    }
}
