package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
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
    @FindBy(xpath = "//*[contains(text(),'hhh')]")
    WebElement storeName;
    @FindBy(xpath = "(//button[@title='Delete Store']//span/span/span[1])[1]")
    WebElement deleteStore;

    //Methods
    public void deleteStore(){
        storeModuleDashboardPage.clickOnManageStoresLink();
        storeName.click();
        functionClass.waitUntilElementPresent(deleteStore);
        deleteStore.click();
        functionClass.alertAccept();


    }
}
