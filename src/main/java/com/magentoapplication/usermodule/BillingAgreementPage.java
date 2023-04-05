package com.magentoapplication.usermodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingAgreementPage {
    @FindBy(xpath = "//div[@class=\"block-content\"]//li//a//strong")
    WebElement billingAgreementLink;

    @FindBy(xpath ="//div[@class=\"my-account\"]//div//h1")
    WebElement verifyBillingAgreementsLink;

    WebDriver driver;
    FunctionClass functionClass;

    public BillingAgreementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
    }

    public void clickBillingAgreemnetsLink() {
        functionClass.waitUntilElementPresent(billingAgreementLink);
        billingAgreementLink.click();
        functionClass.sleep(3);
    }

    public boolean verifyBillingAgreementsLink() {
        if (verifyBillingAgreementsLink.isDisplayed())
            return true;
        else return false;

    }
}
