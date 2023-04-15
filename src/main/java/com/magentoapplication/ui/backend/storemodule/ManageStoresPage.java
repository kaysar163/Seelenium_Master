package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageStoresPage {

    WebDriver driver;

    FunctionClass functionClass;

    public ManageStoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }




    @FindBy(xpath = "//span[text()='System']//parent::a")
    WebElement systemLink;

    @FindBy(xpath = "//span[text()='Manage Stores']//parent::a")
    WebElement manageStoresLink;

    @FindBy()

}
