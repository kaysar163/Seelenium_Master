package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportingDashboardPage {
    WebDriver driver;

    FunctionClass functionClass;

    Actions actions;

    public ReportingDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//span[text()='Reports']")
    WebElement ReportsLink;
    @FindBy(xpath = "//span[text()='Sales']")
    WebElement SalesLink;
    @FindBy(xpath = "(//span[text()='Orders'])[1]")
    WebElement OrdersLink;

    @FindBy(xpath = "(//span[text()='Tax'])[1] ")
    WebElement TaxLink;
    @FindBy(xpath = "(//span[text()='Invoiced'])[1] ")
    WebElement InvoicedLink;
    @FindBy(xpath = "(//span[text()='Shipping'])[1] ")
    WebElement ShippingLink;
    @FindBy(xpath = "(//span[text()='Refunds'])[1]")
    WebElement RefundsLink;
    @FindBy(xpath = "(//span[text()='Coupons'])[1]")
    WebElement CouponsLink;
    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement ShoppingCartLink;

    @FindBy(xpath = "//span[text()='Products in carts']")
    WebElement ProductsincartsLink;

    @FindBy(xpath = "//span[text()='Abandoned carts']")
    WebElement AbandonedcartsLink;

    @FindBy(xpath = "(//span[text()='Products'])[1]")
    WebElement ProductsLink;


    @FindBy(xpath = "(//span[contains(text(),'Bestsellers')])[1]")
    WebElement BestsellersLink;

    @FindBy(xpath = "(//span[contains(text(),'Products Ordered')]")
    WebElement ProductsOrderedLink;

    @FindBy(xpath = "(//span[contains(text(),'Most Viewed')])[1]")
    WebElement MostViewedLink;
    @FindBy(xpath = "//span[contains(text(),'Low stock')]")
    WebElement LowstockLink;

    @FindBy(xpath = "(//span[contains(text(),'Downloads')])[1]")
    WebElement DownloadsLink;

    @FindBy(xpath = "(//span[contains(text(),'Customers')])[1]")
    WebElement CustomersLink;
    @FindBy(xpath = "//span[contains(text(),'New Accounts')]")
    WebElement NewAccountsLink;
    @FindBy(xpath = "//span[contains(text(),'Customers by orders total')]")
    WebElement CustomersbyorderstotalsLink;
    @FindBy(xpath = "//span[contains(text(),'Customers by number of orders')]")
    WebElement CustomersbynumberofordersLink;
    @FindBy(xpath = "//span[contains(text(),'Tags')]")
    WebElement TagsLink;
    @FindBy(xpath = "(//span[contains(text(),'Customers')])[4]")
    WebElement Customers1Link;
    @FindBy(xpath = "(//span[contains(text(),'Products')])[4]")
    WebElement Products1link;
    @FindBy(xpath = "(//span[text()='Popular']")
    WebElement Populars1link;
    @FindBy(xpath = "//span[normalize-space()='Reviews']")
    WebElement ReviewsLink;
    @FindBy(xpath = "(//span[normalize-space()='Products Reviews'])[1]")
    WebElement ProductsReviewsLink;

    public void clickOnOrdersLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(SalesLink).click(OrdersLink).build().perform();

    }

    public void clickOnTaxLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(SalesLink).click(TaxLink).build().perform();
    }

    public void clickOnShippingLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(SalesLink).click(ShippingLink).build().perform();
    }

    public void clickOnInvoicedLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(SalesLink).click(InvoicedLink).build().perform();
    }

    public void clickOnRefundsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(SalesLink).click(RefundsLink).build().perform();
    }

    public void clickOnCouponsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(SalesLink).click(CouponsLink).build().perform();
    }

    public void clickOnShoppingCartLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ShoppingCartLink).click(ProductsincartsLink).build().perform();
    }

    public void clickOnProductsincartsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ShoppingCartLink).click(ProductsincartsLink).build().perform();
    }

    public void clickOnAbandonedcartsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ShoppingCartLink).click(AbandonedcartsLink).build().perform();
    }
    public void clickOnBestsellersLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ProductsLink).click(BestsellersLink).build().perform();
    }

    public void clickOnProductsOrderedLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ProductsLink).click(ProductsOrderedLink).build().perform();
    }

    public void clickOnMostViewedLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ProductsLink).click(MostViewedLink).build().perform();
    }

    public void clickOnLowstockLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ProductsLink).click(LowstockLink).build().perform();
    }

    public void clickOnDownloadsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ProductsLink).click(DownloadsLink).build().perform();
    }

    public void clickOnNewAccountsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(CustomersLink).click(NewAccountsLink).build().perform();
    }

    public void clickOnCustomersbyorderstotalsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(CustomersLink).click(CustomersbyorderstotalsLink).build().perform();

    }

    public void clickOnCustomersbynumberofordersLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(CustomersLink).click(CustomersbynumberofordersLink).build().perform();
    }



    public void clickOnCustomers1Link() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(TagsLink).click(Customers1Link).build().perform();
    }

    public void clickOnProducts1link() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(TagsLink).click(Products1link).build().perform();

    }

    public void clickOnPopulars1link() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(TagsLink).click(Populars1link).build().perform();

    }

    public void clickOnReviewsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ReviewsLink).click(ReviewsLink).build().perform();
    }

    public void clickProductsReviewsLink() {
        functionClass.waitUntilElementPresent(ReportsLink);
        actions.moveToElement(ReportsLink).click(ReviewsLink).click(ProductsReviewsLink).build().perform();
    }
}





