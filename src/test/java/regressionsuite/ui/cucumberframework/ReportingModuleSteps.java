package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.reportingmodule.CustomersPage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ReportingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;

    CustomersPage customersPage;

    @Before("@SalesModuleTest")
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.marketingModuleLogin();
        customersPage=new CustomersPage(driver);

    }

    @Given("Admin user is already in the dashboard page reporting")
    public void adminUserIsAlreadyInTheDashboardPageReporting() {
        customersPage=new CustomersPage(driver);
    }

    @When("the user views")
    public void theUserViews() {
        customersPage.verifyViewsCustomersReport();
    }

    @Then("the user sees customers tags")
    public void theUserSeesCustomersTags() {
        Assert.assertTrue(customersPage.verifyViewsCustomersReport());
    }

    @After("@SalesModuleTest")
    public void tearDown(){
        closeBrowser();
    }

}
