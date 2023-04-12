package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//span[contains(text(),'System')]")
    WebElement systemButton;
    @FindBy(xpath = "//span[contains(text(),'Manage Stores')]")
    WebElement managerStoresButton;
    @FindBy(xpath ="(//span[(text()='Create Store')])[1]")
    WebElement creatStoreButton;
    @FindBy(id="group_website_id")
    WebElement websiteField;
    @FindBy(id="group_name")
    WebElement storeName1;
    @FindBy(id="group_root_category_id")
    WebElement rootCategoryField;
    @FindBy(xpath = "(//span[contains(text(),'Save Store')])[1]")
    WebElement saveStoreButton;
    @FindBy(xpath="//span[contains(text(),'The store has been saved.')]")
    WebElement createStoreSucMasaj;
    //Methods
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
    public void createStore(){
        storeModuleDashboardPage.clickOnManageStoresLink();
        systemButton.click();
        functionClass.waitUntilElementPresent(managerStoresButton);
        managerStoresButton.click();
        functionClass.waitUntilElementPresent(creatStoreButton);
        creatStoreButton.click();
        functionClass.waitUntilElementPresent(websiteField);
        websiteField.click();
        Select selectWebsite=new Select(websiteField);
        selectWebsite.selectByValue("314");
        functionClass.waitUntilElementPresent(storeName1);

        TestHelperClassStore.setStoreName(functionClass.generateFakeName());
        functionClass.sleep(3);
        storeName1.sendKeys(TestHelperClassStore.getStoreName());
        functionClass.waitUntilElementPresent(rootCategoryField);
        rootCategoryField.click();
        Select selectRootCategory=new Select(rootCategoryField);
        selectRootCategory.selectByValue("357");
        functionClass.waitUntilElementPresent(saveStoreButton);
        saveStoreButton.click();


    }
    public boolean verifyCreatStore(){
        if (createStoreSucMasaj.isDisplayed()){
            return true;


        }
        else return false;

    }

}
