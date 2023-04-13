package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.catalogmodule.*;
import com.magentoapplication.ui.backend.storemodule.ProductInfoPage;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CatalogModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;

    AttributeInfoPage attributeInfoPage;

    ManageAttributesPage manageAttributesPage;

    ManageCategoriesPage manageCategoriesPage;

    ManageProductsPage manageProductsPage;

    ProductInfoPage productInfoPage;

    SearchTermsPage searchTermsPage;

    CatalogDashboardPage catalogDashboardPage;



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
        catalogDashboardPage=new CatalogDashboardPage(driver);
    }
    @Test(description = "kaysar", priority = 1)
    public void AddRootCategoriesTest() {
        manageCategoriesPage.fillCategoryInformationAndSave();
        Assert.assertTrue(manageCategoriesPage.VerifyAddCatogories());
    }
    @Test(description = "Memet")
    public void subCatDeleteTest(){
        manageCategoriesPage.subCatDelete();
        Assert.assertTrue(manageCategoriesPage.subCatDeleteSuccessful());
    }

    @Test(description = "kaysar")
    public void AddNewSeachTermTest() {
        searchTermsPage.NewSearchInfo();
        Assert.assertTrue( searchTermsPage.VerifyAddNewSerach());


    }
    @Test(description = "Muyesser",dependsOnMethods = "AddNewSeachTermTest")
    public void deleteExistingSearchTermTest(){
        searchTermsPage.deleteExistingSearchTerm();
        Assert.assertTrue(searchTermsPage.verifyDeleteSearchFunction());
    }

    @Test(description = "abdusattar")
    public void addSubCategory(){
        manageCategoriesPage.addSubCategory();
        Assert.assertTrue(manageCategoriesPage.verifyAddSubCategory());
    }
    @Test(description = "muyesser",dependsOnMethods = "addSubCategory")
    public void editSubCategoryTest(){
        manageCategoriesPage.editSubCategory();
        Assert.assertTrue(manageCategoriesPage.verifyEditSubCategory());
    }


    @Test(description = "rizvangul")
    public void addProductTest(){
        manageProductsPage.addProduct();
        Assert.assertTrue(manageProductsPage.verifyAddProduct());

    }

    @Test(description = "muradil")
    public void filterProductsInTheCategoryProductsTabTest(){
        manageCategoriesPage.filterProductsInTheCategoryProductsTab();
        Assert.assertTrue(manageCategoriesPage.verifyFilterProductsInTheCategoryProductsTab());
    }


    @Test(description = "rizvangul")
    public void editProductTest(){
        manageProductsPage.editProduct();
        Assert.assertTrue(manageProductsPage.verifyEditProduct());

    }
    
    @Test(description = "Toghraq")
    public void addAttributeUnderCatalogTest() {
        manageAttributesPage.addAttributeUnderCatalog();
        Assert.assertTrue(manageAttributesPage.attributeSaveMessage());
    }
    
    @Test(description = "muyesser",dependsOnMethods = "AddNewSeachTermTest")
    public void deleteSearchTest(){
        searchTermsPage.deleteExistingSearchTerm();
        Assert.assertTrue(searchTermsPage.verifyDeleteSearchFunction());
    }
    @Test(description = "Gülzar",dependsOnMethods = "AddNewSeachTermTest")
    public void filterExistingSearchTermTestt(){
        searchTermsPage.filterExistingSearchTermTest();
        Assert.assertTrue(searchTermsPage.verifyFilterTermTest());
    }

    @Test(description = "renagul")
    public void viewCategoriesTest(){
        Assert.assertTrue(manageCategoriesPage.viewCategoryProducts());
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }


}

