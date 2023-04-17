package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.storemodule.*;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;


@Listeners(TestListener.class)
public class StoreModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;

    ManageCategoriesPage manageCategoriesPage;

    ManageProductsPage manageProductsPage;

    ManageStoresPage manageStoresPage;

    OrdersPage ordersPage;

    OrderViewPage orderViewPage;
    ProductInfoPage productInfoPage;

    @BeforeClass
    public void setUp(ITestContext context) {
        setupBrowserBackEnd();
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.storeModuleLogin();
        manageCategoriesPage = new ManageCategoriesPage(driver);
        manageProductsPage = new ManageProductsPage(driver);
        manageStoresPage = new ManageStoresPage(driver);
        ordersPage = new OrdersPage(driver);
        orderViewPage = new OrderViewPage(driver);
        productInfoPage = new ProductInfoPage(driver);
        context.setAttribute("driver", driver);
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
    @Test(description = "Omercan",dependsOnMethods = "addNewOrderTest",priority = 3)
    public void cancelOrdersTest(){
        ordersPage.cancelOrders();
        Assert.assertTrue(ordersPage.cancelOrdersSuccessful());
    }
    @Test(description = "kaysar",priority = 4)
    public void addProductTest(){
        manageProductsPage.addproduct();
        Assert.assertTrue( manageProductsPage.VerifySuccessmessage());
    }
    @Test(description = "Muyesser",dependsOnMethods = "addProductTest",priority = 7)
    public  void editProductTest(){
        manageProductsPage.editProduct();
        Assert.assertTrue(manageProductsPage.verifyEditProduct());
    }

    @Test(description = "Fazilet",dependsOnMethods = "editProductTest",priority = 8)
    public void deleteProductTest() {
        manageProductsPage.deleteProductTest();
        Assert.assertTrue(manageProductsPage.verifyDeletedProductTest());

    }
    @Test(description = "Muyesser",dependsOnMethods = "addProductTest",priority = 5)
    public void addProductCategoryTest(){
        manageCategoriesPage.addProductCategoriesFunction();
        Assert.assertTrue(manageCategoriesPage.verifyAddProductCategory());
    }
    @Test(description = "Memet",dependsOnMethods = {"addProductCategoryTest","addProductTest"},priority = 6)
    public void updateProductCategoryTest(){
        productInfoPage.updateProductCategories();
        Assert.assertTrue(productInfoPage.productCategoryUpdatedSuccessfully());
    }

    @Test(description = "Muradil",priority = 9)

    public void createWebsiteTest(){
        manageStoresPage.createWebsite();
        Assert.assertTrue(manageStoresPage.verifyCreateWebsite());
    }

    @Test(description = "Toghraq",priority = 10)
    public void editWebsiteTest(){
        manageStoresPage.editWebsite();
        Assert.assertTrue(manageStoresPage.webSiteSavedMessage());
    }

    @Test(description = "rizvangul",dependsOnMethods = {"createWebsiteTest"},priority = 11)
    public void deleteWebsiteTest() {
        manageStoresPage.deleteWebsite( );
        Assert.assertTrue( manageStoresPage.verifyDeleteWebsite( ) );
    }

    @Test(description = "Gulzar",priority = 12)
    public void createStoreTest(){
        manageStoresPage.createStore();
        Assert.assertTrue(manageStoresPage.verifyCreateStore());
    }
    @Test(description = "ranagul",dependsOnMethods = "createStoreTest",priority = 13)
    public void editStoreTest(){
        manageStoresPage.editStore();
        Assert.assertTrue(manageStoresPage.verifyeditstore());
    }
    @Test(description = "Memet",dependsOnMethods = "createStoreTest",priority = 14)
    public void deleteStoreTest(){
        manageStoresPage.deleteStore();
        Assert.assertTrue(manageStoresPage.storeDeletedSuccessfully());
    }


    @Test(description = "Abdusattar",priority = 15)
    public void addStoreViewTest(){
        orderViewPage.addStoreView();
        Assert.assertTrue(orderViewPage.verifyNewStoreViewAdded());
    }

    @Test(description = "Abdusattar",dependsOnMethods = "addStoreViewTest",priority = 16)
    public void editStoreViewTest(){
        orderViewPage.editStoreView();
        Assert.assertTrue(orderViewPage.verifyStoreViewEdited());
    }


    @Test(description = "Fazilet",priority = 17)
    public void viewAllStoresTest(){
        manageStoresPage.viewAllStores();
        Assert.assertTrue(manageStoresPage.verifyViewedAllStores());
    }



    @AfterClass
    public void tearDown(){
        //closeBrowser();
    }
}

