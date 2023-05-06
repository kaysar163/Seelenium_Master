package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.salesmodule.*;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SalesModuleSteps extends TestBase {

    BackEndLogin backEndLogin;

    ManageCustomersPage manageCustomersPage;
    OrdersPageSales ordersPageSales;
    InvoicePage invoicePage;
    ShipmentsPage shipmentsPage;
    CreditMemosPage creditMemosPage;

    CouponsReportPage couponsReportPage;
    ManageTaxRulePage manageTaxRulePage;


    @Before("@SalesModuleTest")
    public void setUp() {
        setupBrowserBackEnd();
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.salesModuleLogin();


    }


    @Given("Admin user is already in the dashboard page sales")
    public void adminUserIsAlreadyInTheDashboardPageSales() {
        manageCustomersPage = new ManageCustomersPage(driver);
        shipmentsPage = new ShipmentsPage(driver);
        invoicePage = new InvoicePage( driver );
        ordersPageSales = new OrdersPageSales(driver);
        creditMemosPage=new CreditMemosPage(driver);
        couponsReportPage=new CouponsReportPage(driver);
        manageTaxRulePage=new ManageTaxRulePage(driver);

    }

    @When("the user view shopping cart for customers")
    public void theUserViewShoppingCartForCustomers() {
        manageCustomersPage.viewShoppingCartForCustomers();
    }

    @Then("shopping list display")
    public void shoppingListDisplay() {
        Assert.assertTrue(manageCustomersPage.
                verifyViewShoppingCartViewed());
    }

    //meryem
    @When("sales manager can update tracking and history information shipments")
    public void salesManagerCanUpdateTrackingAndHistoryInformationShipments() {
        shipmentsPage.updateShipmentHistory();
    }

    @Then("sales manager should be able to comments to shipments")
    public void salesManagerShouldBeAbleToCommentsToShipments() {
        Assert.assertTrue(shipmentsPage.verifyShipmentPage());

    }

    @When("the user create a new order")
    public void theUserCreateANewOrder() {
        ordersPageSales.createNewOrder();

    }

    @Then("the new order should be created")
    public void theNewOrderShouldBeCreated() {

        ordersPageSales.verifyCreateOrder();
    }

    @When("Sales Manager Update orders")
    public void salesManagerUpdateOrders() {
        ordersPageSales.UpdateOrderStorePicup();
    }

    @Then("Orders should be Updated")
    public void ordersShouldBeUpdated() {
        ordersPageSales.verifySuccessfulMessage();
    }


    @When("sales manager can view invoices on the invoices page")
    public void salesManagerCanViewInvoicesOnTheInvoicesPage() {
        invoicePage.viewInvoiceAndAddCommentTest();

    }

    @Then("sales manager should be able to view invoices")
    public void salesManagerShouldBeAbleToViewInvoices() {
        Assert.assertTrue( invoicePage.verifyViewInvoices( ) );
    }




    @When("Sales manager deletes order with in-store pickup")
    public void salesManagerDeletesOrderWithInStorePickup() {
        String orderNumber=ordersPageSales.createNewOrder();
        ordersPageSales.deleteOrder(orderNumber);

    }

    @Then("Order should be successfully deleted")
    public void orderShouldBeSuccessfullyDeleted() {
        Assert.assertTrue(ordersPageSales.deleteOrderSuccessful());
    }

    @When("Sales manager view credit memos by filters")
    public void salesManagerViewCreditMemosByFilters() {
        creditMemosPage.viewCreditMemosByFilters();
    }

    @Then("Filtered credit memos should display")
    public void filteredCreditMemosShouldDisplay() {
        creditMemosPage.verifyViewCreditMemosByFilters();

    }

    @When("manager view coupons reports between time period {string} and{string}")
    public void managerViewCouponsReportsBetweenTimePeriodAnd(String arg0, String arg1) {

        couponsReportPage.viewCouponsReportFunction(arg0,arg1);
    }

    @Then("coupons reports should display")
    public void couponsReportsShouldDisplay() {
        couponsReportPage.verifyViewCouponsReport();
    }

    @When("sales manager add and update tax rules")
    public void salesManagerAddAndUpdateTaxRules() {
        manageTaxRulePage.addAndUpdateTaxRulesFunction();
    }
    @Then("new and updated tax rules should display")
    public void newAndUpdatedTaxRulesShouldDisplay() {
        manageTaxRulePage.verifyAddAndUpdateTaxRulesFunction();
    }


    @After("@SalesModuleTest")
    public void tearDown(){
        closeBrowser();
    }
    
    
    @When("the user views complete order and add credit memo")
    public void theUserViewsCompleteOrderAndAddCreditMemo() {
        ordersPageSales.viewAndCreateCreditMemo();
        
    }
    
    @Then("the credit memo will appeared")
    public void theCreditMemoWillAppeared() {
        Assert.assertTrue(ordersPageSales.isCreditMemoCreated());
        
    }
}