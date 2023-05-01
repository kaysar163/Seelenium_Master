package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import net.jodah.failsafe.internal.util.DelegatingExecutorService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RefundReportPage {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    public RefundReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        salesDashboardPage=new SalesDashboardPage(driver);

    }



    @FindBy(xpath = "//select[@name='store_switcher']")
    WebElement storeField;

    @FindBy(xpath ="//select[@id='sales_report_report_type']")
    WebElement reportTypeField;

    @FindBy(xpath ="//select[@name='period_type']")
    WebElement periodTypeField;

    @FindBy(xpath = "//input[@id='sales_report_to']")
    WebElement dateTo;

    @FindBy(xpath = "//input[@id='sales_report_from']")
    WebElement dateFrom;

    @FindBy(xpath ="//select[@name='show_order_statuses']")
    WebElement orderStatusField;

    @FindBy(xpath ="//select[@name='show_empty_rows']")
    WebElement emptyRows;

    @FindBy(xpath = "//button[@title='Show Report'][1]")
    WebElement showReportButton;

    @FindBy(xpath ="//div[@class='grid']//tbody")
    WebElement totalRefundedTable;




    public void viewRefundsInTheReports(){
        salesDashboardPage.clickOnRefundsLink();
        functionClass.waitUntilElementPresent(storeField);
        storeField.click();
        Select select=new Select(storeField);
        select.selectByValue("443");
        functionClass.waitUntilElementPresent(reportTypeField);
        reportTypeField.click();
        //Select select1=new Select(reportTypeField);
        //select.selectByValue("created_at_order");
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(periodTypeField);
        periodTypeField.click();
        //Select select2=new Select(periodTypeField);
        //select.selectByValue("day");
        functionClass.waitUntilElementPresent(dateFrom);
        dateFrom.clear();
        functionClass.sleep(2);
        //String fromDate=functionClass.date();
        dateFrom.sendKeys(functionClass.date());
        functionClass.waitUntilElementPresent(dateTo);
        dateTo.clear();
        functionClass.sleep(2);
        //String toDate=functionClass.date();
        dateTo.sendKeys(functionClass.date());
        functionClass.waitUntilElementPresent(orderStatusField);
        orderStatusField.click();
        //Select select3=new Select(orderStatusField);
        //select.selectByValue("0");
        functionClass.waitUntilElementPresent(emptyRows);
        emptyRows.click();
        //Select select4=new Select(emptyRows);
        //select.selectByValue("1");
        functionClass.waitUntilElementPresent(showReportButton);
        showReportButton.click();
    }



        public boolean verifyRefundsInTheReportsViewed() {

            if (driver.getPageSource().contains("No records found for this period.")||totalRefundedTable.isDisplayed())
                return true;
            else
                return false;
        }




}
