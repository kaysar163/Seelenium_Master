package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPriceRulePage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;

    public ShoppingCartPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);
    }
    //filter shopping cart by id and rule
    @FindBy(xpath = "//span[text()='Promotions']")
    WebElement promotionLink;
    @FindBy(xpath = "//span[text()='Shopping Cart Price Rules']")
    WebElement shoppingCartPriceRulesBut;
    @FindBy(id = "promo_quote_grid_filter_rule_id")
    WebElement ruleIdField;
    @FindBy(id = "promo_quote_grid_filter_name")
    WebElement ruleNameField;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchBut;
    @FindBy(xpath = "(//h3[contains(text(),'Shopping Cart Price Rules')])[1]")
    WebElement succseesMessage;


    public void filterShoppingCartByIdAndRule(){
        marketingDashboardPage.clickOnShoppingCartPriceRuleLink();
        functionClass.waitUntilElementPresent(promotionLink);
        promotionLink.click();
        functionClass.waitUntilElementPresent(shoppingCartPriceRulesBut);
        shoppingCartPriceRulesBut.click();
        functionClass.waitUntilElementPresent(ruleIdField);
        ruleIdField.sendKeys();
        functionClass.waitUntilElementPresent(ruleNameField);
        ruleIdField.sendKeys();
        functionClass.waitUntilElementPresent(searchBut);
        searchBut.click();
    }
    public boolean verifyFilterShoppingCart(){
        if (succseesMessage.isDisplayed())
            return true;
        else return false;
    }
}


