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
    @Test(description = "meryem",priority = 1)
    public void addNewOrderTest(){
      ordersPage.addNewOrder();
      Assert.assertTrue(ordersPage.verifyOrderCreated());
    }
    @Test(description = "meryem",dependsOnMethods ="addNewOrderTest",priority = 2)
    public void editOrderTest(){
        ordersPage.EditOrder();
        Assert.assertTrue(ordersPage.verifyEditOrder());
    }
    @Test(description = "kaysar")
    public void addProductTest(){
        manageProductsPage.addproduct();
        Assert.assertTrue( manageProductsPage.VerifySuccessmessage());
    }
    @Test(description = "Muyesser",dependsOnMethods = "addProductTest")
    public  void editProductTest(){
        manageProductsPage.editProduct();
        Assert.assertTrue(manageProductsPage.verifyEditProduct());
    }
    @Test(description = "Muyesser",dependsOnMethods = "addProductTest")
    public void addProductCategoryTest(){
        manageCategoriesPage.addProductCategoriesFunction();
        Assert.assertTrue(manageCategoriesPage.verifyAddProductCategory());
    }
    @Test(description = "Memet")
    public void updateProductCategoryTest(){
        productInfoPage.updateProductCategories();
        Assert.assertTrue(productInfoPage.productCategoryUpdatedSuccessfully());
    }
    @Test(description = "Memet")
    public void deleteStoreTest(){
        manageStoresPage.deleteStore();
        Assert.assertTrue(manageStoresPage.storeDeletedSuccessfully());
    }
    @Test(description = "Omercan",dependsOnMethods = "addNewOrderTest",priority = 3)
    public void cancelOrdersTest(){
       ordersPage.cancelOrders();
        Assert.assertTrue(ordersPage.cancelOrdersSuccessful());
    }

    @Test(description = "Muradil")

    public void createWebsiteTest(){
        manageStoresPage.createWebsite();
        Assert.assertTrue(manageStoresPage.verifyCreateWebsite());
    }
    @Test(description = "rizvangul",dependsOnMethods = {"createWebsiteTest"})
    public void deleteWebsiteTest() {
        manageStoresPage.deleteWebsite( );
        Assert.assertTrue( manageStoresPage.verifyDeleteWebsite( ) );
    }

    @Test(description = "Mirehmidi")
    public void deleteCatologTest(){
        manageStoresPage.CatologPoductDeletetest ();
        Assert.assertTrue(manageStoresPage.verifyCatologPoducDelettest());
    }

    @Test(description = "Abdusattar")
    public void addStoreViewTest(){
        orderViewPage.addStoreView();
        Assert.assertTrue(orderViewPage.verifyNewStoreViewAdded());
    }

    @Test(description = "Abdusattar",dependsOnMethods = "addStoreViewTest")
    public void editStoreViewTest(){
        orderViewPage.editStoreView();
        Assert.assertTrue(orderViewPage.verifyStoreViewEdited());
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}

