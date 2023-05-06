package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "(//a[text()='View'])[1]")
    WebElement viewIcon;

    @FindBy(id = "history_comment")
    WebElement commentField;
    @FindBy(xpath = "//*[text()='Submit Comment']")
    WebElement submitCommentButton;
    @FindBy(id = "history_notify")
    WebElement notifyCustomerCheckbox;

    @FindAll(
            @FindBy(xpath = "//ul[@class='note-list']//li")
    )
    List<WebElement> verifyCommentAdded;

    public void viewInvoiceAndAddCommentTest(){
        salesDashboardPage.clickOnInvoiceLink();
        functionClass.waitUntilElementPresent( viewIcon );
        viewIcon.click();
        functionClass.waitUntilElementPresent( notifyCustomerCheckbox );
        notifyCustomerCheckbox.click();
        functionClass.waitUntilElementPresent( commentField );
        commentField.sendKeys(functionClass.generateTemplate() );
        functionClass.waitUntilElementPresent( submitCommentButton );
        submitCommentButton.click();

    }
    public boolean verifyViewInvoices(){
        if (verifyCommentAdded.size() >=1)
            return true;
        else return false;
    }
}

