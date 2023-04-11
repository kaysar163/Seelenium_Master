package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

    WebDriver driver;

    FunctionClass functionClass;

    CatalogDashboardPage catalogDashboardPage;

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }

    // Elements












    // Methods






}
