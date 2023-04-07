package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AttributeInfoPage {
    WebDriver driver;

    FunctionClass functionClass;

    CatalogDashboardPage catalogDashboardPage;

    public AttributeInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }





}
