package com.magentoapplication.ui.backend.backendlogin;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackEndLogin  {

    WebDriver driver;

    FunctionClass functionClass;

    final static String config="config.properties";

    public BackEndLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "login")
    WebElement passwordField;

    @FindBy(id = ".form-button")
    WebElement loginButton;

    public void customersModuleLogin(){
        functionClass.waitUntilElementPresent(userNameField);
        userNameField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"customersUserName"));
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"backEndPassword"));
        functionClass.waitUntilElementPresent(loginButton);
        loginButton.click();
    }

    public void catalogModuleLogin(){
        functionClass.waitUntilElementPresent(userNameField);
        userNameField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"catalogUserName"));
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"backEndPassword"));
        functionClass.waitUntilElementPresent(loginButton);
        loginButton.click();
    }

    public void storeModuleLogin(){
        functionClass.waitUntilElementPresent(userNameField);
        userNameField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"storeUserName"));
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"backEndPassword"));
        functionClass.waitUntilElementPresent(loginButton);
        loginButton.click();
    }

    public void marketingModuleLogin(){
        functionClass.waitUntilElementPresent(userNameField);
        userNameField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"marketingUserName"));
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"backEndPassword"));
        functionClass.waitUntilElementPresent(loginButton);
        loginButton.click();
    }

    public void salesModuleLogin(){
        functionClass.waitUntilElementPresent(userNameField);
        userNameField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"salesUserName"));
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"backEndPassword"));
        functionClass.waitUntilElementPresent(loginButton);
        loginButton.click();
    }

    public void reportingModuleLogin(){
        functionClass.waitUntilElementPresent(userNameField);
        userNameField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"reportingUserName"));
        passwordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"backEndPassword"));
        functionClass.waitUntilElementPresent(loginButton);
        loginButton.click();
    }



}

