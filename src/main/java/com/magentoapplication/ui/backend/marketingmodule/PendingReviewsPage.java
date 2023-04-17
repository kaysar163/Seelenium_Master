package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PendingReviewsPage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;
    Actions actions;

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;

    @FindBy(xpath = "//span[text()='Customer Reviews']")
    WebElement customerReviewsLink;

    @FindBy(xpath = "//span[text()='Reviews and Ratings']")
    WebElement reviewsAndRatingLink;

    @FindBy(xpath = "//span[text()='Pending Reviews']")
    WebElement pendingReviewsLink;

    @FindBy(xpath = "//div[@class=\"product-review-box\"]/table/tbody/tr/td/input[@id=\"Quality_3\"]")
    WebElement detailedRatingRadioButton;

    @FindBy(xpath = "//select[@id=\"select_stores\"]")
    WebElement visibleStore;

    @FindBy(xpath = "//input[@id=\"nickname\"]")
    WebElement nickName;

    @FindBy(xpath = "//input[@id=\"title\"]")
    WebElement summaryOfReviews;

    @FindBy(xpath = "//textarea[@id=\"detail\"]")
    WebElement reviews;
    @FindBy(xpath = "//button[@id='save_button']")
    WebElement saveElementButton;

    @FindBy(xpath = "//span[contains(text(),\"The review has been saved.\")]")
    WebElement successMessage;


    public PendingReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);

    }

    public void  managerUpdatePendingReviews (){
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(reviewsAndRatingLink);
        reviewsAndRatingLink.click();
        functionClass.waitUntilElementPresent(customerReviewsLink);
        customerReviewsLink.click();
        functionClass.waitUntilElementPresent(pendingReviewsLink);
        pendingReviewsLink.click();
//        actions.moveToElement(catalogLink)
//                .click(reviewsAndRatingLink).moveToElement(customerReviewsLink)
//                .click(pendingReviewsLink).build().perform();
        WebElement  editButton= driver.findElement
                (By.xpath("//div[@class=\"hor-scroll\"]/table/tbody/tr/td[contains(text(),\"Rhona \")]/following-sibling::td/a[text()=\"Edit\"]"));
        editButton.click();
        functionClass.waitUntilElementPresent(detailedRatingRadioButton);
        detailedRatingRadioButton.isSelected();
       functionClass.waitUntilElementPresent(visibleStore);
         Select select=new Select(visibleStore);
//         functionClass.sleep(3);
//        select.selectByVisibleText("www.gulzartrim.com.tr");
//        functionClass.waitUntilElementPresent(nickName);
        nickName.clear();
        nickName.sendKeys(functionClass.generateFakeName());

        functionClass.waitUntilElementPresent(summaryOfReviews);
        summaryOfReviews.clear();
        summaryOfReviews.sendKeys(functionClass.generateProductDescription()+System.currentTimeMillis());
        functionClass.waitUntilElementPresent(reviews);
        reviews.clear();
        reviews.sendKeys(functionClass.generateProductDescription());
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(saveElementButton);
        saveElementButton.click();
        //marketingDashboardPage.clickOnPendingReviewsLink();

    }
    public boolean verifyUpdatePendingReviews(){
        if(successMessage.isDisplayed()){
            return true;
        }
        else return false;

    }


}
