package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.frontend.usermodule.*;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrontEndTestRunner extends TestBase{
    FrontEndLoginPage frontEndLoginPage;

    CreateAnAccountPage createAnAccountPage;
    NewsletterSubscriptionPage newsletterSubscriptionPage;

    MyDashboardPage myDashboardPage;
    ShoppingCartPage addProductsToShoppingCart;
    MyWishListPage myWishListPage;
    CheckOutOrderPage checkOutOrderPage;
    BillingAgreementPage billingAgreementPage;
    DowmloadablePage dowmloadablePage;

    FrontEndDashboardPage frontEndDashboardPage;

    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);
        myDashboardPage=new MyDashboardPage(driver);
        myWishListPage=new MyWishListPage(driver);
        checkOutOrderPage=new CheckOutOrderPage(driver);
        addProductsToShoppingCart=new ShoppingCartPage(driver);
        dowmloadablePage=new DowmloadablePage(driver);
        frontEndDashboardPage=new FrontEndDashboardPage(driver);
    }

    @Test(priority =1,enabled = false)
    public void login() {

        frontEndLoginPage.login();
    }

    @Test(description = "kaysar",priority =1)
    public void CreateAnAccount(){
        createAnAccountPage.fillAccountRegistrationForm();
        createAnAccountPage.verifyCreateAnAccountSuccessful();

    }
    @Test(description = "muyesser",priority = 2)
    public  void addShoppingCartTest(){
        addProductsToShoppingCart=new ShoppingCartPage(driver);
        addProductsToShoppingCart.addToShoppingCart();
        Assert.assertTrue(addProductsToShoppingCart.verification());
        
    }

    @Test(priority = 3)
    public void updateShoppingCartTest() {
        addProductsToShoppingCart.updateShoppingCart();
        Assert.assertTrue(addProductsToShoppingCart.updateVerificationMessage());
    }

    @Test(description = "Omercan",priority = 4,dependsOnMethods = "addShoppingCartTest")
    public void checkOutOrder(){
        //frontEndLoginPage.login();
        checkOutOrderPage.CheckOutOrderTest();
        Assert.assertTrue(checkOutOrderPage.verifyCheckOutOrder());

    }


    @Test(description = "ranagul",priority = 5)
    public void viewMyordersTest(){
        frontEndDashboardPage.clickOnAccountLink();
        frontEndDashboardPage.clickOnMyAccountLink();
        Assert.assertTrue(myDashboardPage.vieworders());
    }

    @Test(priority = 6)
    public void viewMyWishListTest(){
        myWishListPage.clickMYWISHLISTLink();
        myWishListPage.verifyMyWishListPageIsOpened();
    }

    @Test(priority = 7)
    public void viewDownloadable(){
        //frontEndLoginPage.login();
        dowmloadablePage.clickDownloadable();
        Assert.assertTrue( dowmloadablePage.verifyMyDownloadableProducts() );
    }

    @Test(priority = 8)
    public void changePasswordTest(){
        myDashboardPage.changePassword();
        Assert.assertTrue(myDashboardPage.verifyPasswordChanged());
    }

    @Test(priority = 9,enabled = false)
    public void viewMyproductreviewsTest(){
        Assert.assertTrue(myDashboardPage.myProductReviews());
    }

    @Test(priority = 10)
    public void billingAgreementLinkTest(){
        billingAgreementPage=new BillingAgreementPage(driver);
        billingAgreementPage.clickBillingAgreemnetsLink();
        Assert.assertTrue(billingAgreementPage.verifyBillingAgreementsLink());

    }

    @Test(description = "User should be able to edit account information",priority = 11)
    public void editAccountInfoTest(){
        myDashboardPage.EditAccountInfo();
        Assert.assertTrue(myDashboardPage.VerifySuccessfullyEdit());

    }

    @Test(priority = 14)
    public void clickNewsletterSubscriptionLink(){
        myDashboardPage.clickNewsletterSubscriptionLink();
        newsletterSubscriptionPage.verifySubscriptionPageIsOpened();
    }

  @Test(priority = 12)
  public void verifyViewMyTagsTest(){
        myDashboardPage.viewMyTagsLink();
      Assert.assertTrue(  myDashboardPage.verifyViewMyTags());
  }

    @Test(priority = 13)
    public void viewMyAccountInfo(){
        Assert.assertTrue(myDashboardPage.viewAccountInfo());
    }
   
   @AfterClass
    public void tearDown(){
       // closeBrowser();
   }

}

