package com.magentoapplication.ui.frontend.usermodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DowmloadablePage {
    FunctionClass functionClass;
    WebDriver driver;
    String  configFile= "config-qa.properties";

    @FindBy(xpath="//*[contains(text(),'My Downloadable Products')]")
    WebElement MYDOWNLOADABLEPRODUCTS;

    @FindBy(xpath="//*[@class='my-account']/div/h1")
    WebElement MyDownloadableHeadName;


    public DowmloadablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass = new FunctionClass( driver );
        }


    public void clickDownloadable(){
        functionClass.waitUntilElementPresent( MYDOWNLOADABLEPRODUCTS );
        MYDOWNLOADABLEPRODUCTS.click();
    }
    public boolean verifyMyDownloadableProducts() {
       functionClass.waitUntilElementPresent( MyDownloadableHeadName );
        return MyDownloadableHeadName.getText().
                equalsIgnoreCase("My Downloadable Products");
    }

}

