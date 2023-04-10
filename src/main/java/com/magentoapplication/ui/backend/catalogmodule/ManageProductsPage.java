package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsPage {

    WebDriver driver;

    FunctionClass functionClass;

    CatalogDashboardPage catalogDashboardPage;

    public ManageProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }


    // Elements

    @FindBy(xpath ="//span[text()='Catalog']" )
    WebElement Cataloglink;

    @FindBy(xpath ="//span[text()='Manage Products']" )
    WebElement ManageProductslink;

    @FindBy(id="productGrid_product_filter_name")
    WebElement namefield;

    @FindBy(id="id_13dac701a91cfeac9a4c2d96ac74dc16")
    WebElement Searchbutton;

    @FindBy(xpath = "//tr[@class=\"even pointer\"]//td[3]")
    WebElement productnamerow;

    @FindBy(id = "id_c14232bc8e83f6022184e2887b6f8641")
    WebElement Deletebutton;

    @FindBy(xpath = "//span[text()='The product has been deleted.']")
    WebElement deletesuccessfulmessage;



    // Methods
   public void deleteproduct(){
       Actions actions=new Actions(driver);
       actions.moveToElement(catalogDashboardPage.catalogLink).moveToElement(catalogDashboardPage.manageProductsLink).click().build().perform();
       namefield.sendKeys("celalettin");
       functionClass.sleep(2);
       functionClass.waitUntilElementPresent(Searchbutton);
       Searchbutton.click();
       functionClass.waitUntilElementPresent(productnamerow);
       productnamerow.click();
       functionClass.waitUntilElementPresent(Deletebutton);
       Deletebutton.click();
       Alert alert=driver.switchTo().alert();
       alert.accept();
       functionClass.waitUntilElementPresent(deletesuccessfulmessage);


       }


       public boolean verifydeletedproduct(){
       if (deletesuccessfulmessage.getText().equals("The product has been deleted."))
           return true;
       else
           return false;
       }

}
