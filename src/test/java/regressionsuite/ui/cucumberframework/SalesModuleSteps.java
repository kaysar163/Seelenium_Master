package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.salesmodule.ManageCustomersPage;
import com.magentoapplication.ui.backend.salesmodule.OrdersPageSales;
import com.magentoapplication.ui.backend.salesmodule.RefundReportPage;
import com.magentoapplication.ui.backend.salesmodule.ShipmentsPage;
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
    ShipmentsPage shipmentsPage;
    RefundReportPage refundReportPage;


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
        ordersPageSales = new OrdersPageSales(driver);
        refundReportPage=new RefundReportPage(driver);
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



    @When("Sales Manager view refunds      {string}")
    public void salesManagerViewRefunds(String arg0) {refundReportPage.viewRefundsInTheReports(arg0);
    }


    @Then("Total Refunds Report table should display")
    public void totalRefundsReportTableShouldDisplay() { refundReportPage.verifyRefundsInTheReportsViewed();
    }


    @After("@SalesModuleTest")
    public void tearDown(){
        closeBrowser();
    }


}



