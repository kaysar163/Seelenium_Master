package com.magentoapplication.ui.backend.storemodule;

import com.github.javafaker.App;
import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageStoresPage {
    
    WebDriver driver;
    
    FunctionClass functionClass;
    StoreModuleDashboardPage storeModuleDashboardPage;
    static final String config = "testdatafolder/testdata.properties";
    String website = ApplicationConfig.readFromConfigProperties(config, "websiteName");
    String wCode = ApplicationConfig.readFromConfigProperties(config, "websiteCode");
    
    public ManageStoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        storeModuleDashboardPage = new StoreModuleDashboardPage(driver);
    }
    
    //Elements
//    @FindBy(xpath = "//*[contains(text(),'    Big Jewelry shop ')]")
//    WebElement storeName;
    @FindBy(xpath = "(//button[@title='Delete Store']//span/span/span[1])[1]")
    WebElement deleteStore;
    @FindBy(css = "li.success-msg")
    WebElement deleteStoreSuccessMessage;
    
    
    @FindBy(xpath = "//span[contains(text(),'System')]")
    WebElement systemButton;
    @FindBy(xpath = "//span[contains(text(),'Manage Stores')]")
    WebElement managerStoresButton;
    @FindBy(xpath = "(//span[(text()='Create Store')])[1]")
    WebElement creatStoreButton;
    @FindBy(id = "group_website_id")
    WebElement websiteField;
    @FindBy(id = "group_name")
    WebElement storeName1;
    @FindBy(id = "group_root_category_id")
    WebElement rootCategoryField;
    @FindBy(xpath = "(//span[contains(text(),'Save Store')])[1]")
    WebElement saveStoreButton;
    @FindBy(xpath = "//span[contains(text(),'The store has been saved.')]")
    WebElement createStoreSucMasaj;
    //Methods
    
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
    
    //for edit website
    @FindBy(xpath = "(//*[contains(text(), 'System')])[2]")
    WebElement systemTag;
    @FindBy(xpath = "//*[contains(text(),'Manage Stores')]")
    WebElement manageStore;
    @FindBy(xpath = "//a[@title='Id: 273']")
    WebElement myStore;
    @FindBy(xpath = "//table[@class='form-list']//tbody//tr[1]//td[2]//input[@name='website[name]']")
    WebElement websiteName;
    @FindBy(id = "website_code")
    WebElement websiteCode;
    @FindBy(xpath = "//span[contains(text(),'The website has been saved.')]")
    WebElement websiteSavedMessage;
    
    public void createWebsite() {
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
    
    public boolean verifyCreateWebsite() {
        functionClass.waitUntilElementPresent(createWebsiteSuccessMassage);
        if (createWebsiteSuccessMassage.isDisplayed())
            return true;
        else return false;
    }
    
    //edit existing website
    public void editWebsite() {
        functionClass.waitUntilElementPresent(systemTag);
        Actions action = new Actions(driver);
        action.moveToElement(systemTag).perform();
        functionClass.waitUntilElementPresent(manageStore);
        manageStore.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        functionClass.waitUntilElementPresent(myStore);
        myStore.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        functionClass.waitUntilElementPresent(websiteName);
        websiteName.clear();
        websiteName.sendKeys(website);
        functionClass.waitUntilElementPresent(websiteCode);
        websiteCode.clear();
        websiteCode.sendKeys(wCode);
        functionClass.waitUntilElementPresent(saveWebsiteButton);
        saveWebsiteButton.click();
    }
    
    public boolean webSiteSavedMessage() {
        if (websiteSavedMessage.isDisplayed())
            return true;
        else
            return false;
    }
    
    public void deleteWebsite() {
        functionClass.waitUntilElementPresent(systemLink);
        systemLink.click();
        functionClass.waitUntilElementPresent(manageStoresLink);
        manageStoresLink.click();
        WebElement myWebsiteName = driver.findElement
          (By.xpath(String.format("//tr//td//a[contains(text(),'%s')]",
            TestHelperClassStore.getWebsiteName())));
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(myWebsiteName);
        myWebsiteName.click();
        functionClass.waitUntilElementPresent(deleteWebsiteButton);
        deleteWebsiteButton.click();
        
    }
    
    public boolean verifyDeleteWebsite() {
        functionClass.waitUntilElementPresent(deleteWebsiteSuccessMassage);
        if (deleteWebsiteSuccessMassage.isDisplayed())
            return true;
        else return false;
    }
    
    public void deleteStore() {
        storeModuleDashboardPage.clickOnManageStoresLink();
        WebElement storeName= driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]",TestHelperClassStore.getStoreName())));
        storeName.click();
        functionClass.waitUntilElementPresent(deleteStore);
        deleteStore.click();
    }
    
    public boolean storeDeletedSuccessfully() {
        functionClass.waitUntilElementPresent(deleteStoreSuccessMessage);
        if (deleteStoreSuccessMessage.isDisplayed())
            return true;
        else return false;
    }
    
    public void createStore() {
        storeModuleDashboardPage.clickOnManageStoresLink();
        systemButton.click();
        functionClass.waitUntilElementPresent(managerStoresButton);
        managerStoresButton.click();
        functionClass.waitUntilElementPresent(creatStoreButton);
        creatStoreButton.click();
        functionClass.waitUntilElementPresent(websiteField);
        websiteField.click();
        Select selectWebsite = new Select(websiteField);
        selectWebsite.selectByValue("314");
        functionClass.waitUntilElementPresent(storeName1);
        
        TestHelperClassStore.setStoreName(functionClass.generateFakeName());
        functionClass.sleep(3);
        storeName1.sendKeys(TestHelperClassStore.getStoreName());
        functionClass.waitUntilElementPresent(rootCategoryField);
        rootCategoryField.click();
        Select selectRootCategory = new Select(rootCategoryField);
        selectRootCategory.selectByValue("2");
        functionClass.waitUntilElementPresent(saveStoreButton);
        saveStoreButton.click();
        
        
    }
    
    public boolean verifyCreateStore() {
        if (createStoreSucMasaj.isDisplayed()) {
            return true;
            
            
        } else return false;
        
    }
    
    
    public void CatologPoductDeletetest() {
    }
    
    public boolean verifyCatologPoducDelettest() {
        return false;
    }
}