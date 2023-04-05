package regressionsuite.usertest;

import com.magentoapplication.usermodule.*;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

public class FrontEndTestRunner extends TestBase{
    FrontEndLoginPage frontEndLoginPage;

    CreateAnAccountPage createAnAccountPage;
    NewsletterSubscriptionPage newsletterSubscriptionPage;

    MyDashboardPage myDashboardPage;
    AddProductsToShoppingCart addProductsToShoppingCart;
    MyWishListPage myWishListPage;
    CheckOutOrderPage checkOutOrderPage;

    @BeforeClass
    public void setUp() {
        setupBrowserFrontEnd();
        frontEndLoginPage = new FrontEndLoginPage(driver);
        createAnAccountPage=new CreateAnAccountPage(driver);
        newsletterSubscriptionPage=new NewsletterSubscriptionPage(driver);
        myDashboardPage=new MyDashboardPage(driver);
        myWishListPage=new MyWishListPage(driver);
        checkOutOrderPage=new CheckOutOrderPage(driver);
    }

    @Test(priority =1)
    public void login() {

        frontEndLoginPage.login();
    }

    @Test(description = "kaysar",priority =2 )
    public void CreateAnAccount(){
        createAnAccountPage.fillAccountRegistrationForm();
        createAnAccountPage.verifyCreateAnAccountSuccessful();

    }
    @Test(description = "muyesser",priority = 3)
    public  void addShoppingCartTest(){
        addProductsToShoppingCart=new AddProductsToShoppingCart(driver);
        addProductsToShoppingCart.addToShoppingCart();
        addProductsToShoppingCart.verification();
    }
    @Test()
    public void checkOutOrder(){
        checkOutOrderPage.CheckOutOrderTest();
        Assert.assertTrue(checkOutOrderPage.verifyCheckOutOrder());

    }

    @Test(description = "User should be able to edit account information")
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

    @Test()
    public void viewMyWishListTest(){
        frontEndLoginPage.login();
        myWishListPage.clickMYWISHLISTLink();
        myWishListPage.verifyMyWishListPageIsOpened();
    }

    @Test()
    public void clickNewsletterSubscriptionLink(){
        newsletterSubscriptionPage.clickNewsletterSubscriptionLink();
        newsletterSubscriptionPage.verifySubscriptionPageIsOpened();
    }
  @Test
  public void verifyViewMyTagsTest(){
        myDashboardPage.viewMyTagsLink();
      Assert.assertTrue(  myDashboardPage.verifyViewMyTags());
  }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}

