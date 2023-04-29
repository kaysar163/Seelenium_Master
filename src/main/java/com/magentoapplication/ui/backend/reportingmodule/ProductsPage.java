package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {


    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        reportingDashboardPage = new ReportingDashboardPage(driver);
    }

//   public ProductsPage(WebDriver driver){
//        this.driver=driver;
//        PageFactory.initElements(driver,this);
//        functionClass=new FunctionClass(driver);
//        reportingDashboardPage=new ReportingDashboardPage(driver);
//
//    }
    @FindAll(@FindBy(xpath = "//div[@class='hor-scroll']/table/tbody/tr"))
    List<WebElement> productsDownloadsReportList;

    @FindAll(@FindBy(xpath = "//div[@class='hor-scroll']/table/tbody/tr"))
    List<WebElement> lowStockReportList;

    @FindBy(id="sales_report_period_type")
    WebElement timePeriodField;

    @FindBy(id="sales_report_from")
    WebElement dateFromField;

    @FindBy(id="sales_report_to")
    WebElement dateToField;

    @FindBy(id="sales_report_show_empty_rows")
    WebElement emptyRowsField;

    @FindBy(xpath = "(//button[@title=\"Show Report\"])[1]")
    WebElement showReportButton;
    @FindAll(@FindBy(xpath = "//div[@class='hor-scroll']/table/tbody/tr"))
    List<WebElement> mostViewedReportList;

    //For Prodoct order report
    @FindBy(xpath = "//input[@id='period_date_from']")
    WebElement fromDate;
    @FindBy(xpath = "//input[@id='period_date_to']")
    WebElement toDate;
    @FindBy(xpath = "//span[text()=\"Refresh\"]")
    WebElement refreshButton;
    @FindBy(xpath = "//th[text()=\"Total\"]")
    WebElement totalProdocts;

    public void viewProductsOrderedReport(String dateFrom,String dateTo){
        reportingDashboardPage.clickOnProductsOrderedLink();
        fromDate.sendKeys(dateFrom);
        functionClass.waitUntilElementPresent(toDate);
        toDate.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(refreshButton);
        refreshButton.click();
    }
    public boolean verifyProductsOrderedReport(){
        functionClass.waitUntilElementPresent(totalProdocts);
        if (totalProdocts.isDisplayed())
            return true;
        else return false;
    }








    public void seeProductsDownloadReport() {
        reportingDashboardPage.clickOnDownloadsLink();
    }

    public boolean verifySeeProductsDownloadReport() {
        if (productsDownloadsReportList.size() >= 1) {
            return true;
        } else return false;
    }

    public void seeLowStockReport() {
        reportingDashboardPage.clickOnLowstockLink();
    }

    public boolean verifySeeLowStockReport() {
        if (lowStockReportList.size()>=1){
            return true;
        }else return false;
    }

    public void seeMostViewedReport(String dateFrom,String dateTo){
        reportingDashboardPage.clickOnMostViewedLink();
        functionClass.waitUntilElementPresent(timePeriodField);
        Select select=new Select(timePeriodField);
        select.selectByValue("month");
        functionClass.waitUntilElementPresent(dateFromField);
        dateFromField.sendKeys(dateFrom);
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(dateToField);
        dateToField.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(emptyRowsField);
        Select select1=new Select(emptyRowsField);
        select1.selectByValue("1");
        functionClass.waitUntilElementPresent(showReportButton);
        showReportButton.click();




    }
    public  boolean verifyMostViewedReport(){
        if(mostViewedReportList.size()>=1){
            return true;
        }
        else return false;

    }
}

