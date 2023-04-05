package com.magentoapplication.usermodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage {
    WebDriver driver;
    FunctionClass functionClass;

    @FindBy(xpath=" //div[@class='links']//a[text()='My Wishlist']")
    WebElement MYWISHLISTLink;
    @FindBy(css = "div.page-title.title-buttons")
    WebElement MYWISHLISTmassage;

    public MyWishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
    }

    public void clickMYWISHLISTLink() {
        functionClass.waitUntilElementPresent(MYWISHLISTLink);
        MYWISHLISTLink.click();
    }

    public boolean verifyMyWishListPageIsOpened() {
        if (MYWISHLISTmassage.isDisplayed())
            return true;
        else return false;

    }
}





