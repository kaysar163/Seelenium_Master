package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.salesmodule.ManageCustomersPage;
import com.magentoapplication.utility.Log4j;
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

    Log4j log4j=new Log4j();

    @Before("@SalesModuleTest")
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.marketingModuleLogin();
        log4j.testStart("---Test Started---");
    }


    @Given("Admin user is already in the dashboard page sales")
    public void adminUserIsAlreadyInTheDashboardPageSales() {
        manageCustomersPage=new ManageCustomersPage(driver);
    }

    @When("the user view shopping cart for customers")
    public void theUserViewShoppingCartForCustomers() {
        manageCustomersPage.viewShoppingCartForCustomers();
    }

    @Then("shopping list display")
    public void shoppingListDisplay() {
        Assert.assertTrue(manageCustomersPage.verifyViewShoppingCartViewed());
    }


    @After("@SalesModuleTest")
    public void tearDown(){
        closeBrowser();
        log4j.testStart("---Test Ended---");
    }
}
