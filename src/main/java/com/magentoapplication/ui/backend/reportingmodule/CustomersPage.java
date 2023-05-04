package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.ui.backend.salesmodule.SalesDashboardPage;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersPage {
    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        reportingDashboardPage =new  ReportingDashboardPage(driver);
    }

    @FindBy(id = "period_date_from_trig")
    WebElement fromDateIcon;

    @FindBy(xpath = "//tr[@class='headrow']//td[1]")
    WebElement backwardIcon;

    @FindBy(id = "period_date_to_trig")
    WebElement toDateIcon;

    @FindBy(id = "period_date_to")
    WebElement dateField;

    @FindBy(xpath = "//span[text()='Refresh']")
    WebElement refreshButton;

    @FindBy(xpath = "(//td[@class='button' and @colspan='1'])[2]")
    WebElement closeButton;


    @FindAll(
            @FindBy(xpath = "//table[@id='gridOrdersCustomer_table']//tbody//tr")
    )
    WebElement verifyViewsCustomersReportElement;

    @FindBy(xpath = "//table[@id='gridOrdersCustomer_table']//tbody//tr//td[5]")
    WebElement customerExist;


    @FindBy(xpath ="//select[@id='store_switcher']")
    WebElement storeField;

    @FindBy(xpath = "//input[@id='period_date_from']")
    WebElement dateFromField;

    @FindBy(xpath = "//input[@id='period_date_to']")
    WebElement dateToField;

    @FindBy(xpath ="//button[@title='Refresh']")
    WebElement RefreshButton;

    @FindAll(
            @FindBy(xpath = "//table[@id='gridOrdersCustomer_table']")
    )
    WebElement ViewsCustomersByTotalOrderReportElement;


    @FindBy(xpath = "//div[@class='grid']")
    WebElement noRecordReportTable;




    public void viewCustomersByTotalOrdersReport(String dateFrom ,String dateTo){
        reportingDashboardPage.clickOnCustomersbyorderstotalsLink();
        functionClass.waitUntilElementPresent(storeField);
        storeField.click();
        //Select select=new Select(storeField);
        //select.selectByValue("436");
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(dateFromField);
        dateFromField.clear();
        dateFromField.sendKeys(dateFrom);
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(dateToField);
        dateToField.clear();
        dateToField.sendKeys(dateTo);
        functionClass.waitUntilElementPresent(RefreshButton);
        RefreshButton.click();

    }

    public boolean verifyViewCustomersByTotalOrdersReport()
      { functionClass.waitUntilElementPresent(noRecordReportTable);
        if (noRecordReportTable.isDisplayed()){
            if (driver.getPageSource().contains("No records found for this period.")){
                System.out.println("There is no customer order record");
            } else if (ViewsCustomersByTotalOrderReportElement.isDisplayed()){
                System.out.println("Customer Order record Exist");
            }
            return true;
        }
        else return false;
    }






    public void viewCustomersByNumberOfReports(){
        reportingDashboardPage.clickOnCustomersbynumberofordersLink();
        functionClass.waitUntilElementPresent(fromDateIcon);
        fromDateIcon.click();
        functionClass.waitUntilElementPresent(backwardIcon);
        for (int i=0;i<=3;i++){
            backwardIcon.click();
        }
        functionClass.waitUntilElementPresent(closeButton);
        closeButton.click();
        functionClass.waitUntilElementPresent(dateField);
        dateField.sendKeys(functionClass.date());
        functionClass.waitUntilElementPresent(refreshButton);
        refreshButton.click();
    }

    public boolean verifyViewsCustomersReport(){
        functionClass.waitUntilElementPresent(verifyViewsCustomersReportElement);
        if (verifyViewsCustomersReportElement.isDisplayed()){
            if (driver.getPageSource().contains("No records found for this period.")){
                System.out.println("There is no customer record");
            } else if (customerExist.isDisplayed()){
                System.out.println("Customer Report Exist");
            }
            return true;
        }
       else return false;
    }

    public void seeNewAccounts(){
        reportingDashboardPage.clickOnNewAccountsLink();
        functionClass.waitUntilElementPresent(fromDateIcon);
        fromDateIcon.click();
        functionClass.waitUntilElementPresent(toDateIcon);
        toDateIcon.click();
        functionClass.waitUntilElementPresent(refreshButton);
        refreshButton.click();

    }





}


