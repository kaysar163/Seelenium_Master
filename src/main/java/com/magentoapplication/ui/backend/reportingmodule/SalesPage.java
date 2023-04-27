package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(id = "//input[@id='sales_report_from']")
    WebElement fromDateIcon;
    @FindBy(id = "//input[@id='sales_report_to']")
    WebElement toDateIcon;
    @FindBy(id = "(//span[text()='Show Report'])[1]")
    WebElement showReportBut;
    @FindBy(id = "//tr[@class='totals']")
    WebElement totalOrder;

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


}



