package com.magentoapplication.usermodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage {
    WebDriver driver;

    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}
