package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.catalogmodule.*;
import com.magentoapplication.utility.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CatalogModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;

    AttributeInfoPage attributeInfoPage;

    ManageAttributesPage manageAttributesPage;

    ManageCategoriesPage manageCategoriesPage;

    ManageProductsPage manageProductsPage;

    ProductInfoPage productInfoPage;

    SearchTermsPage searchTermsPage;



    @BeforeClass
    public void setUp(ITestContext context){
        setupBrowserBackEnd();
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.catalogModuleLogin();
        attributeInfoPage=new AttributeInfoPage(driver);
        manageAttributesPage=new ManageAttributesPage(driver);
        manageCategoriesPage=new ManageCategoriesPage(driver);
        manageProductsPage=new ManageProductsPage(driver);
        productInfoPage=new ProductInfoPage(driver);
        searchTermsPage=new SearchTermsPage(driver);
    }



    @AfterClass
    public void tearDown(){
        closeBrowser();
    }

}
