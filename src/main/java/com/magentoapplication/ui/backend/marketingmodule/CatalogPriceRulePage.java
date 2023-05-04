package com.magentoapplication.ui.backend.marketingmodule;

import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CatalogPriceRulePage {

    WebDriver driver;

    FunctionClass functionClass;

    MarketingDashboardPage marketingDashboardPage;
    
    Actions actions;
    
    static final String config="testdatafolder/testdata.properties";
    String c_RuleId= ApplicationConfig.readFromConfigProperties(config,"catalogRuleID");
    String c_RuleName = ApplicationConfig.readFromConfigProperties(config,"catalogRuleName");
    
    public CatalogPriceRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionClass=new FunctionClass(driver);
        marketingDashboardPage=new MarketingDashboardPage(driver);
        actions=new Actions(driver);
    }

    @FindBy(xpath ="(//button[@title='Add New Rule'])[1]")
    WebElement AddNewRuleButton;
    @FindBy(id="rule_name")
    WebElement RulleNameField;
    @FindBy(id="rule_description")
    WebElement DescriptionField;
    @FindBy(id="rule_is_active")
    WebElement StatusDropDown;
    @FindBy(id ="rule_website_ids")
    WebElement WebsitesLink;
    @FindBy(id="rule_customer_group_ids")
    WebElement CustomerGroupsLink;
    @FindBy(id="rule_from_date")
    WebElement FromeDateField;
    @FindBy(id="rule_from_date")
    WebElement ToDate;
    @FindBy(id="rule_sort_order")
    WebElement Priority;
    @FindBy(id="promo_catalog_edit_tabs_actions_section")
    WebElement ActionsButton;
    @FindBy(id="rule_discount_amount")
    WebElement DiscountAmount;
    @FindBy(xpath="(//button[@title='Save'])[1]")
    WebElement saveButton;
    @FindBy(xpath="//span[contains(text(),'The rule has been saved.')]")
    WebElement SuccessMessage;

    //meryem
    @FindBy(css = "#promo_catalog_grid_filter_name")
    WebElement ruleNameField;
    @FindBy(xpath = "//td[contains(text(),\"team1\")]")
    WebElement team1;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(css = "#rule_description")
    WebElement descriptionField;
    @FindBy(css = "#rule_website_ids")
    WebElement websites;
    @FindBy(xpath = "//span[contains(text(),\"Save and Apply\")]")
    WebElement saveAndApplyButton;
    @FindBy(xpath = "//span[contains(text(),\"The rule has been saved.\")]")
    WebElement successMassage;
    
    //Toghraq
    @FindBy(xpath = "//span[contains(text(),'Promotions')]")
    WebElement promotionsTab;
    @FindBy(xpath = "//span[contains(text(),'Catalog Price Rules')]")
    WebElement catalogPriceRule;
    @FindBy(xpath = "//input[@name='rule_id']")
    WebElement ctlgRuleId;
    @FindBy(xpath = "//input[@name='name']")
    WebElement cRuleName;
    @FindBy(xpath ="//td[contains(text(),'298')]")
    WebElement catalogRuleIdAppeared;

    public void addNewCatalogPriceRule(){

        marketingDashboardPage.clickOnCatalogPriceRuleLink();
        functionClass.waitUntilElementPresent(AddNewRuleButton);
        AddNewRuleButton.click();
        TestHelperMarketing.setRuleName(functionClass.generateFakeName());
        RulleNameField.sendKeys(TestHelperMarketing.getRuleName());
        functionClass.waitUntilElementPresent(DescriptionField);
        DescriptionField.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(StatusDropDown);
        StatusDropDown.click();
        Select select = new Select(StatusDropDown);
        select.selectByValue("1");
        functionClass.waitUntilElementPresent(WebsitesLink);
        Select select1 = new Select(WebsitesLink);
        select1.selectByValue("452");
        functionClass.waitUntilElementPresent(CustomerGroupsLink);
        Select select2= new Select(CustomerGroupsLink);
        select2.selectByValue("264");
        functionClass.waitUntilElementPresent(FromeDateField);
        FromeDateField.sendKeys(functionClass.currentDate());
        functionClass.waitUntilElementPresent(ToDate);
        ToDate.sendKeys(functionClass.currentDate());
        functionClass.waitUntilElementPresent(Priority);
        Priority.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent( ActionsButton);
        functionClass.sleep(2);
        actions.click(ActionsButton).build().perform();
        functionClass.waitUntilElementPresent( DiscountAmount);
        DiscountAmount.sendKeys(functionClass.generateZipCode());
        functionClass.waitUntilElementPresent(saveButton);
        saveButton.click();
    }
    public boolean VerifyAddCatalogPriceRule(){
        functionClass.waitUntilElementPresent(SuccessMessage);
        if (SuccessMessage.isDisplayed()) {
            return true;
        } else return false;
    }

    public void update(){
        marketingDashboardPage.clickOnCatalogPriceRuleLink();
        functionClass.waitUntilElementPresent(ruleNameField);
        ruleNameField.sendKeys(TestHelperMarketing.getRuleName());
        functionClass.waitUntilElementPresent(searchButton);
        searchButton.click();
     //   team1.click();
        WebElement editButton=driver.findElement
                (By.xpath(String.format("//td[contains(text(),\"%s\")]",
                        TestHelperMarketing.getRuleName())));
        editButton.click();
        descriptionField.clear();
        descriptionField.sendKeys(functionClass.generateFakeName());
        functionClass.waitUntilElementPresent(websites);
        Select select=new Select(websites);
        select.selectByValue("457");
        functionClass.waitUntilElementPresent(saveAndApplyButton);
        saveAndApplyButton.click();
    }
    public boolean verify(){
        functionClass.waitUntilElementPresent(successMassage);
        successMassage.isDisplayed();
        return true;
    }
    public void searchCatalogPriceRule(){
        functionClass.waitUntilElementPresent(promotionsTab);
        actions.moveToElement(promotionsTab).perform();
        functionClass.waitUntilElementPresent(catalogPriceRule);
        catalogPriceRule.click();
        functionClass.waitUntilElementPresent(ctlgRuleId);
        ctlgRuleId.sendKeys(c_RuleId);
        functionClass.waitUntilElementPresent(cRuleName);
        cRuleName.sendKeys(c_RuleName);
        searchButton.click();
    }
    public boolean searchedCatalogRuleAppeared(){
        if(catalogRuleIdAppeared.isDisplayed())
            return true;
        else
            return false;
    }
    
}
