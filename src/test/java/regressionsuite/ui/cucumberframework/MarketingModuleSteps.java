package regressionsuite.ui.cucumberframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.marketingmodule.NewsletterSubscriptionPage;
import com.magentoapplication.ui.backend.marketingmodule.NewsletterTemplatePage;
import com.magentoapplication.ui.backend.marketingmodule.PendingReviewsPage;
import com.magentoapplication.ui.backend.marketingmodule.ShoppingCartPriceRulePage;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MarketingModuleSteps extends TestBase {

    BackEndLogin backEndLogin;

    NewsletterTemplatePage newsletterTemplatePage;
    ShoppingCartPriceRulePage shoppingCartPriceRulePage;
    PendingReviewsPage pendingReviewsPage;
    NewsletterSubscriptionPage newsletterSubscriptionPage;


    @Before()
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.marketingModuleLogin();

    }

    @Given("Admin user is already in the dashboard page")
    public void adminUserIsAlreadyInTheDashboardPage() {
        newsletterTemplatePage=new NewsletterTemplatePage(driver);
        shoppingCartPriceRulePage=new ShoppingCartPriceRulePage(driver);
        pendingReviewsPage=new PendingReviewsPage(driver);
        newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);


    }

    @When("the user fills out Newsletter template information")
    public void theUserFillsOutNewsletterTemplateInformation() {
        newsletterTemplatePage.addNewNewsletterTemplate();
    }

    @Then("A new template should be added")
    public void aNewTemplateShouldBeAdded() {
        newsletterTemplatePage.verifyNewTemplateAdded();
    }


    @When("the user edits newsletter template information")
    public void theUserEditsNewsletterTemplateInformation() {
        newsletterTemplatePage.editNewNewsletterTemplate();
    }

    @Then("the newsletter template should be edited")
    public void theNewsletterTemplateShouldBeEdited() {
        newsletterTemplatePage.verifyTemplateEdited();
    }

    @When("user update pending reviews")
    public void userUpdatePendingReviews() {
        pendingReviewsPage.managerUpdatePendingReviews();

    }

    @Then("pending reviews should be updated")
    public void pendingReviewsShouldBeUpdated() {
        pendingReviewsPage.verifyUpdatePendingReviews();
    }



    @When("The user fills out shopping cart pricing rule id number and rule name")
    public void theUserFillsOutShoppingCartPricingRuleIdNumberAndRuleName() {
        shoppingCartPriceRulePage.filterShoppingCartByIdAndRule();
    }

    @Then("Filtered shopping cart pricing rule should be display")
    public void filteredShoppingCartPricingRuleShouldBeDisplay() {
        shoppingCartPriceRulePage.verifyFilterShoppingCart();
    }

    @When("the user enter the Newsletter subscribers page")
    public void theUserEnterTheNewsletterSubscribersPage() {
        newsletterSubscriptionPage.viewNewsLetterSubscribers();
    }

    @Then("Newsletter subscribers should be viewed.")
    public void newsletterSubscribersShouldBeViewed() {
        // newsletterSubscriptionPage.verifyViewNewsletterSubscribers();
        Assert.assertTrue(newsletterSubscriptionPage.verifyViewNewsletterSubscribers());
    }
    @After()
    public void tearDown(){
        closeBrowser();
    }
}
