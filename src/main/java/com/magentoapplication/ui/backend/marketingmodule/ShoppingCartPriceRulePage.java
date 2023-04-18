package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(xpath = "(//button[@title='Save' and @type='button'])[1]")
    WebElement saveButton;
    @FindBy(xpath = "//*[text()='The rule has been saved.']")
    WebElement successMessage;



    public void filterShoppingCartByIdAndRule(){
        marketingDashboardPage.clickOnShoppingCartPriceRuleLink();
        functionClass.waitUntilElementPresent(promotionLink);
        promotionLink.click();
        functionClass.waitUntilElementPresent(shoppingCartPriceRulesBut);
        shoppingCartPriceRulesBut.click();
        functionClass.waitUntilElementPresent(ruleIdField);
        ruleIdField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","shoppingCartId"));
        functionClass.waitUntilElementPresent(ruleNameField);
        ruleNameField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","ruleName"));
        functionClass.waitUntilElementPresent(searchBut);
        searchBut.click();
    }
    public boolean verifyFilterShoppingCart(){
        if (driver.getPageSource().contains(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","shoppingCartId")))
            return true;
        else return false;
    }
    public void clickOnCartPriceRule(){
        marketingDashboardPage.clickOnShoppingCartPriceRuleLink();
    }
    public void searchExistingPriceRule(){
        functionClass.waitUntilElementPresent(ruleNameField);
        ruleNameField.sendKeys(ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","ruleName"));
        functionClass.waitUntilElementPresent(searchBut);
        searchBut.click();}
    public void selectExistingPriceRule(){
        WebElement existingPriceRule= driver.findElement(By.xpath(String.format("(//tbody/tr/td[2][contains(text(),'%s')])[1]",ApplicationConfig.readFromConfigProperties("testdatafolder/testdata.properties","ruleName"))));
        existingPriceRule.click();}
    public void updateExistingPriceRule(){
        WebElement select= driver.findElement(By.cssSelector("select#rule_is_active"));
        Select select1=new Select(select);
        select1.selectByValue("0");
        saveButton.click();
    }
    public boolean VerifyPriceRuleUpdate(){
        if(successMessage.isDisplayed())
            return true;
        else return false;
    }
}


