package regressionsuite.usertest;

import com.magentoapplication.ui.frontend.usermodule.*;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
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

    @Test
    public  void billingAgreementLinkTest(){
        frontEndLoginPage.login();
        billingAgreementPage=new BillingAgreementPage(driver);
        billingAgreementPage.clickBillingAgreemnetsLink();
        Assert.assertTrue(billingAgreementPage.verifyBillingAgreementsLink());

    }
    @Test(description = "Omercan",priority = 3)
    public void checkOutOrder(){
        frontEndLoginPage.login();
        checkOutOrderPage.CheckOutOrderTest();
        Assert.assertTrue(checkOutOrderPage.verifyCheckOutOrder());

    }
    @Test(description = "ranagul",priority = 4)
    public void viewMyordersTest(){
        frontEndLoginPage.login();
        Assert.assertTrue(myDashboardPage.vieworders());
    }


    @Test(description = "User should be able to edit account information",priority = 7)
    public void editAccountInfoTest(){
        frontEndLoginPage.login();
        myDashboardPage.EditAccountInfo();
        Assert.assertTrue(myDashboardPage.VerifySuccessfullyEdit());

    }
    @Test()
    public void changePasswordTest(){
        createAnAccountPage.fillAccountRegistrationForm();
        //frontEndLoginPage.login();
        myDashboardPage.changePassword();
        myDashboardPage.verifyPasswordChanged();
    }

    @Test(priority = 6)
    public void viewMyWishListTest(){
        frontEndLoginPage.login();
        myWishListPage.clickMYWISHLISTLink();
        myWishListPage.verifyMyWishListPageIsOpened();
    }

    @Test()
    public void clickNewsletterSubscriptionLink(){
        frontEndLoginPage.login();
        newsletterSubscriptionPage.clickNewsletterSubscriptionLink();
        newsletterSubscriptionPage.verifySubscriptionPageIsOpened();
    }
  @Test
  public void verifyViewMyTagsTest(){
        myDashboardPage.viewMyTagsLink();
      Assert.assertTrue(  myDashboardPage.verifyViewMyTags());
  }
   @Test(priority = 5)
    public void viewDownloadable(){
        frontEndLoginPage.login();
        dowmloadablePage.clickDownloadable();
        Assert.assertTrue( dowmloadablePage.verifyMyDownloadableProducts() );
   }
   @Test
    public void viewMyproductreviewsTest(){
        frontEndLoginPage.login();
       Assert.assertTrue(myDashboardPage.myProductReviews());
   }



}

