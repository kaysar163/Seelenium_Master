package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "//span[text()='The store view has been saved']")
    WebElement storeViewHasBeenSavedMessage;






}
