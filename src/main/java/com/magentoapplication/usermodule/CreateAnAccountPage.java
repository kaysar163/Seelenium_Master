package com.magentoapplication.usermodule;

import com.magentoapplication.utility.FunctionClass;
import com.magentoapplication.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage  {
    WebDriver driver;
     FunctionClass functionClass;
     FrontEndDashboardPage frontEndDashboardPage;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass=new FunctionClass(driver);
      frontEndDashboardPage=new FrontEndDashboardPage(driver);

    }


    @FindBy(id = "firstname")

    WebElement firstName;

    @FindBy(id = "middlename")

    WebElement middleName;

    @FindBy(id = "lastname")

    WebElement lastName;

    @FindBy(id = "email_address")

    WebElement emailAddress;

    @FindBy(id = "password")

    WebElement password;

    @FindBy(id ="confirmation")

    WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='is_subscribed']")

    WebElement isSubscribed;

    @FindBy(xpath = "//span[contains(text(),'Register')]")

    WebElement registerButton;

    @FindBy(xpath ="//span[normalize-space()='Thank you for registering with eCommerce Shopping.']")

    WebElement createAnAccountSuccessfulMessage;



    public void fillAccountRegistrationForm(){
        frontEndDashboardPage.clickOnAccountLink();
        frontEndDashboardPage.clickOnRegisterLink();
        functionClass.waitUntilElementPresent(firstName);
        firstName.sendKeys("QAtester1");
        functionClass.waitUntilElementPresent( middleName);
        middleName.sendKeys("QAtester2");
        functionClass.waitUntilElementPresent(lastName);
        lastName.sendKeys("QAtester3");
        functionClass.waitUntilElementPresent(emailAddress);
        emailAddress.sendKeys("QAtester@hotmail.com");
        functionClass.waitUntilElementPresent(password);
        password.sendKeys("123456tensta");
        functionClass.waitUntilElementPresent( confirmPassword);
        confirmPassword.sendKeys("123456tensta");
        functionClass.waitUntilElementPresent(isSubscribed);
        isSubscribed.click();
        functionClass.waitUntilElementPresent(registerButton);
        registerButton.click();
}
    public  boolean verifyCreateAnAccountSuccessful(){
        createAnAccountSuccessfulMessage.isDisplayed();
        return createAnAccountSuccessfulMessage.isDisplayed();
}
}