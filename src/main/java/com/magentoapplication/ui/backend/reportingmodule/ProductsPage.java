package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;
    @FindAll(@FindBy(xpath = "//div[@class='hor-scroll']/table/tbody/tr"))
    List<WebElement> productsDownloadsReportList;




    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        reportingDashboardPage =new  ReportingDashboardPage(driver);
    }

public void seeProductsDownloadReport(){
        reportingDashboardPage.clickOnDownloadsLink();
}

public boolean verifySeeProductsDownloadReport(){
if (productsDownloadsReportList.size()>=1){
    return true;
}else return false;
}

}

