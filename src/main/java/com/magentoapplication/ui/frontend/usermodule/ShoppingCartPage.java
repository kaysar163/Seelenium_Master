package com.magentoapplication.ui.frontend.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {

    WebDriver driver;
    FunctionClass functionClass;
    FrontEndDashboardPage frontEndDashboardPage;
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

    @FindBy(css = ".skip-link.skip-cart")
    WebElement shoppingCart;
    @FindBy(css=".btn-edit")
    WebElement editItem;
    @FindBy(xpath = "//span[contains(text(),'Update Cart')]")
    WebElement updateCartButton;

     @FindBy(css = ".page-header>div>a>img.large")
     WebElement madisonIlandLink;


    @FindBy(xpath = "//*[text()=\"Tori Tank\"]")
    WebElement toriTank;

    @FindBy(xpath = "//*[@id=\"attribute92\"]")
    WebElement colorOption;

    @FindBy(xpath = "//*[@id=\"attribute180\"]")
    WebElement sizeOption;

    @FindBy(xpath = "//*[@class=\" product-custom-option\"]")
    WebElement testCustomOption;

    @FindBy(xpath = "//*[@id=\"qty\"]")
    WebElement qtyNumber;

    @FindBy(xpath = "//li//div//button[@title='Add to Cart' and @class='button btn-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//form//div//button[@title='Add to Cart' and @class='button btn-cart']")
    WebElement addToCartButton1;

    @FindBy(css = ".cart.display-single-price >ul>li>ul>li>span")
    WebElement verifyAddToCard;

    @FindBy(css = ".success-msg>ul li span")
    //.messages>li>ul>li>span
    WebElement successMessage;

    @FindBy(xpath = "//span[text()=\"Update Cart\"]")
    WebElement UpdateCARTLink;

    @FindBy(css="img[alt=\"Madison Island\"]")
    WebElement homePage;

    @FindBy(id = "search")
    WebElement searchBox;
    @FindBy(css = "button[title='Search']")
    WebElement clickSearchButton;


    @FindAll(
            @FindBy(xpath ="//ul[@class='products-grid products-grid--max-3-col first last odd']//li[@class='item last']" )

    )
    List<WebElement> dropdownOptions;


    @FindBy(css = "li.success-msg")
    WebElement addSuccessMessage;

    @FindBy(css = "[title='View Details']")
    WebElement viewDetailsButton;

    @FindBy(css = "#attribute92")
    WebElement chooseColor;

    @FindBy(css = "#attribute180")
    WebElement chooseSize;
    

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
    }
    
    public void addToShoppingCart() {
        functionClass.waitUntilElementPresent(madisonIlandLink);
        madisonIlandLink.click();
        functionClass.waitUntilElementPresent(searchBox);
        searchBox.click();
        searchBox.sendKeys(ApplicationConfig.readFromConfigProperties(configFile,"product_name"));
        functionClass.waitUntilElementPresent(clickSearchButton);
        clickSearchButton.click();
        addToCartButton.click();
    }
    public boolean verification()  {
        if (addSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;
    }

    public void updateShoppingCart() {
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
