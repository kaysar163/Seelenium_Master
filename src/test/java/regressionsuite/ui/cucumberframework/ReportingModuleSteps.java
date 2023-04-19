package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;



    @Before("@SalesModuleTest")
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.marketingModuleLogin();

    }

    @When("the user views")
    public void theUserViews() {

    }

    @Then("the user sees customers tags")
    public void theUserSeesCustomersTags() {
    }

    @After("@SalesModuleTest")
    public void tearDown(){
        closeBrowser();
    }

}
