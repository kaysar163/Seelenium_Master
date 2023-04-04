package com.magentoapplication.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountInformation {


    @FindBy(xpath = "//a[text()=\"Account Information\"]")
    WebElement accountInformationLink;
    @FindBy(xpath = "//input[@id=\"middlename\"]")
    WebElement middleNameField;
    @FindBy(css = "#current_password")
    WebElement currentPasswordField;
    @FindBy(xpath="//button[@title=\"Save\"]")
    WebElement saveButton;
    @FindBy(xpath = "//span[text()=\"The account information has been saved.\"]")
    WebElement successfullyEditMessage;

    WebDriver driver;
    FunctionClass functionClass;
    FrontEndDashboardPage frontEndDashboardPage;
    String config = "testdatafolder/config.properties";

    public EditAccountInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        frontEndDashboardPage = new FrontEndDashboardPage(driver);

    }

public void EditAccountInformation(){
        accountInformationLink.click();
        functionClass.waitUntilElementPresent(middleNameField);
        middleNameField.clear();
        middleNameField.sendKeys(functionClass.generateMiddleName());
        functionClass.waitUntilElementPresent(currentPasswordField);
        currentPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties(config,"password"));

}

public void ClickOnSaveButton(){
        functionClass.waitUntilElementPresent(saveButton);
        saveButton.click();
}

public boolean VerifySuccessfullyEdit(){
        functionClass.waitUntilElementPresent(successfullyEditMessage);
        if (successfullyEditMessage.isDisplayed()){
            return true;
        }else
            return false;

}


}
