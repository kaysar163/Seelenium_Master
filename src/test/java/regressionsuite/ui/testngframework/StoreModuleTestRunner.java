package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.storemodule.*;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import javax.security.auth.spi.LoginModule;

public class StoreModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;

    ManageCategoriesPage manageCategoriesPage;

    ManageProductsPage manageProductsPage;

    ManageStoresPage manageStoresPage;

    OrdersPage ordersPage;

    OrderViewPage orderViewPage;
    ProductInfoPage productInfoPage;

    @BeforeClass
    public void setUp() {
        setupBrowserBackEnd();
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.storeModuleLogin();
        manageCategoriesPage = new ManageCategoriesPage(driver);
        manageProductsPage = new ManageProductsPage(driver);
        manageStoresPage = new ManageStoresPage(driver);
        ordersPage = new OrdersPage(driver);
        orderViewPage = new OrderViewPage(driver);
        productInfoPage = new ProductInfoPage(driver);
    }
    @Test(description = "kaysar")
    @Ignore
    public void addProductTest(){
        manageProductsPage.addproductcategories ();
        Assert.assertTrue( manageProductsPage.VerifySuccessmessage());
    }
    @Test(description = "Memet")
    @Ignore
    public void updateProductCategoryTest(){
        productInfoPage.updateProductCategories();
        Assert.assertTrue(productInfoPage.productCategoryUpdatedSuccessfully());
    }
    @Test(description = "Memet")
    @Ignore
    public void deleteStoreTest(){
        manageStoresPage.deleteStore();
        Assert.assertTrue(manageStoresPage.storeDeletedSuccessfully());
    }

    @Test(description = "Muradil")
    @Ignore

    public void createWebsiteTest(){
        manageStoresPage.createWebsite();
        Assert.assertTrue(manageStoresPage.verifyCreateWebsite());
    }
    @Test(description = "rizvangul",dependsOnMethods = {"createWebsiteTest"})
    @Ignore
    public void deleteWebsiteTest() {
        manageStoresPage.deleteWebsite( );
        Assert.assertTrue( manageStoresPage.verifyDeleteWebsite( ) );
    }

    @Test(description = "Mirehmidi")
    @Ignore
    public void deleteCatologTest(){
        manageStoresPage.CatologPoductDeletetest ();
        Assert.assertTrue(manageStoresPage.verifyCatologPoducDelettest());
    }


    @Test(description = "rangul")
    public void editstories(){
        manageStoresPage.editStore();
        Assert.assertTrue(manageStoresPage.verifyeditstore());
    }



    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}

