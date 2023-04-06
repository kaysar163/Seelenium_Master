package com.magentoapplication.ui.backend.customersmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersManagerPage {
    WebDriver driver;
    FunctionClass functionClass;
    CustomersManagerPage customersManagerPage;
    public CustomersManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        customersManagerPage=new CustomersManagerPage(driver);
        functionClass=new FunctionClass(driver);
    }
    @FindBy(id = "customerGrid_filter_email")
    WebElement emailField;
    @FindBy(xpath = "//button[@id='id_eedfc4fe8ee6148c23f41a3d0c470b52']//span//span//span[contains(text(),'Search')]")
    WebElement searchButton;

    public void CustomersManagerTest(){
        functionClass.waitUntilElementPresent(emailField);
        emailField.sendKeys(functionClass.generateFakeEmail());
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
    }
}
