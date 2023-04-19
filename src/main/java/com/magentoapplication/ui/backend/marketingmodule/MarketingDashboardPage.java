package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingDashboardPage {

    WebDriver driver;

    FunctionClass functionClass;

    Actions actions;


    public MarketingDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }

    @FindBy(xpath = "//span[text()='Promotions']")
    WebElement promotionsLink;

    @FindBy(xpath = "//span[text()='Catalog Price Rules']")
    WebElement catalogPriceRuleLink;

    @FindBy(xpath = "//span[text()='Shopping Cart Price Rules']")
    WebElement shoppingCartPriceLink;

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;

    @FindBy(xpath = "//span[text()='Reviews and Ratings']")
    WebElement reviewsAndRatingLink;

    @FindBy(xpath = "//span[text()='Customer Reviews']")
    WebElement customerReviewsLink;

    @FindBy(xpath = "//span[text()='All Reviews']")
    WebElement allReviewsLink;

    @FindBy(xpath = "//span[text()='Pending Reviews']")
    WebElement pendingReviewsLink;

    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement newsletterLink;

    @FindBy(xpath = "//span[text()='Newsletter Templates']")
    WebElement newsletterTemplateLink;

    @FindBy(xpath = "//span[text()='Newsletter Subscribers']")
    WebElement newsletterSubscriptionLink;

    public void clickOnCatalogPriceRuleLink(){
        functionClass.waitUntilElementPresent(promotionsLink);
        actions.moveToElement(promotionsLink).click(catalogPriceRuleLink).build().perform();
    }

    public void clickOnShoppingCartPriceRuleLink(){
        functionClass.waitUntilElementPresent(promotionsLink);
        actions.moveToElement(promotionsLink).click(shoppingCartPriceLink).build().perform();
    }

    public void clickOnAllReviewsLink(){
        functionClass.waitUntilElementPresent(catalogLink);
        actions.moveToElement(catalogLink).click(reviewsAndRatingLink).moveToElement(customerReviewsLink).click(allReviewsLink).build().perform();
    }

    public void clickOnPendingReviewsLink(){
        functionClass.waitUntilElementPresent(catalogLink);
        actions.moveToElement(catalogLink).click(reviewsAndRatingLink).moveToElement(customerReviewsLink).click(pendingReviewsLink).build().perform();
    }

    public void clickOnNewsletterTemplateLink(){
        functionClass.waitUntilElementPresent(newsletterLink);
        newsletterLink.click();
        functionClass.waitUntilElementPresent(newsletterTemplateLink);
        newsletterTemplateLink.click();
    }

    public void clickOnSubscriptionLink(){
        functionClass.waitUntilElementPresent(newsletterLink);
        actions.moveToElement(newsletterLink).click(newsletterSubscriptionLink).build().perform();
    }

}
