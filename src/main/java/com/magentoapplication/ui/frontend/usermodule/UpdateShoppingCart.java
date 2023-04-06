package com.magentoapplication.ui.frontend.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateShoppingCart {
    WebDriver driver;
    FrontEndDashboardPage frontEndDashboardPage;
    FrontEndLoginPage frontEndLoginPage;
    FunctionClass functionClass;
    AddProductsToShoppingCart addProductsToShoppingCart;
    final static String configFile="testdatafolder/testdata.properties";
    
    @FindBy(xpath = "//img[@class='large']")
    WebElement  bigLogo;
    @FindBy(linkText = "pomme")
    WebElement apple;
    @FindBy(id = "qty")
    WebElement quantity;
    @FindBy(id = "product-addtocart-button")
    WebElement addToCart;
    @FindBy(xpath = "//*[contains(text(),'was updated in your shopping cart.')]")
    WebElement updateMessage;
    
//    @FindBy(xpath = "//input[@title='Qty']")
//    WebElement updateQty;
//    @FindBy(css = ".button.btn-update")
//    WebElement updateButton;
    
    @FindBy(css = ".skip-link.skip-cart")
    WebElement shoppingCart;
    @FindBy(css=".btn-edit")
    WebElement editItem;
    @FindBy(xpath = "//span[contains(text(),'Update Cart')]")
    WebElement updateCartButton;
    
    public UpdateShoppingCart(WebDriver driver) {
        this.driver = driver;
        frontEndLoginPage = new FrontEndLoginPage(driver);
        frontEndDashboardPage = new FrontEndDashboardPage(driver);
        functionClass = new FunctionClass(driver);
        PageFactory.initElements(driver, this);
        addProductsToShoppingCart = new AddProductsToShoppingCart(driver);
    }
    
    public void login(){
        frontEndLoginPage.login();
    }
//    public void addProduct(){
//        functionClass.waitUntilElementPresent(bigLogo);
//        bigLogo.click();
//         functionClass.waitUntilElementPresent(apple);
//         apple.click();
//         functionClass.waitUntilElementPresent(quantity);
//         quantity.sendKeys(ApplicationConfig.readFromConfigProperties(configFile,"number_of_product"));
//         functionClass.waitUntilElementPresent(addToCart);
//         addToCart.click();
//    }
    
    public void updateShoppingCart() {
//        functionClass.waitUntilElementPresent(updateQty);
//        updateQty.sendKeys(ApplicationConfig.readFromConfigProperties(configFile,"update_of_product"));
//        functionClass.waitUntilElementPresent(updateButton);
//        updateButton.click();
          functionClass.waitUntilElementPresent(shoppingCart);
          shoppingCart.click();
          functionClass.waitUntilElementPresent(editItem);
          editItem.click();
          functionClass.waitUntilElementPresent(quantity);
          quantity.clear();
          quantity.sendKeys("3");
          functionClass.waitUntilElementPresent(updateCartButton);
          updateCartButton.click();
    }
    
    public boolean updateVerificationMessage() {
        if (updateMessage.isDisplayed()) {
            System.out.println("Shopping cart updated.");
            return true;
        } else
            return false;
    }
}

