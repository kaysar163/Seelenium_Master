package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(xpath = "(//span[contains(text(),'Add Root Category')])[1]")

    WebElement Addrootcategory;

    @FindBy(id = "group_4name")

    WebElement rootName;
    @FindBy( id="group_4is_active")

    WebElement isActive;
    @FindBy(id = "group_4description")

    WebElement description;
    @FindBy(id = "group_4meta_title")

    WebElement pagaTitle;
    @FindBy(id = "group_4meta_keywords")
    WebElement metaKeywords;
    @FindBy(id = "group_4meta_description")
    WebElement metaDescription;
    @FindBy(id = "group_4include_in_menu")
    WebElement IncludeInNavigationMenu;
    @FindBy(xpath = ("//span[contains(text(),'Save Category')]"))
    WebElement SavaCategoriesButton;
    @FindBy(xpath= "//span[normalize-space()='The category has been saved.']")
    WebElement SuccessfulSavesMessage;

    @FindBy(xpath = "//*[text()='pc portable (0)']")
    WebElement subCat;
    @FindBy(xpath = "//*[@class='scalable delete']")
    WebElement deleteCatButton;
    @FindBy(xpath = "//*[text()='The category has been deleted.']")
    WebElement sucCatDeletedMessage;


    public  void fillCategoryInformationAndSave() {
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnManageCategoriesLink();
        functionClass.waitUntilElementPresent(Addrootcategory);
        Addrootcategory.click();
        functionClass.waitUntilElementPresent(rootName);
        rootName.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(isActive);
        Select select=new Select(isActive);
        select.selectByValue("1");
        functionClass.waitUntilElementPresent(description);
        description.sendKeys(functionClass.generateCountryName());
        functionClass.waitUntilElementPresent(pagaTitle);
        pagaTitle.sendKeys(functionClass.generateCityName());
        functionClass.waitUntilElementPresent(metaKeywords);
        metaKeywords.sendKeys(functionClass.generateStreetName());
        functionClass.waitUntilElementPresent(metaDescription);
        metaDescription.sendKeys(functionClass.generateZipCode());
        functionClass.waitUntilElementPresent(IncludeInNavigationMenu);
        Select select1=new Select(IncludeInNavigationMenu);
        select1.selectByValue("0");
        functionClass.waitUntilElementPresent(SavaCategoriesButton);
        SavaCategoriesButton.click();
    }
    public boolean VerifyAddCatogories(){
        functionClass.waitUntilElementPresent(SuccessfulSavesMessage);
        if (SuccessfulSavesMessage.isDisplayed()) {
            return true;
        } else return false;
    }
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

}
