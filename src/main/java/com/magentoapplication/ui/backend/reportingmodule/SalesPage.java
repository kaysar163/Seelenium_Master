package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalesPage {
    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;
    Actions actions;

    public SalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        reportingDashboardPage = new ReportingDashboardPage(driver);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//input[@id='sales_report_from']")
    WebElement fromDateIcon;
    @FindBy(xpath = "//input[@id='sales_report_to']")
    WebElement toDateIcon;
    @FindBy(xpath = "(//span[text()='Show Report'])[1]")
    WebElement showReportBut;
    @FindBy(xpath = "//tr[@class='totals']")
    WebElement totalOrder;

    @FindBy(id = "store_switcher")
    WebElement ShowReportForDropDown;
    @FindBy(id = "sales_report_report_type")
    WebElement MatchPeriodToDropDown;
    @FindBy(id = "sales_report_period_type")
    WebElement PeriodToDropDown;
    @FindBy(xpath = "(//input[@id='sales_report_from'])[1]")
    WebElement FromField;
    @FindBy(id = "sales_report_to")
    WebElement ToField;
    @FindBy(id = "sales_report_show_order_statuses")
    WebElement OrderStatusDropDown;
    @FindBy(id = "sales_report_show_empty_rows")
    WebElement EmptyRowsDropDown;
    @FindBy(xpath = "(//span[contains(text(),'Show Report')])[1]")
    WebElement ShowReportButton;
    @FindBy(xpath = "//tfoot//th[2]")
    WebElement SuccessMessage;
    //*****************************************
    @FindBy(id = "store_switcher")
    WebElement ShowReportFor1DropDown;
    @FindBy(id = "sales_report_report_type")
    WebElement Match_PeriodToDropDown;
    @FindBy(id = "sales_report_period_type")
    WebElement Period1;
    @FindBy(xpath = "(//img[@id='sales_report_from_trig'])[1]")
    WebElement SelecDateIcon;
    @FindBy(xpath = "//tr[@class='headrow']//td[1]")
    WebElement ForwardIcon;
    @FindBy(xpath = "(//td[@class='button' and @colspan='1'])[2]")
    WebElement CloseButton;

    @FindBy(id = "sales_report_to")
    WebElement To2Field;
    @FindBy(id = "sales_report_show_order_statuses")
    WebElement OrderStatus1DropDown;
    @FindBy(id = "sales_report_show_empty_rows")
    WebElement empty_rowsDropDown;
    @FindBy(name = "price_rule_type")
    WebElement ShoppingCartPriceRuleDropDown;
    @FindBy(xpath = "//tfoot//th[1]")
    WebElement Success1Message;

    //meryem
    @FindBy(xpath = "//input[@id='sales_report_from']")
    WebElement dateFromField;
    @FindBy(xpath = "//input[@id='sales_report_to']")
    WebElement dataToField;
    @FindBy(xpath = "(//span[text()='Show Report'])[1]")
    WebElement showReportLink;

    //meryem
    @FindBy(id = "sales_report_from")
    WebElement shippingReportDateFrom;
    @FindBy(id = "sales_report_to")
    WebElement shippingReportDateTo;
    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportButton1;
   // @FindBy(xpath = "//tr[@class='totals']")
   // WebElement totalShipped;

    public void viewTotalOrderedReport(String dateFrom, String dateTo) {
        reportingDashboardPage.clickOnOrdersLink();
        functionClass.waitUntilElementPresent(fromDateIcon);
        fromDateIcon.sendKeys(dateFrom);
        functionClass.waitUntilElementPresent(toDateIcon);
        functionClass.sleep(5);
        toDateIcon.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(showReportBut);
        showReportBut.click();

    }

    public boolean verifyOrderedReport() {
        functionClass.waitUntilElementPresent(totalOrder);
        if (totalOrder.isDisplayed())
            return true;
        else return false;

    }

    public void salesTotalRefundedReport(String dateFrom, String dateTo) {
        reportingDashboardPage.clickOnRefundsLink();
        functionClass.waitUntilElementPresent(ShowReportForDropDown);
        Select select = new Select(ShowReportForDropDown);
        select.selectByValue("341");
        functionClass.waitUntilElementPresent(MatchPeriodToDropDown);
        Select select1 = new Select(MatchPeriodToDropDown);
        select1.selectByValue("created_at_order");
        functionClass.waitUntilElementPresent(PeriodToDropDown);
        Select select2 = new Select(PeriodToDropDown);
        select2.selectByValue("day");
        functionClass.waitUntilElementPresent(FromField);
        FromField.sendKeys(dateFrom);
        functionClass.waitUntilElementPresent(ToField);
        ToField.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(OrderStatusDropDown);
        Select select3 = new Select(OrderStatusDropDown);
        select3.selectByValue("1");
        functionClass.waitUntilElementPresent(EmptyRowsDropDown);
        Select select4 = new Select(EmptyRowsDropDown);
        select4.selectByValue("1");
        functionClass.waitUntilElementPresent(ShowReportButton);
        ShowReportButton.click();

    }

    public boolean verifyRefundedReport() {
        functionClass.waitUntilElementPresent(SuccessMessage);
        if (SuccessMessage.isDisplayed()) {
            return true;
        } else return false;
    }

    public void salesCouponsUsageReport() {
        reportingDashboardPage.clickOnCouponsLink();
        functionClass.waitUntilElementPresent(ShowReportFor1DropDown);
        Select select = new Select(ShowReportFor1DropDown);
        select.selectByValue("341");
        functionClass.waitUntilElementPresent(Match_PeriodToDropDown);
        Select select2 = new Select(Match_PeriodToDropDown);
        select2.selectByValue("updated_at_order");
        functionClass.waitUntilElementPresent(Period1);
        Select select3 = new Select(Period1);
        select3.selectByValue("year");
        functionClass.waitUntilElementPresent(SelecDateIcon);
        SelecDateIcon.click();
        functionClass.waitUntilElementPresent(ForwardIcon);
        for (int i = 0; i <= 3; i++) {
            ForwardIcon.click();
        }
        functionClass.waitUntilElementPresent(CloseButton);
        CloseButton.click();
        functionClass.waitUntilElementPresent(To2Field);
        To2Field.sendKeys(functionClass.currentDate());

        functionClass.waitUntilElementPresent(OrderStatus1DropDown);
        Select select4 = new Select(OrderStatus1DropDown);
        select4.selectByValue("1");
        functionClass.waitUntilElementPresent(EmptyRowsDropDown);
        Select select6 = new Select(EmptyRowsDropDown);
        select6.selectByValue("0");
        functionClass.waitUntilElementPresent(ShoppingCartPriceRuleDropDown);
        Select select0 = new Select(ShoppingCartPriceRuleDropDown);
        select0.selectByValue("1");
        functionClass.waitUntilElementPresent(ShowReportButton);
        ShowReportButton.click();
    }

    public boolean verifyCouponsUsageReport() {
        functionClass.waitUntilElementPresent(SuccessMessage);
        if (Success1Message.isDisplayed()) {
            return true;
        } else return false;
    }
    public void TotalInvoicedVsPaidReport(String dateFrom, String dateTo) {
        reportingDashboardPage.clickOnInvoicedLink();
        functionClass.waitUntilElementPresent(dateFromField);
        dateFromField.sendKeys(dateFrom);
        functionClass.waitUntilElementPresent(dataToField);
        functionClass.sleep(5);
        dataToField.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(showReportLink);
        showReportLink.click();

    }

    public boolean verifyTotalInvoicedVsPaidReport() {
        functionClass.waitUntilElementPresent(SuccessMessage);
        if (Success1Message.isDisplayed()) {
            return true;
        } else return false;

    }

    public void salesTotalShippedReport(String dateFrom, String dateTo) {
        reportingDashboardPage.clickOnShippingLink();
        functionClass.waitUntilElementPresent(shippingReportDateFrom);
        dateFromField.sendKeys(dateFrom);
        functionClass.waitUntilElementPresent(shippingReportDateTo);
        functionClass.sleep(5);
        dataToField.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(showReportButton1);
        showReportButton1.click();
    }

    public boolean verifyTotalShippedReport() {
        functionClass.waitUntilElementPresent(SuccessMessage);
        if (Success1Message.isDisplayed()) {
            return true;
        } else return false;
    }
}




