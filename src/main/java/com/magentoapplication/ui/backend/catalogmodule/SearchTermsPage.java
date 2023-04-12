package com.magentoapplication.ui.backend.catalogmodule;

import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchTermsPage {

    WebDriver driver;

    FunctionClass functionClass;

    CatalogDashboardPage catalogDashboardPage;

    public SearchTermsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }

    // Elements
    @FindBy(xpath = "(//span[contains(text(),'Add New Search Term')])[1]")

    WebElement AddNewSearchTerm;
    @FindBy( id= "query_text")

    WebElement SearchQuery;
    @FindBy(name = "search_query")
    WebElement searchQuery1;

    @FindBy(id = "store_id")

    WebElement Store;
    @FindBy(id = "synonym_for")

    WebElement SynonymFor;
    @FindBy(id = "redirect")

    WebElement RedirectURL;
    @FindBy(id = "display_in_terms")

    WebElement DisplayinSuggestedTerms;
    @FindBy(xpath = "(//span[contains(text(),'Save Search')])[1]")

    WebElement SaveSearch;
    @FindBy(xpath = "(//span[normalize-space()='You saved the search term.'])[1]")

    WebElement SuccessfulSavesMessage;

    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement searchButton;

    @FindBy(xpath = "//input[@value=\"370\"]")
    WebElement checkBox;

    @FindBy(xpath = "//a[text()=\"Edit\"]")
    WebElement editButton;

    @FindBy(xpath = "//button[@title=\"Delete Search\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//span[contains(text(),\"The search was deleted.\")]")
    WebElement successfulDeletedSearchMessage;

    public void NewSearchInfo(){
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnSearchTerms();
        functionClass.waitUntilElementPresent(AddNewSearchTerm);
        AddNewSearchTerm.click();
        functionClass.waitUntilElementPresent(SearchQuery);
        SearchQuery.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(Store);
        Select select=new Select(Store);
        select.selectByValue("28");
        functionClass.waitUntilElementPresent(SynonymFor);
        SynonymFor.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent( RedirectURL);
        RedirectURL.sendKeys(functionClass.generateFakeRedirectURL());
        functionClass.waitUntilElementPresent(DisplayinSuggestedTerms);
        Select select1=new Select(DisplayinSuggestedTerms);
        select1.selectByValue("0");
        functionClass.waitUntilElementPresent(SaveSearch);
        SaveSearch.click();
    }

    public boolean VerifyAddNewSerach(){
        functionClass.waitUntilElementPresent(SuccessfulSavesMessage);
        if(SuccessfulSavesMessage.isDisplayed()){
            return true;
        }else return false;

    }
    public  void deleteExistingSearchTerm(){
        catalogDashboardPage. clickOnCatalogLink();
        catalogDashboardPage.clickOnSearchTerms();
        //functionClass.sleep(2);
        functionClass.waitUntilElementPresent(searchQuery1);
        searchQuery1.click();
       // functionClass.sleep(2);
        searchQuery1.sendKeys("jordan air");
        functionClass.sleep(3);
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();

        //WebElement editProductName=driver.findElement (By.xpath(String.format("//tr//td[contains(text(),'%s')]//following-sibling::td//a",
                //TestHelperClassCatalog.getProductName())))
        functionClass.waitUntilElementPresent(editButton);
        editButton.click();
        functionClass.waitUntilElementPresent(deleteButton);
        deleteButton.click();
        functionClass.alertAccept();




    }
    public boolean verifyDeleteSearchFunction(){

        if (successfulDeletedSearchMessage.isDisplayed()){
            return true;
        }
        else return false;
    }



}











