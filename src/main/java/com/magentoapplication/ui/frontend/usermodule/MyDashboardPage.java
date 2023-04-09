package com.magentoapplication.ui.frontend.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath ="//div[@class=\"block-content\"]//li//a//strong")
    WebElement myTagsLink;
    @FindBy(xpath ="//div[@class=\"my-account\"]//div//h1")
    WebElement verifyMyTags;

    @FindBy(xpath = "//a[text()='My Orders']")
    WebElement myorderslink;

    @FindAll(
            @FindBy(xpath = "//div[@class='my-account']//tr")
    )
    List<WebElement> myOrders;

    @FindBy(xpath = "//*[text()='My Product Reviews']")
    WebElement myproductReviews;

    @FindBy(xpath = "//h1[text()='My Product Reviews']")
    WebElement verifyMyProductReviews;
    @FindBy(css = "li>a[href=\"http://magentoqa2.unitedcoder.com/newsletter/manage/\"]")
    WebElement newsletterLink;

    //update view address elements
        @FindBy(xpath = "//a[text()=\"Address Book\"]")
        WebElement mayadressbooklink;
        @FindBy(xpath = "//a[text()='Change Billing Address']")
        WebElement changeAddressLink;

        @FindBy(name="firstname")
        WebElement firstNameField;

        @FindBy(name  = "lastname")
        WebElement lastNameField;

        @FindBy(name  = "city")
        WebElement cityField;

        @FindBy(name = "postcode")
        WebElement zipField;

        @FindBy(css = ".buttons-set > button")
        WebElement saveAddressButton;

        @FindBy(css = ".success-msg span")
        WebElement successMsg;


        public void updateAddressBook(){
            //functionClass.sleep(3);
            functionClass.waitUntilElementPresent(mayadressbooklink);
            mayadressbooklink.click();
            functionClass.waitUntilElementPresent(changeAddressLink);
            changeAddressLink.click();
            functionClass.waitUntilElementPresent(firstNameField);
            firstNameField.clear();
            firstNameField.sendKeys(functionClass.generateFakeName());
            functionClass.waitUntilElementPresent(lastNameField);
            lastNameField.clear();
            lastNameField.sendKeys(functionClass.generateFakeLastName());
            functionClass.waitUntilElementPresent(cityField);
            cityField.clear();
            cityField.sendKeys(functionClass.generateCityName());
            functionClass.waitUntilElementPresent(zipField);
            zipField.clear();
            zipField.sendKeys(functionClass.generateZipCode());
            functionClass.waitUntilElementPresent(saveAddressButton);
            saveAddressButton.click();
        }

        public boolean verifyUpdatedAddress() {
            if(successMsg.getText().equalsIgnoreCase("The address has been saved."))
                return true;
            else
                return false;
        }


    public void clickNewsletterSubscriptionLink() {
        functionClass.waitUntilElementPresent(newsletterLink);
        newsletterLink.click();
    }


    public boolean myProductReviews() {
        functionClass.waitUntilElementPresent(myproductReviews);
        myproductReviews.click();
        return verifyMyProductReviews.isDisplayed();
    }

    public boolean vieworders(){
        functionClass.waitUntilElementPresent(myorderslink);
        myorderslink.click();
        return myOrders.size()>=1;

    }
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
    public void viewMyTagsLink(){
       functionClass.waitUntilElementPresent(myTagsLink);
       myTagsLink.click();
    }
    public boolean verifyViewMyTags(){
        if (verifyMyTags.isDisplayed())
            return true;
        else return false;
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
        currentPasswordField.sendKeys(ApplicationConfig.readFromConfigProperties(configFileName, "newPassword"));
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
