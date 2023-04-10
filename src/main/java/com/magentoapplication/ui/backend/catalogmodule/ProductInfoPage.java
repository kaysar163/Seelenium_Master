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

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement cataloglink;

    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manageproductslink;

    @FindBy(id="productGrid_product_filter_name")
    WebElement namefield;

    @FindBy(id="id_13dac701a91cfeac9a4c2d96ac74dc16")
    WebElement searchbutton;

    @FindBy




    // Methods






}
