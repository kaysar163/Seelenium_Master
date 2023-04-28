package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CouponsReportPage {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;
    @FindBy(xpath = "//select[@id=\"store_switcher\"]")
    WebElement ShowReportDropDown;
    @FindBy(id = "sales_report_report_type")
    WebElement MatchPeriodSelectionDropdown;
    @FindBy(id = "sales_report_period_type")
    WebElement PeriodDropdown;
    @FindBy(id = "sales_report_show_order_statuses")
    WebElement OrderStatusLink;
    @FindBy(id="sales_report_from")
    WebElement dateFromField;
    @FindBy(id="sales_report_to")
    WebElement dateToField;

    @FindAll(
            @FindBy(xpath = "//div[@id=\"page_content\"]//table//tbody//tr")
    )
    List<WebElement> reportsList;
    @FindBy(css = "img#sales_report_from_trig")
    WebElement calendarFrom;

    @FindBy(css = "img#sales_report_to_trig")
    WebElement calendarTo;

@FindBy(xpath = "(//button[@title=\"Show Report\"])[1]")
WebElement showReportButton;

    public CouponsReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        salesDashboardPage = new SalesDashboardPage(driver);
    }

    public void viewCouponsReportFunction(String dateFrom,String dateTo) {
        salesDashboardPage.clickOnCouponsLink();
        functionClass.sleep(4);
        functionClass.waitUntilElementPresent(ShowReportDropDown);
        Select select = new Select(ShowReportDropDown);
        functionClass.sleep(2);
        select.selectByVisibleText("All Websites");
        functionClass.waitUntilElementPresent(MatchPeriodSelectionDropdown);
        Select periodSelection = new Select(MatchPeriodSelectionDropdown);
        periodSelection.selectByValue("created_at_order");
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(PeriodDropdown);
        Select periodTime = new Select(PeriodDropdown);
        functionClass.sleep(1);
        periodTime.selectByValue("month");
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(dateFromField);
        dateFromField.sendKeys(dateFrom);
        functionClass.sleep(2);
        functionClass.waitUntilElementPresent(dateToField);
        dateToField.sendKeys(dateTo);
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(showReportButton);
        showReportButton.click();

    }

    public boolean verifyViewCouponsReport() {
        if (reportsList.size() >= 1) {

            return true;

        } else return false;

    }


}
