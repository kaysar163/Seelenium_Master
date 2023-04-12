package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.storemodule.*;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
    public void setUp(){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.storeModuleLogin();
        manageCategoriesPage=new ManageCategoriesPage(driver);
        manageProductsPage=new ManageProductsPage(driver);
        manageStoresPage=new ManageStoresPage(driver);
        ordersPage=new OrdersPage(driver);
        orderViewPage=new OrderViewPage(driver);
        productInfoPage=new ProductInfoPage(driver);
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

    @Test(description = "Muradil")

    public void createWebsiteTest(){
        manageStoresPage.createWebsite();
        Assert.assertTrue(manageStoresPage.verifyCreateWebsite());
    }





    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
