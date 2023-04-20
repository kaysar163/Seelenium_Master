package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.ui.backend.salesmodule.SalesDashboardPage;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(css = ".hilite.nav.button.hilite")
    WebElement backwardIcon;

    @FindBy(id = "period_date_to_trig")
    WebElement toDateIcon;

    @FindBy(xpath = "(//div[text()='today'])[7]")
    WebElement todayLink;

    @FindBy(xpath = "//span[text()='Refresh']")
    WebElement refreshButton;

    @FindBy(xpath = "(//td[@class='button'])[17]")
    WebElement closeButton;


    @FindAll(
            @FindBy(xpath = "//table[@id='gridOrdersCustomer_table']//tbody//tr")
    )
    WebElement verifyViewsCustomersReportElement;

    @FindBy(xpath = "//table[@id='gridOrdersCustomer_table']//tbody//tr//td[5]")
    WebElement customerExist;

    public void viewCustomersByNumberOfReports(){
        reportingDashboardPage.clickOnCustomersLink();
        functionClass.waitUntilElementPresent(fromDateIcon);
        fromDateIcon.click();
        functionClass.waitUntilElementPresent(backwardIcon);
        for (int i=0;i<=3;i++){
            backwardIcon.click();
        }
        functionClass.waitUntilElementPresent(closeButton);
        closeButton.click();
        functionClass.waitUntilElementPresent(toDateIcon);
        toDateIcon.click();
        functionClass.waitUntilElementPresent(todayLink);
        todayLink.click();
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





}


