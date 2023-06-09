package com.magentoapplication.ui.backend.salesmodule;

import com.magentoapplication.ui.backend.customersmodule.TestHelperClass;
import com.magentoapplication.utility.FunctionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ManageTaxRulePage {

    WebDriver driver;

    FunctionClass functionClass;

    SalesDashboardPage salesDashboardPage;

    Random random=new Random();


    public ManageTaxRulePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionClass = new FunctionClass(driver);
        salesDashboardPage = new SalesDashboardPage(driver);
    }

    @FindBy(css = "button[title='Add New Tax Rule']")
    WebElement addNewTaxRuleButton;

    @FindBy(id = "code")
    WebElement taxRulenameField;

    @FindBy(id = "tax_customer_class")
    WebElement customerTaxClassField;

    @FindBy(id = "tax_product_class")
    WebElement productTaxClassField;

    @FindBy(id = "tax_rate")
    WebElement taxRate;

    @FindBy(id = "priority")
    WebElement priority;

    @FindBy(id = "position")
    WebElement sortOrder;

    @FindBy(xpath = "(//button[@title='Save Rule'])[1]")
    WebElement saveRuleButton;

    @FindBy(xpath = "//span[contains(text(),'The tax rule has been saved.')]")
    WebElement successMessage;
    @FindBy(id = "taxRuleGrid_filter_code")
    WebElement taxRuleNameSearchField;
    @FindBy(xpath = "//button[@title=\"Search\"]")
    WebElement searchButton;
    @FindBy(xpath = "(//button[@title=\"Reset\"])[1]")
    WebElement resetButton;


    public void addAndUpdateTaxRulesFunction() {
        salesDashboardPage.clickOnManageTaxRuleLink();
        functionClass.waitUntilElementPresent(addNewTaxRuleButton);
        addNewTaxRuleButton.click();
        functionClass.waitUntilElementPresent(taxRulenameField);
        TestHelperSales.setTaxRuleName(functionClass.generateFakeName());
        taxRulenameField.sendKeys(TestHelperSales.getTaxRuleName());

        functionClass.waitUntilElementPresent(customerTaxClassField);
        Select select = new Select(driver.findElement(By.id("tax_customer_class")));
        List<WebElement> customerTax = select.getOptions();
        int customerTaxDropdown = customerTax.size();
        int index3 = random.nextInt(customerTaxDropdown);
        select.selectByIndex(index3);

        functionClass.waitUntilElementPresent(productTaxClassField);
        Select select1 = new Select(productTaxClassField);
        int index2 = random.nextInt(11);
        select1.selectByIndex(index2);

        functionClass.waitUntilElementPresent(taxRate);

        Select se = new Select(driver.findElement(By.id("tax_rate")));
        List<WebElement> l = se.getOptions();
        int droDownValueCount = l.size();
        int index = random.nextInt(droDownValueCount);
        se.selectByIndex(index);

        functionClass.waitUntilElementPresent(priority);
        priority.clear();
        priority.sendKeys("1");

        functionClass.waitUntilElementPresent(sortOrder);
        sortOrder.clear();
        sortOrder.sendKeys("1");
        functionClass.waitUntilElementPresent(saveRuleButton);
        functionClass.sleep(3);
        saveRuleButton.click();

        // update tax Rules


        functionClass.sleep(3);

        functionClass.waitUntilElementPresent(taxRuleNameSearchField);
        taxRuleNameSearchField.sendKeys(TestHelperSales.getTaxRuleName());
        searchButton.click();
        WebElement productNameClick = driver.findElement(By.xpath(String.format("//div/table/tbody/tr/td[contains(text(),'%s')]", TestHelperSales.getTaxRuleName())));
        productNameClick.click();
        functionClass.sleep(3);
        //driver.navigate().refresh();
        functionClass.waitUntilElementPresent(resetButton);
        resetButton.click();
        functionClass.sleep(2);


        functionClass.waitUntilElementPresent(taxRate);
        Select se1 = new Select(driver.findElement(By.id("tax_rate")));

        List<WebElement> l1 = se1.getOptions();
        int droDownValueCount1 = l1.size();
        int index1 = random.nextInt(droDownValueCount1);
        se1.selectByIndex(index1);
        functionClass.waitUntilElementPresent(saveRuleButton);
        functionClass.sleep(3);
        saveRuleButton.click();


    }

    public boolean verifyAddAndUpdateTaxRulesFunction() {
        functionClass.waitUntilElementPresent(successMessage);
        //if (successMessage.isDisplayed()){
        if (driver.getPageSource().contains("The tax rule has been saved.")) {
            return true;
        } else return false;


    }
}
