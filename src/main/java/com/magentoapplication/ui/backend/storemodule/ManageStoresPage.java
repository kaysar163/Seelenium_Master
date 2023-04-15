package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindAll(@FindBy(xpath = "//table[@class='data']//tbody//tr"))
    List<WebElement> manageStoresTable;



    public void viewAllStores(){
      functionClass.waitUntilElementPresent(systemLink);
        Actions actions=new Actions(driver);
        actions.moveToElement(systemLink).click(manageStoresLink).build().perform();
        functionClass.sleep(2);
    }

    public boolean verifyViewedAllStores(){
        if (manageStoresTable.size()>1)
            return true;
        else
            return false;

    }
}
