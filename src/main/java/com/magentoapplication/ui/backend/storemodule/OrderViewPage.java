package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderViewPage {

    WebDriver driver;

    FunctionClass functionClass;

    StoreModuleDashboardPage storeModuleDashboardPage;

    public OrderViewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        storeModuleDashboardPage=new StoreModuleDashboardPage(driver);
    }

    //Elements for add store view
    @FindBy(xpath = "(//button[@title='Create Store View'])[1]")
    WebElement createStoreViewButton;

    @FindBy(id = "store_group_id")
    WebElement storeDropdown;

    @FindBy(id = "store_name")
    WebElement storeNameField;

    @FindBy(id = "store_code")
    WebElement storeCodeField;

    @FindBy(id = "store_is_active")
    WebElement statusDropdown;

    @FindBy(id = "store_sort_order")
    WebElement sortOrderField;

    @FindBy(xpath = "(//button[@title='Save Store View'])[1]")
    WebElement saveStoreViewButton;

    @FindBy(xpath = "//span[text()='The store view has been saved']")
    WebElement storeViewHasBeenSavedMessage;



    public void addStoreView(){
        storeModuleDashboardPage.clickOnManageStoresLink();
        functionClass.waitUntilElementPresent(createStoreViewButton);
        createStoreViewButton.click();
        functionClass.waitUntilElementPresent(storeDropdown);
        Select select=new Select(storeDropdown);
        select.selectByValue("559");
        functionClass.waitUntilElementPresent(storeNameField);
        TestHelperStore.setStoreViewName(functionClass.generateFakeName());
        storeNameField.sendKeys(TestHelperStore.getStoreViewName());
        functionClass.waitUntilElementPresent(storeCodeField);
        storeCodeField.sendKeys(functionClass.generateViewCode());
        functionClass.waitUntilElementPresent(statusDropdown);
        Select select1=new Select(statusDropdown);
        select1.selectByValue("1");
        functionClass.waitUntilElementPresent(sortOrderField);
        sortOrderField.sendKeys(functionClass.generateSortOrder());
        functionClass.waitUntilElementPresent(saveStoreViewButton);
        saveStoreViewButton.click();
    }

    public boolean verifyNewStoreViewAdded(){
        functionClass.waitUntilElementPresent(storeViewHasBeenSavedMessage);
        if (storeViewHasBeenSavedMessage.isDisplayed())
            return true;
        else return false;
    }

    public void editStoreView(){
        WebElement editStoreView=driver.findElement(By.xpath(
                String.format("//a[contains(text(),' %s')]", TestHelperStore.getStoreViewName())));
        functionClass.waitUntilElementPresent(editStoreView);
        editStoreView.click();
        functionClass.waitUntilElementPresent(storeNameField);
        storeNameField.clear();
        storeNameField.sendKeys(functionClass.generateWebsiteName());
        functionClass.waitUntilElementPresent(saveStoreViewButton);
        saveStoreViewButton.click();
    }

    public boolean verifyStoreViewEdited(){
        functionClass.waitUntilElementPresent(storeViewHasBeenSavedMessage);
        if (storeViewHasBeenSavedMessage.isDisplayed())
            return true;
        else return false;
    }


}
