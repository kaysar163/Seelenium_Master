package com.magentoapplication.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;
    FrontEndLoginPage frontEndLoginPage;
    CreateAnAccountPage createAnAccountPage;
    FunctionClass functionClass;
    String configFileName="testdatafolder/testdata.properties";

    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        createAnAccountPage=new CreateAnAccountPage(driver);
        functionClass=new FunctionClass(driver);
        frontEndLoginPage=new FrontEndLoginPage(driver);
    }

    @FindBy(xpath = "//a[text()='Account Information']")
    WebElement myAccountInformationLink;

    @FindBy(css = "#current_password")
    WebElement currentPasswordField;

    @FindBy(css = "#change_password")
    WebElement changePasswordCheckbox;

    @FindBy(css = "#password")
    WebElement newPasswordField;

    @FindBy(css = "#confirmation")
    WebElement confirmNewPasswordField;

    @FindBy(css = "[title='Save']")
    WebElement changePasswordSaveButton;

    @FindBy(xpath = "//span[text()='The account information has been saved.']")
    WebElement verifyChangePassword;

    @FindBy(xpath ="//a[text()='My Tags']")
     WebElement myTagsLink;

    @FindBy(xpath ="//h1[text()='My Tags']")
    WebElement verifyMyTags;

    public void changePassword(){
        functionClass.waitUntilElementPresent(myAccountInformationLink);
        myAccountInformationLink.click();
        currentPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties(configFileName,"password"));
        functionClass.waitUntilElementPresent(changePasswordCheckbox);
        changePasswordCheckbox.click();
        newPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties(configFileName,"newPassword"));
        confirmNewPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties(configFileName,"confirmNewPassword"));
        changePasswordSaveButton.click();
    }
    public void myTagsLink(){
        functionClass.waitUntilElementPresent(myTagsLink);
        myTagsLink.click();
    }
    public boolean verifyMyTags(){
        if (verifyMyTags.isDisplayed())
            return true;
        else return false;
    }

    public boolean verifyPasswordChanged(){
        if (verifyChangePassword.isDisplayed())
            return true;
        else return false;
    }



}
