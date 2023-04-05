package com.magentoapplication.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;

    CreateAnAccountPage createAnAccountPage;

    FunctionClass functionClass;

    String configFileName="testdatafolder/testdata.properties";

    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        createAnAccountPage=new CreateAnAccountPage(driver);
        functionClass=new FunctionClass(driver);
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

    @FindBy(xpath = "//div[@class='my-account']//input[@id='firstname']")
    WebElement verifyViewAccountWithFirstName;

    @FindBy(xpath = "//div[@class='my-account']//input[@id='lastname']")
    WebElement verifyViewAccountWithLastName;

    @FindBy(xpath = "//div[@class='my-account']//input[@id='email']")
    WebElement verifyViewAccountWithEmail;

    @FindBy(xpath = "//input[@id=\"middlename\"]")
    WebElement middleNameField;


    public boolean viewAccountInfo(){
        functionClass.waitUntilElementPresent(myAccountInformationLink);
        myAccountInformationLink.click();
        if (verifyViewAccountWithFirstName.getText().isEmpty()||verifyViewAccountWithLastName
                .getText().isEmpty()||verifyViewAccountWithEmail.getText()
                .isEmpty())
            return true;
     else return false;

    }

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

    public boolean verifyPasswordChanged(){
        if (verifyChangePassword.isDisplayed())
            return true;
        else return false;
    }


    public void EditAccountInfo() {
        functionClass.waitUntilElementPresent(myAccountInformationLink);
        myAccountInformationLink.click();
        functionClass.waitUntilElementPresent(middleNameField);
        middleNameField.clear();
        middleNameField.sendKeys(functionClass.generateMiddleName());
        functionClass.waitUntilElementPresent(currentPasswordField);
        currentPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties(configFileName, "loginPassword"));
        functionClass.waitUntilElementPresent(changePasswordSaveButton);
        changePasswordSaveButton.click();
    }


    public boolean VerifySuccessfullyEdit() {
        functionClass.waitUntilElementPresent(verifyChangePassword);
        if (verifyChangePassword.isDisplayed()) {
            return true;
        } else
            return false;

    }


}
