package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath =" //img[@id='sales_report_from_trig']")
    WebElement timeBoxFrom;

    @FindBy(xpath ="//img[@id='sales_report_to_trig']")
    WebElement timeBoxTo;

    @FindBy(xpath ="//select[@name='show_order_statuses']")
    WebElement orderStatusField;



}
