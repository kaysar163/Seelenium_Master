package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PendingReviewsPage {
    WebDriver driver;
    FunctionClass functionClass;
    MarketingDashboardPage marketingDashboardPage;
    Actions actions;

    public PendingReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        marketingDashboardPage = new MarketingDashboardPage(driver);
    }


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

    @FindBy(xpath = ("(//a[contains(text(),'Edit')])[1]"))
    WebElement EditButton;
    @FindBy(id = ("detail"))
    WebElement ReviewFiel;

    @FindBy(id = "save_button")
    WebElement SaveReviewButton;
    @FindBy(xpath = ("//span[contains(text(),'The review has been saved.')]"))
    WebElement SuccessfulMessage;

    @FindBy(id = "id_9fced84f1fce2cefee7cb952b1d457c7")
    WebElement SearchButton;


    @FindAll(@FindBy(xpath = "//table[@id='reviwGrid_table']//tbody"))
    List<WebElement> pendingReviewsList;
    @FindBy(css = "#reviwGrid_table > tbody")
    WebElement pendingTable;
    @FindAll(@FindBy(xpath = "//a[text()=\"Edit\"]"))
    List<WebElement> editIconList;
    @FindBy(id="status_id")
    WebElement selectStatus;
    @FindBy(id="detail")
    WebElement reviewInfoField;


    public void updateExistingReviewsTest() {
        marketingDashboardPage.clickOnAllReviewsLink();
        functionClass.waitUntilElementPresent(EditButton);
        EditButton.click();
        functionClass.waitUntilElementPresent(ReviewFiel);
        ReviewFiel.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(SaveReviewButton);
        SaveReviewButton.click();
    }

    public boolean VerifySuccessfulMessage() {
        functionClass.waitUntilElementPresent(SuccessfulMessage);
        if (SuccessfulMessage.isDisplayed()) {
            return true;
        } else return false;
    }


    public void managerUpdatePendingReviews() {
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(reviewsAndRatingLink);
        reviewsAndRatingLink.click();
        functionClass.waitUntilElementPresent(customerReviewsLink);
        customerReviewsLink.click();
        functionClass.waitUntilElementPresent(pendingReviewsLink);
        pendingReviewsLink.click();

        functionClass.waitUntilElementPresent(pendingTable);
        for(int i=0;i<editIconList.size();i++){
            editIconList.get(i).click();
        }
        functionClass.waitUntilElementPresent(selectStatus);
        Select select=new Select(selectStatus);
        select.selectByVisibleText("Pending");
        functionClass.waitUntilElementPresent(reviewInfoField);
        reviewInfoField.sendKeys(functionClass.generateProductDescription());
        Actions actions=new Actions(driver);
        functionClass.waitUntilElementPresent(saveElementButton);
        actions.moveToElement(saveElementButton).click().build().perform();


    }

    public boolean verifyUpdatePendingReviews() {
        if (successMessage.isDisplayed()) {
            return true;
        } else return false;

    }

    public void viewPandingReviews() {
        functionClass.waitUntilElementPresent(catalogLink);
        catalogLink.click();
        functionClass.waitUntilElementPresent(reviewsAndRatingLink);
        reviewsAndRatingLink.click();
        functionClass.waitUntilElementPresent(customerReviewsLink);
        customerReviewsLink.click();
        marketingDashboardPage.clickOnPendingReviewsLink();
    }

    public boolean verifyPendingReviews() {
        if (pendingReviewsList.size() >= 1)
            return true;
        else return false;


    }

}
