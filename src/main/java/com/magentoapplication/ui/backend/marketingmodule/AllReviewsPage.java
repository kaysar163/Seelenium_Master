package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class AllReviewsPage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;

    Actions actions;

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;

    @FindBy(xpath = "//span[text()='Reviews and Ratings']")
    WebElement reviewsAndRatingLink;

    @FindBy(xpath = "//span[text()='Customer Reviews']")
    WebElement customerReviewsLink;

    @FindBy(xpath = "//span[text()='All Reviews']")
    WebElement allReviewsLink;

    @FindAll(@FindBy(xpath = "//div [@class=\"hor-scroll\"]//table//tbody//tr"))
        List<WebElement> allReviewsList;




    public AllReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);
    }

    public void viewAllReviewsFunction(){
        functionClass.waitUntilElementPresent(catalogLink);
        actions.moveToElement(catalogLink).click(reviewsAndRatingLink)
                .moveToElement(customerReviewsLink).click(allReviewsLink)
                .build().perform();
    }

    public boolean verifyViewAllReviewsFunction(){
        if (allReviewsList.size()>=1){
            return true;
        }
        else return false;


    }
}
