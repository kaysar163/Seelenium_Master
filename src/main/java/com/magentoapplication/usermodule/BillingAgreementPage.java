package com.magentoapplication.usermodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingAgreementPage {
    @FindBy(linkText = "Billing Agreements")
    WebElement billingAgreementLink;

    @FindBy(xpath ="//h1[text()='Billing Agreements']")
            WebElement verifyBillingAgreementsLink;

    WebDriver driver;
    FunctionClass functionClass;

    public BillingAgreementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
    }

    public void clickMYWISHLISTLink() {
        functionClass.waitUntilElementPresent(billingAgreementLink);
        billingAgreementLink.click();
    }

    public boolean verifyMyWishListPageIsOpened() {
        if (verifyBillingAgreementsLink.isDisplayed())
            return true;
        else return false;

    }
}
