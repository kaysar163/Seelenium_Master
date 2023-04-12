package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageStoresPage {

    WebDriver driver;

    FunctionClass functionClass;
    StoreModuleDashboardPage storeModuleDashboardPage;

    public ManageStoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        storeModuleDashboardPage=new StoreModuleDashboardPage(driver);
    }
    //Elements
    @FindBy(xpath = "//*[contains(text(),'    Big Jewelry shop ')]")
    WebElement storeName;
    @FindBy(xpath = "(//button[@title='Delete Store']//span/span/span[1])[1]")
    WebElement deleteStore;
    @FindBy(css = "li.success-msg")
    WebElement deleteStoreSuccessMessage;

    @FindBy(xpath = "//span[text()=\"System\"]")
    WebElement systemLink;

    @FindBy(xpath = "//span[text()=\"Manage Stores\"]")
    WebElement manageStoresLink;

    @FindBy(xpath = "//span[text()='Create Website']")
    WebElement createWebsiteButton;

    @FindBy(xpath = "//input[@id=\"website_name\"]")
    WebElement websiteNameField;

    @FindBy(xpath = "//*[@id='website_code']")
    WebElement websiteCodeField;

    @FindBy(xpath = "//input[@id=\"website_sort_order\"]")
    WebElement websiteSortOrderField;

    @FindBy(xpath = "(//span[text()='Save Website'])[1]")
    WebElement saveWebsiteButton;

    @FindBy(xpath = "//span[text()='The website has been saved.']")
    WebElement createWebsiteSuccessMassage;

    @FindBy(xpath = "(//span[text()='Delete Website'])[1]")
    WebElement deleteWebsiteButton;

    @FindBy(xpath = "//span[text()='The website has been deleted.']")
    WebElement deleteWebsiteSuccessMassage;


    public void createWebsite(){
         functionClass.waitUntilElementPresent(systemLink);
         systemLink.click();
          functionClass.waitUntilElementPresent(manageStoresLink);
          manageStoresLink.click();
        //storeModuleDashboardPage.clickOnManageStoresLink();
        functionClass.waitUntilElementPresent(createWebsiteButton);
        createWebsiteButton.click();
        functionClass.waitUntilElementPresent(websiteNameField);
        TestHelperClassStore.setWebsiteName(functionClass.generateWebsiteName());
        websiteNameField.sendKeys(TestHelperClassStore.getWebsiteName());
        functionClass.waitUntilElementPresent(websiteCodeField);
        websiteCodeField.sendKeys(functionClass.generateWebsiteCode());
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
                (By.xpath(String.format("//tr//td//a[contains(text(),'%s')]",
                        TestHelperClassStore.getWebsiteName())));
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(myWebsiteName);
        myWebsiteName.click();
        functionClass.waitUntilElementPresent(deleteWebsiteButton);
        deleteWebsiteButton.click();

    }

    public boolean verifyDeleteWebsite(){
        functionClass.waitUntilElementPresent(deleteWebsiteSuccessMassage);
        if (deleteWebsiteSuccessMassage.isDisplayed())
            return true;
        else return false;
    }
    public void deleteStore(){
        storeModuleDashboardPage.clickOnManageStoresLink();
        storeName.click();
        functionClass.waitUntilElementPresent(deleteStore);
        deleteStore.click();
    }
    public boolean storeDeletedSuccessfully(){
        functionClass.waitUntilElementPresent(deleteStoreSuccessMessage);
        if(deleteStoreSuccessMessage.isDisplayed())
            return true;
        else return false;
    }


    public void CatologPoductDeletetest() {
    }

    public boolean verifyCatologPoducDelettest() {
        return false;
    }
}