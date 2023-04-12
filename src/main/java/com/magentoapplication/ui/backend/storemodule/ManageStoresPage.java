package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageStoresPage {

    WebDriver driver;
    FunctionClass functionClass;
    TestHelperClassStore testHelperClassStore;



    public ManageStoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }

    @FindBy(xpath = "//span[text()=\"System\"]")
    WebElement systemLink;
    @FindBy(xpath = "//span[text()=\"Manage Stores\"]")
    WebElement manageStoresLink;
    @FindBy(xpath = "//span[text()='Create Website']")
    WebElement createWebsiteButton;
    @FindBy(xpath = "//input[@id=\"website_name\"]")
    WebElement websiteNameField;
    @FindBy(xpath = "//input[@id=\"website_code\"]")
    WebElement websiteCodeField;
    @FindBy(xpath = "//input[@id=\"website_sort_order\"]")
    WebElement websiteSortOrderField;
    @FindBy(xpath = "//*[@id='id_d681d4dae92c5613d1c63525035a1644']")
    WebElement saveWebsiteButton;
    @FindBy(xpath = "//*[@title='Delete Website']")
    WebElement deleteWebsiteButton;

    @FindBy(xpath = "//span[text()='The website has been saved.']")
    WebElement createWebsiteSuccessMassage;
    @FindBy(xpath = "//span[text()='The website has been deleted.']")
    WebElement deleteWebsiteSuccessMassage;

    public void createWebsite(){
        functionClass.waitUntilElementPresent(systemLink);
        systemLink.click();
        functionClass.waitUntilElementPresent(manageStoresLink);
        manageStoresLink.click();

        functionClass.waitUntilElementPresent(websiteNameField);
        TestHelperClassStore.setWebsiteName(functionClass.generateWebsiteName());
        websiteNameField.sendKeys(TestHelperClassStore.getWebsiteName());

        functionClass.waitUntilElementPresent(websiteCodeField);
        websiteSortOrderField.sendKeys(functionClass.generateWebsiteCode());
        functionClass.waitUntilElementPresent(websiteSortOrderField);
        websiteSortOrderField.sendKeys(functionClass.generateSortOrder());

        functionClass.waitUntilElementPresent(saveWebsiteButton);
        saveWebsiteButton.click();

    }

    public boolean verifyCreateWebsite(){
        functionClass.waitUntilElementPresent(createWebsiteSuccessMassage);
        if (createWebsiteSuccessMassage.isDisplayed())
            return true;
        else return false;
    }

    public void deleteWebsite(){
        functionClass.waitUntilElementPresent(systemLink);
        systemLink.click();
        functionClass.waitUntilElementPresent(manageStoresLink);
        manageStoresLink.click();
        WebElement myWebsiteName=driver.findElement
                (By.xpath(String.format("", TestHelperClassStore.getChangedWebsiteName())));
        functionClass.sleep(2);
        myWebsiteName.click();
        functionClass.sleep(2);
        deleteWebsiteButton.click();

    }

public boolean verifyDeleteWebsite(){
        functionClass.waitUntilElementPresent(deleteWebsiteSuccessMassage);
        if (deleteWebsiteSuccessMassage.isDisplayed())
            return true;
        else return false;
}
}

