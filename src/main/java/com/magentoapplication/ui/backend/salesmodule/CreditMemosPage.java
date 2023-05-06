package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreditMemosPage {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    @FindBy(xpath = "//input[@id='sales_creditmemo_grid_filter_increment_id']")
    WebElement filterCreditMemoField;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchCreditMemosButton;

    @FindAll(@FindBy(xpath = "//div[@class='hor-scroll']//table//tbody//tr"))
    List<WebElement> creditMemosList;



    public CreditMemosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        salesDashboardPage=new SalesDashboardPage(driver);
    }

    public void viewCreditMemosByFilters(){
        salesDashboardPage.clickOnCreditMemosLink();
        functionClass.waitUntilElementPresent(filterCreditMemoField);
        filterCreditMemoField.sendKeys("31700000002");
        functionClass.waitUntilElementPresent(searchCreditMemosButton);
        searchCreditMemosButton.click();


    }

    public boolean verifyViewCreditMemosByFilters(){
        if (creditMemosList.size()>=1){
            return true;}
            else return false;
    }
}
