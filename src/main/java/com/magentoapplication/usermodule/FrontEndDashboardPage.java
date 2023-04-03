package com.magentoapplication.usermodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndDashboardPage {

    WebDriver driver;

    FunctionClass functionClass;

    public FrontEndDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
    }

    @FindBy(css = ".skip-link.skip-account")
    WebElement accountLink;

    @FindBy(css = "[title='Log In']")
    WebElement loginLink;

    public void clickOnAccountLink(){
        functionClass.waitUntilElementPresent(accountLink);
        accountLink.click();
    }

    public void clickOnLoginLink(){
        functionClass.waitUntilElementPresent(loginLink);
        loginLink.click();
    }
}
