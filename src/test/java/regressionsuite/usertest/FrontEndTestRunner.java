package regressionsuite.usertest;

import com.magentoapplication.ui.frontend.usermodule.*;
import com.magentoapplication.utility.TestBase;
import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrontEndTestRunner extends TestBase{
    FrontEndLoginPage frontEndLoginPage;

    CreateAnAccountPage createAnAccountPage;
    NewsletterSubscriptionPage newsletterSubscriptionPage;

    MyDashboardPage myDashboardPage;
    AddProductsToShoppingCart addProductsToShoppingCart;
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
        addProductsToShoppingCart=new AddProductsToShoppingCart(driver);
        dowmloadablePage=new DowmloadablePage(driver);
        frontEndDashboardPage=new FrontEndDashboardPage(driver);

    }

    @Test(priority =1,enabled = false)
    public void login() {

        frontEndLoginPage.login();
    }

    @Test(description = "kaysar",priority =1 )
    public void CreateAnAccount(){
        createAnAccountPage.fillAccountRegistrationForm();
        createAnAccountPage.verifyCreateAnAccountSuccessful();

    }
    @Test(description = "muyesser",priority = 2)
    public  void addShoppingCartTest(){
        addProductsToShoppingCart=new AddProductsToShoppingCart(driver);
        addProductsToShoppingCart.addToShoppingCart();
        Assert.assertTrue(addProductsToShoppingCart.verification());
    }

    @Test(priority = 11)
    public  void billingAgreementLinkTest(){
        //frontEndLoginPage.login();
        billingAgreementPage=new BillingAgreementPage(driver);
        billingAgreementPage.clickBillingAgreemnetsLink();
        Assert.assertTrue(billingAgreementPage.verifyBillingAgreementsLink());

    }
    @Test(description = "Omercan",priority = 3,dependsOnMethods = "addShoppingCartTest")
    public void checkOutOrder(){
        //frontEndLoginPage.login();
        checkOutOrderPage.CheckOutOrderTest();
        Assert.assertTrue(checkOutOrderPage.verifyCheckOutOrder());

    }
    @Test(description = "ranagul",priority = 4)
    public void viewMyordersTest(){
        frontEndDashboardPage.clickOnAccountLink();
        frontEndDashboardPage.clickOnMyAccountLink();
        //frontEndLoginPage.login();
        Assert.assertTrue(myDashboardPage.vieworders());
    }


    @Test(description = "User should be able to edit account information",priority = 7)
    public void editAccountInfoTest(){
        //frontEndLoginPage.login();
        myDashboardPage.EditAccountInfo();
        Assert.assertTrue(myDashboardPage.VerifySuccessfullyEdit());

    }
    @Test(priority = 8)
    public void changePasswordTest(){
        //createAnAccountPage.fillAccountRegistrationForm();
        //frontEndLoginPage.login();
        myDashboardPage.changePassword();
        Assert.assertTrue(myDashboardPage.verifyPasswordChanged());
    }

    @Test(priority = 6)
    public void viewMyWishListTest(){
        //frontEndLoginPage.login();
        myWishListPage.clickMYWISHLISTLink();
        myWishListPage.verifyMyWishListPageIsOpened();
    }

    @Test(priority = 10,enabled = false)
    public void clickNewsletterSubscriptionLink(){
        //frontEndLoginPage.login();
        //newsletterSubscriptionPage.clickNewsletterSubscriptionLink();
        newsletterSubscriptionPage.verifySubscriptionPageIsOpened();
    }
  @Test(priority = 12)
  public void verifyViewMyTagsTest(){
        myDashboardPage.viewMyTagsLink();
      Assert.assertTrue(  myDashboardPage.verifyViewMyTags());
  }
   @Test(priority = 5)
    public void viewDownloadable(){
        //frontEndLoginPage.login();
        dowmloadablePage.clickDownloadable();
        Assert.assertTrue( dowmloadablePage.verifyMyDownloadableProducts() );
   }
   @Test(priority = 9)
    public void viewMyproductreviewsTest(){
        //frontEndLoginPage.login();
       Assert.assertTrue(myDashboardPage.myProductReviews());
   }

   @AfterClass
    public void tearDown(){
        closeBrowser();
   }

}

