package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.catalogmodule.*;
import com.magentoapplication.ui.backend.storemodule.ProductInfoPage;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
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
        context.setAttribute("driver", driver);
    }
    @Test(description = "kaysar", priority = 1)
    public void addRootCategoriesTest() {
        manageCategoriesPage.fillCategoryInformationAndSave();
        Assert.assertTrue(manageCategoriesPage.VerifyAddCatogories());
    }

    @Test(description = "Meryem", priority = 2)
    public void editRootCategoriesTest() {
        manageCategoriesPage.editCatogoriesInfo();
        Assert.assertTrue(manageCategoriesPage.verifyEditCatogories());
    }

    @Test(description = "Omercam", priority = 3)
    public void deleteRootCategoriesTest() {
        manageCategoriesPage.deleteRootCat();
        Assert.assertTrue(manageCategoriesPage.deleteCategorySuccessful());
    }

    @Test(description = "abdusattar",dependsOnMethods ="addRootCategoriesTest",priority = 4)
    public void addSubCategory(){
        manageCategoriesPage.addSubCategory();
        Assert.assertTrue(manageCategoriesPage.verifyAddSubCategory());
    }
    @Test(description = "muyesser",priority = 5)
    public void editSubCategoryTest(){
        manageCategoriesPage.editSubCategory();
        Assert.assertTrue(manageCategoriesPage.verifyEditSubCategory());
    }

    @Test(description = "Memet",priority = 6)
    public void subCatDeleteTest(){
        manageCategoriesPage.subCatDelete();
        Assert.assertTrue(manageCategoriesPage.subCatDeleteSuccessful());
    }
    @Test(description = "rizvangul",priority = 7)
    public void addProductTest(){
        manageProductsPage.addProduct();
        Assert.assertTrue(manageProductsPage.verifyAddProduct());

    }

    @Test(description = "rizvangul",priority = 8)
    public void editProductTest(){
        manageProductsPage.editProduct();
        Assert.assertTrue(manageProductsPage.verifyEditProduct());

    }

    @Test(description = "Fazilat",priority = 9)
    public void deleteProductTest(){
        manageProductsPage.deleteproduct();
        Assert.assertTrue(manageProductsPage.verifydeletedproduct());

    }

    @Test(description = "renagul",priority = 10)
    public void viewCategoriesTest(){
        Assert.assertTrue(manageCategoriesPage.viewCategoryProducts());
    }

    @Test(description = "muradil",priority = 11)
    public void filterProductsInTheCategoryProductsTabTest(){
        manageCategoriesPage.filterProductsInTheCategoryProductsTab();
        Assert.assertTrue(manageCategoriesPage.verifyFilterProductsInTheCategoryProductsTab());
    }

    
    @Test(description = "Toghraq",priority = 16)
    public void addAttributeUnderCatalogTest() {
        manageAttributesPage.addAttributeUnderCatalog();
        Assert.assertTrue(manageAttributesPage.attributeSaveMessage());
    }

    @Test(description = "kaysar",priority = 12)
    public void addNewSeachTermTest() {
        searchTermsPage.NewSearchInfo();
        Assert.assertTrue( searchTermsPage.VerifyAddNewSerach());


    }

    @Test(description = "Mirehmidi",priority = 13)
    public void editNewSeachTermTest() {
        searchTermsPage.searchEditTest();
        Assert.assertTrue(searchTermsPage.verifyEditNewSearch());
    }

    @Test(description = "muyesser",priority = 14)
    public void deleteSearchTest(){
        searchTermsPage.deleteExistingSearchTerm();
        Assert.assertTrue(searchTermsPage.verifyDeleteSearchFunction());
    }
    @Test(description = "Gülzar",priority = 15)
    public void filterExistingSearchTermTestt(){
        searchTermsPage.filterExistingSearchTermTest();
        Assert.assertTrue(searchTermsPage.verifyFilterTermTest());
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }


}

