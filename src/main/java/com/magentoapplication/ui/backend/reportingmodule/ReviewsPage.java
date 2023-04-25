package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReviewsPage {
    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;

    public ReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        reportingDashboardPage =new  ReportingDashboardPage(driver);
    }
    //Elements
    @FindBy(xpath = "(//*[text()='Products Reviews'])[1]")
    WebElement productReviews;
    @FindBy(xpath = "(//tbody[1]//tr//td[7])[1]")
    WebElement showReviewsButton;
    @FindAll({@FindBy(xpath = "(//tbody[1]//tr//td[7])")})
    List<WebElement> proReviews;
    //Methods
    public void clickProductReviews(){
        reportingDashboardPage.clickOnReviewsLink();
        functionClass.waitUntilElementPresent(productReviews);
        productReviews.click();
        showReviewsButton.click();
    }
    public boolean verifyThatAllReviewsShown(){
        if(proReviews.size()>=1)
            return true;
        else return false;
    }

}
