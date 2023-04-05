package com.magentoapplication.usermodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import com.magentoapplication.utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddProductsToShoppingCart {

    WebDriver driver;
    FunctionClass functionClass;
    FrontEndDashboardPage frontEndDashboardPage;
    final static String configFile="config.properties";

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

    @FindBy(css = ".add-to-cart>button ")
    WebElement addToCartButton;



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

    public AddProductsToShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
    }
    public void addToShoppingCart() {
        functionClass.waitUntilElementPresent(madisonIlandLink);
        madisonIlandLink.click();
        functionClass.waitUntilElementPresent(searchBox);
        searchBox.click();
        searchBox.sendKeys(ApplicationConfig.readFromConfigProperties(configFile,"public_search_name"));
        functionClass.waitUntilElementPresent(clickSearchButton);
        clickSearchButton.click();
        //functionClass.waitUntilElementPresent(toriTank);
        //functionClass.sleep(5);
        //functionClass.waitUntilElementPresent(qtyNumber);
        //qtyNumber.sendKeys(ApplicationConfig.readFromConfigProperties(configFile,"number_of_product"));
        //functionClass.sleep(10);
        functionClass.waitUntilElementPresent(addToCartButton);
        //functionClass.sleep(5);
        addToCartButton.click();
    }




    public boolean verification()  {
        if (addSuccessMessage.isDisplayed()){
            return true;
        }else
            return false;

    }







}
