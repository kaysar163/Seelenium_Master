package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerManagerExportCustomers {

    WebDriver driver;
    FunctionClass functionClass;
    String configFile = "testdata.properties";

    @FindBy(xpath = "//a[text()='Select All']")
    WebElement SelectAll;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportBtn;

    public CustomerManagerExportCustomers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        //actions=new Actions(driver);
    }


    public void exportCustomers() {
        functionClass.waitUntilElementPresent(SelectAll);
        SelectAll.click();
        functionClass.waitUntilElementPresent(exportBtn);
        exportBtn.click();

    }

    public boolean verifyExportCustomer() {
        if (exportBtn.isEnabled()) {
            return true;
        } else
            return false;
    }


}
