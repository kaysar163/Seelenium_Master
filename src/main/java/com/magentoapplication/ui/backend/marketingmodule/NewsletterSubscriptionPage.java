package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsletterSubscriptionPage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;
    Actions actions;

    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement newsletterLink;
    @FindBy(xpath = "//span[text()='Newsletter Subscribers']")
    WebElement newsletterSubscribersLink;
    @FindAll(@FindBy( xpath = "//div[@class=\"hor-scroll\"]//table//tbody//tr"))
    List<WebElement> newsletterSubscribersList;

    public NewsletterSubscriptionPage(WebDriver driver) {
        this.driver = driver;
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);
    }

    public void viewNewsLetterSubscribers(){
        functionClass.waitUntilElementPresent(newsletterLink);
        actions.moveToElement(newsletterLink).click(newsletterSubscribersLink).build().perform();

    }

    public boolean verifyViewNewsletterSubscribers(){
        if (newsletterSubscribersList.size()>=1){
        return true;}
        else return false;
    }

}
