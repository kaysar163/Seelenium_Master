package com.magentoapplication.ui.frontend.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {
    WebDriver driver;
    FunctionClass functionClass;
    FrontEndDashboardPage frontEndDashboardPage;
    String config = "testdatafolder/testdata.properties";




    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        frontEndDashboardPage = new FrontEndDashboardPage(driver);

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

    @FindBy(id = "confirmation")

    WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='is_subscribed']")

    WebElement isSubscribed;

    @FindBy(xpath = "//span[contains(text(),'Register')]")

    WebElement registerButton;


    //@FindBy(xpath = "//span[text()='Thank you for registering with eCommerce Shopping.']")
    @FindBy(css=".success-msg>ul>li>span")
    WebElement createAnAccountSuccessfulMessage;


    public void fillAccountRegistrationForm() {
        frontEndDashboardPage.clickOnAccountLink();
        frontEndDashboardPage.clickOnRegisterLink();
        functionClass.waitUntilElementPresent(firstName);
        firstName.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(middleName);
        middleName.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(lastName);
        lastName.sendKeys(functionClass.generateFakeLastName());
        functionClass.waitUntilElementPresent(emailAddress);
        TestHelperFrontEnd.setEmail(functionClass.generateFakeEmail());
        emailAddress.sendKeys(TestHelperFrontEnd.getEmail());
        functionClass.waitUntilElementPresent(password);
        password.sendKeys(ApplicationConfig.readFromConfigProperties(config, "password"));
        functionClass.waitUntilElementPresent(confirmPassword);
        confirmPassword.sendKeys(ApplicationConfig.readFromConfigProperties(config, "confirmPassword"));
        functionClass.waitUntilElementPresent(isSubscribed);
        isSubscribed.click();
        functionClass.waitUntilElementPresent(registerButton);
        registerButton.click();
    }

    public boolean verifyCreateAnAccountSuccessful() {
        functionClass.waitUntilElementPresent(createAnAccountSuccessfulMessage);
        if (createAnAccountSuccessfulMessage.isDisplayed()) {
            return true;
        } else return false;
    }

}