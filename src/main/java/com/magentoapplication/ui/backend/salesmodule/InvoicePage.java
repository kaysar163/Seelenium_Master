package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        salesDashboardPage=new SalesDashboardPage(driver);
    }
}
