package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesPage {
    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;

    public SalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        reportingDashboardPage =new  ReportingDashboardPage(driver);
    }
    @FindBy(id = "sales_report_from_trig")
    WebElement fromDateIcon;
  //  @FindBy(id = "sales_report_from_trig")
//    WebElement fromDateIcon;
//    @FindBy(id = "sales_report_from_trig")
//    WebElement fromDateIcon;
//    @FindBy(id = "sales_report_from_trig")
//    WebElement fromDateIcon;
//    @FindBy(id = "sales_report_from_trig")
//    WebElement fromDateIcon;
//    @FindBy(id = "sales_report_from_trig")
//    WebElement fromDateIcon;

}



