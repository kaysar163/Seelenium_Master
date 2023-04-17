package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesModuleSteps extends TestBase {

    BackEndLogin backEndLogin;

    @Before()
//    public void setUp(){
//        setupBrowserBackEnd();
//        backEndLogin =new BackEndLogin(driver);
//        backEndLogin.marketingModuleLogin();
//
//    }

    @When("the user view shopping cart for customers")
    public void theUserViewShoppingCartForCustomers() {

    }

    @Then("shopping list display")
    public void shoppingListDisplay() {
    }

//    @After
//    public void tearDown(){
//        closeBrowser();
//    }
}
