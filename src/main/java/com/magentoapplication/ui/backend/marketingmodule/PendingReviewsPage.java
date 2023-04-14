package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PendingReviewsPage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;

    public PendingReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);
    }
}
