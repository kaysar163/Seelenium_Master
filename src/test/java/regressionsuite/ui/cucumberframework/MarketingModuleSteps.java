package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.marketingmodule.MarketingDashboardPage;
import com.magentoapplication.ui.backend.marketingmodule.ShoppingCartPriceRulePage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;
    MarketingDashboardPage marketingDashboardPage;
    ShoppingCartPriceRulePage shoppingCartPriceRulePage;

    @Before()
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin.marketingModuleLogin();

    }

    @Given("Admin user is already in the dashboard page")
    public void adminUserIsAlreadyInTheDashboardPage() {
    }

    @When("the user fills out Newsletter template information")
    public void theUserFillsOutNewsletterTemplateInformation() {
    }

    @Then("A new template should be added")
    public void aNewTemplateShouldBeAdded() {
    }

    @Given("Admin user is already on the dashboard page")
    public void adminUserIsAlreadyOnTheDashboardPage() {
        marketingDashboardPage=new MarketingDashboardPage(driver);

    }

    @When("The user fills out shopping cart pricing rule id number and rule name")
    public void theUserFillsOutShoppingCartPricingRuleIdNumberAndRuleName() {
       shoppingCartPriceRulePage.filterShoppingCartByIdAndRule();


    }


    @Then("Filtered shopping cart pricing rule should be display")
    public void filteredShoppingCartPricingRuleShouldBeDisplay() {
        shoppingCartPriceRulePage.verifyFilterShoppingCart();


    }
    @After()
    public void tearDown(){
        closeBrowser();
    }
}
