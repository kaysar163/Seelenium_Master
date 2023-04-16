package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;

public class NewsletterSubscriptionPage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;

    public NewsletterSubscriptionPage(WebDriver driver) {
        this.driver = driver;
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);
    }
}
