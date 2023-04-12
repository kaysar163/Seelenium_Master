package com.magentoapplication.ui.backend.storemodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreModuleDashboardPage {

    WebDriver driver;

    FunctionClass functionClass;

    Actions actions;
    private WebElement CatologPoductDeleteLink;

    public StoreModuleDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements( driver, this );
        functionClass = new FunctionClass( driver );
        actions = new Actions( driver );
    }

    //Elements
    @FindBy(xpath = "//span[text()='Sales']//parent::a")
    WebElement salesLink;

    @FindBy(xpath = "//span[text()='Orders']//parent::a")
    WebElement orderLink;

    @FindBy(xpath = "//span[text()='System']//parent::a")
    WebElement systemLink;

    @FindBy(xpath = "//span[text()='Manage Stores']//parent::a")
    WebElement manageStoresLink;
    @FindBy(css = "ul#nav>li:nth-child(2)")
    WebElement catalogLink;
    @FindBy(xpath = "(//*[text()='Manage Products'])[1]")
    WebElement manageProductsLink;

    //Methods
    public void clickOnOrderLink() {
        functionClass.waitUntilElementPresent( salesLink );
        actions.moveToElement( salesLink ).click( orderLink ).build( ).perform( );
    }

    public void clickOnManageStoresLink() {
        functionClass.waitUntilElementPresent( systemLink );
        actions.moveToElement( systemLink ).click( manageStoresLink ).build( ).perform( );
    }
    public void clickOnManageProductsLink(){
        functionClass.waitUntilElementPresent(catalogLink);
        actions.moveToElement(catalogLink).moveToElement(manageProductsLink).click().build().perform();
    }

    public void clickOnManageDeleteProductLink() {
        functionClass.waitUntilElementPresent( CatologPoductDeleteLink );
        actions.moveToElement( CatologPoductDeleteLink ).moveToElement( CatologPoductDeleteLink ).click( ).build( ).perform( );

    }
}





