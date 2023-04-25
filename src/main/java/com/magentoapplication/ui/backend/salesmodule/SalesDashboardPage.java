package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesDashboardPage {

    WebDriver driver;

    FunctionClass functionClass;

    Actions actions;

    public SalesDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        actions=new Actions(driver);
    }

    @FindBy(xpath = "(//span[text()='Sales'])[1]")
    WebElement salesLink;

    @FindBy(xpath = "(//span[text()='Orders'])[1]")
    WebElement ordersLink;

    @FindBy(xpath = "//span[text()='Invoices']")
    WebElement invoiceLink;

    @FindBy(xpath = "//span[text()='Shipments']")
    WebElement shipmentsLink;

    @FindBy(xpath = "(//span[text()='Tax'])[1]")
    WebElement taxLink;

    @FindBy(xpath = "//span[text()='Manage Tax Rules']")
    WebElement manageTaxRuleLink;

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement reportsLink;

    @FindBy(xpath = "(//span[text()='Sales'])[2]")
    WebElement salesUnderReportLink;

    @FindBy(xpath = "//span[text()='Refunds']")
    WebElement refundsLink;

    @FindBy(xpath = "//span[text()='Coupons']")
    WebElement couponsLink;

    @FindBy(xpath = "//span[text()='Credit Memos']")
    WebElement creditMemosLink;

    @FindBy(xpath = "(//span[text()='Customers'])[1]")
    WebElement customersLink;

    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement manageCustomersLink;

   public void clickOnOrdersLink(){
       functionClass.waitUntilElementPresent(salesLink);
       salesLink.click();
       functionClass.waitUntilElementPresent(ordersLink);
       ordersLink.click();

      // actions.moveToElement(salesLink).click(ordersLink).build().perform();
   }
    public void clickOnInvoiceLink(){
        functionClass.waitUntilElementPresent(salesLink);
        actions.moveToElement(salesLink).click(invoiceLink).build().perform();
    }

    public void clickOnShipmentsLink(){
        functionClass.waitUntilElementPresent(salesLink);
        actions.moveToElement(salesLink).click(shipmentsLink).build().perform();
    }

    public void clickOnCreditMemosLink(){
        functionClass.waitUntilElementPresent(salesLink);
        actions.moveToElement(salesLink).click(creditMemosLink).build().perform();
    }

    public void clickOnManageTaxRuleLink(){
        functionClass.waitUntilElementPresent(salesLink);
        actions.moveToElement(salesLink).moveToElement(taxLink).click(manageTaxRuleLink).build().perform();
    }

    public void clickOnManageCustomersLink(){
        functionClass.waitUntilElementPresent(customersLink);
        actions.moveToElement(customersLink).click(manageCustomersLink).build().perform();
    }

    public void clickOnRefundsLink(){
        functionClass.waitUntilElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(salesUnderReportLink).click(refundsLink).build().perform();
    }

    public void clickOnCouponsLink(){
        functionClass.waitUntilElementPresent(reportsLink);
        actions.moveToElement(reportsLink).moveToElement(salesUnderReportLink).click(couponsLink).build().perform();
    }




}
