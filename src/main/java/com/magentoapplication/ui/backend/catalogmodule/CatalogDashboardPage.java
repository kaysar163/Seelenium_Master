package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogDashboardPage {

    WebDriver driver;

    FunctionClass functionClass;

    Actions actions=new Actions(driver);

    public CatalogDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }

    //Catalog Module CatalogDashboardPage Links

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;

    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manageProductsLink;

    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;

    @FindBy(xpath = "//span[text()='Attributes']")
    WebElement attributesLink;

    @FindBy(xpath = "//span[text()='Manage Attributes']")
    WebElement manageAttributesLink;

    @FindBy(xpath = "//span[text()='Search Terms']")
    WebElement searchTerms;

    public void clickOnCatalogLink(){
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
    }

    public void clickOnManageProductsLink(){
        functionClass.waitUntilElementPresent(manageProductsLink);
        manageProductsLink.click();
    }

    public void clickOnManageCategoriesLink(){
        functionClass.waitUntilElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
    }

    public void clickOnManageAttributesLink(){
        functionClass.waitUntilElementPresent(attributesLink);
        actions.moveToElement(attributesLink).build().perform();
        functionClass.waitUntilElementPresent(manageAttributesLink);
        manageAttributesLink.click();
    }

    public void clickOnSearchTerms(){
        functionClass.waitUntilElementPresent(searchTerms);
        searchTerms.click();
    }


}
