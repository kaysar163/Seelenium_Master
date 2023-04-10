package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.ui.backend.customersmodule.TestHelperClass;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoriesPage {

    WebDriver driver;

    FunctionClass functionClass;

    CatalogDashboardPage catalogDashboardPage;

    public ManageCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }


    // Elements
    @FindBy(xpath ="//span[text()='close (0)']//parent::a")
    WebElement rootCategory;
    @FindBy(xpath = "//span[contains(text(),'Delete Category')]")
    WebElement deleteCategoryButton;
   @FindBy(xpath = "//span[contains(text(),'The category has been deleted.')]")
   WebElement deleteCatSucMessage;
    @FindBy(xpath = "//*[text()='pc portable (0)']")
    WebElement subCat;
    @FindBy(xpath = "//*[@class='scalable delete']")
    WebElement deleteCatButton;
    @FindBy(xpath = "//*[text()='The category has been deleted.']")
    WebElement sucCatDeletedMessage;
    public void subCatDelete(){
        functionClass.waitUntilElementPresent(catalogDashboardPage.catalogLink);
        catalogDashboardPage.clickOnCatalogLink();
        catalogDashboardPage.clickOnManageCategoriesLink();
        functionClass.sleep(10);
        subCat.click();
        functionClass.waitUntilElementPresent(deleteCatButton);
        deleteCatButton.click();
        functionClass.waitForAlertPresent();
        functionClass.alertAccept();
    }
    public boolean subCatDeleteSuccessful(){
        functionClass.waitUntilElementPresent(sucCatDeletedMessage);
        if(sucCatDeletedMessage.isDisplayed())
            return true;
        else return false;
    }
    public void deleteRootCat(){
        functionClass.waitUntilElementPresent(catalogDashboardPage.catalogLink);
        catalogDashboardPage.clickOnCatalogLink();
        catalogDashboardPage.clickOnManageCategoriesLink();
        functionClass.waitUntilElementPresent(rootCategory);
        rootCategory.click();
        functionClass.waitUntilElementPresent(deleteCategoryButton);
        deleteCategoryButton.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public boolean deleteCategorySuccessful(){
        functionClass.waitUntilElementPresent(deleteCatSucMessage);
        if (deleteCatSucMessage.isDisplayed())
            return true;
        else return false;

    }
}
