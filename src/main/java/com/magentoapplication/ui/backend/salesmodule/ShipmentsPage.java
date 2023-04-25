package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentsPage {

    WebDriver driver;

    FunctionClass functionClass;
    SalesDashboardPage salesDashboardPage;


    public ShipmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        salesDashboardPage = new SalesDashboardPage(driver);
    }

    @FindBy(xpath = " (//a[text()='View'])[1]")
    WebElement viewOption;
    @FindBy(xpath = "//*[@class='select']/option[6]")
    WebElement dhlOption;
    @FindBy(id = "tracking_number")
    WebElement inputOption;
    @FindBy(xpath = "//*[text()='Add']")
    WebElement addButton;
    @FindBy(xpath = "//*[@id='history_comment']")
    WebElement textLabel;
    @FindBy(xpath = "//*[@id='submit_comment_button']/span/span/span")
    WebElement submitCommentButton;
    @FindBy(xpath = "//*[@id='comments_block']/ul/li")
    WebElement shipmentComment;
    @FindBy(xpath = "//span[text()='Send Tracking Information'][1]")
    WebElement sendTrackingInformationButton;
    @FindBy(xpath = "//span[text()='The shipment has been sent.']")
    WebElement verifyShipmentHasBeenSent;

    public void updateShipmentHistory() {
        salesDashboardPage.clickOnManageCustomersLink();
        functionClass.waitUntilElementPresent(viewOption);
        viewOption.click();
        functionClass.waitUntilElementPresent(dhlOption);
        dhlOption.click();
        functionClass.waitUntilElementPresent(inputOption);
        inputOption.clear();
        inputOption.sendKeys("2");
        functionClass.waitUntilElementPresent(addButton);
        addButton.click();
        functionClass.waitUntilElementPresent(textLabel);
        textLabel.clear();
        textLabel.sendKeys("very good");
        functionClass.waitUntilElementPresent(submitCommentButton);
        submitCommentButton.click();
    }
}
//    public boolean verifyShipmentPage() {
//
//    }
//}