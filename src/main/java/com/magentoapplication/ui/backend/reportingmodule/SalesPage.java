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
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        reportingDashboardPage =new  ReportingDashboardPage(driver);
        actions=new Actions(driver);
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
    @FindBy(xpath="(//input[@id='sales_report_from'])[1]")
    WebElement FromField;
    @FindBy(id = "sales_report_to")
    WebElement ToField;
    @FindBy(id = "sales_report_show_order_statuses")
    WebElement OrderStatusDropDown;
    @FindBy(id = "sales_report_show_empty_rows")
    WebElement EmptyRowsDropDown;
    @FindBy(xpath = "(//span[contains(text(),'Show Report')])[1]")
    WebElement ShowReportButton;
    @FindBy(xpath ="//tfoot//th[2]")
    WebElement SuccessMessage;

    public void viewTotalOrderedReport(String dateFrom,String dateTo){
       reportingDashboardPage.clickOnOrdersLink();
       functionClass.waitUntilElementPresent(fromDateIcon);
       fromDateIcon.sendKeys(dateFrom);
       functionClass.waitUntilElementPresent(toDateIcon);
        functionClass.sleep(5);
       toDateIcon.sendKeys(dateTo);
       functionClass.waitUntilElementPresent(showReportBut);
       showReportBut.click();

    }
    public boolean verifyOrderedReport(){
        functionClass.waitUntilElementPresent(totalOrder);
        if (totalOrder.isDisplayed())
            return true;
        else return false;

    }
    public void salesTotalRefundedReport(String dateFrom,String dateTo) {
        reportingDashboardPage.clickOnRefundsLink();
        functionClass.waitUntilElementPresent(ShowReportForDropDown);
        Select select=new Select(ShowReportForDropDown);
        select.selectByValue("341");
        functionClass.waitUntilElementPresent(MatchPeriodToDropDown);
        Select select1=new Select(MatchPeriodToDropDown);
        select1.selectByValue("created_at_order");
        functionClass.waitUntilElementPresent(PeriodToDropDown);
        Select select2=new Select(PeriodToDropDown);
        select2.selectByValue("day");
        functionClass.waitUntilElementPresent(FromField);
        FromField.sendKeys(dateFrom);
        functionClass.waitUntilElementPresent(ToField);
        ToField.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(OrderStatusDropDown);
        Select select3=new Select(OrderStatusDropDown);
        select3.selectByValue("1");
        functionClass.waitUntilElementPresent(EmptyRowsDropDown);
        Select select4=new Select(EmptyRowsDropDown);
        select4.selectByValue("1");
        functionClass.waitUntilElementPresent(ShowReportButton);
        ShowReportButton.click();

    }
    public boolean verifyRefundedReport(){
        functionClass.waitUntilElementPresent(SuccessMessage);
        if (SuccessMessage.isDisplayed()) {
            return true;
        } else return false;
    }



}



