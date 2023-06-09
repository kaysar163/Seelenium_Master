package com.magentoapplication.ui.backend.reportingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;

    FunctionClass functionClass;

    ReportingDashboardPage reportingDashboardPage;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        reportingDashboardPage =new  ReportingDashboardPage(driver);
    }


    @FindBy(xpath = "//select[@title='Period']")
    WebElement periodDropDown;
    @FindBy(css = "input#sales_report_from")
    WebElement fromDateField;
    @FindBy(css = "input#sales_report_to")
    WebElement toDateField;
    @FindBy(xpath = "(//span[contains(text(),\"Show Report\")])[1]")
    WebElement showReportButton;

    @FindAll(@FindBy(css = ".data>tbody>tr"))
    List<WebElement> shippedReportTable;


    //Fazilet
    @FindBy(xpath ="//select[@id='store_switcher']")
    WebElement storeField;

    @FindBy(xpath = "//button[@title='Search']")
    WebElement searchButton;

    @FindBy(xpath ="//div[@class='grid']")
    WebElement abandonedCartsTable;

    @FindBy(xpath = "//table[@id='gridAbandoned_table']")
    WebElement unexistAbandonedCartsTable;


    public void viewAbandonedShoppingCartsReport(){
        reportingDashboardPage.clickOnAbandonedcartsLink();
        functionClass.waitUntilElementPresent(storeField);
        storeField.click();
        Select select=new Select(storeField);
        select.selectByValue("439");
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
    }


    public boolean verifyViewAbandonedShoppingCartsReport(){
        functionClass.waitUntilElementPresent(unexistAbandonedCartsTable);
        if (unexistAbandonedCartsTable.isDisplayed()){
            if (driver.getPageSource().contains("No records found .")){
                System.out.println("There is no abandoned cart record");
            } else if (abandonedCartsTable.isDisplayed()){
                System.out.println("Abandoned Carts Report Exist");
            }
            return true;
        }
        else return false;
    }



    public void viewSalesShippedReport(){
        reportingDashboardPage.clickOnProductsincartsLink();
    }

    public boolean verifyViewSalesShippedReportSuccessfully() {
        if(shippedReportTable.get(1).isDisplayed()) {
            System.out.println("Reporting Manager see sales- Total Shipped Report Test is Passed!!!");
            return true;
        }else {
            System.out.println("Reporting Manager see sales- Total Shipped Report Test is Failed!!!");
            return false;
        }
    }

}

