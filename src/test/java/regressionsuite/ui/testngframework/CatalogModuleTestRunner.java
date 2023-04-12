package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.catalogmodule.*;
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
        searchTermsPage=new SearchTermsPage(driver);
    }
    @Test(description = "kaysar", priority = 1)
    public void AddRootCategoriesTest() {
        manageCategoriesPage.fillCategoryInformationAndSave();
        Assert.assertTrue(manageCategoriesPage.VerifyAddCatogories());
    }

    @Test(description = "meryem", priority = 2,dependsOnMethods = {"AddRootCategoriesTest"})

    public void EditCategoriesTest() {
        manageCategoriesPage.editCatogoriesInfo();
        Assert.assertTrue(manageCategoriesPage.verifyEditCatogories());
    }

    @Test(description = "Omercan",priority = 3,dependsOnMethods ={"AddRootCategoriesTest"} )
    public void deleteRootCatTes(){
        manageCategoriesPage.deleteRootCat();
        Assert.assertTrue(manageCategoriesPage.deleteCategorySuccessful());
    }

    @Test(description = "abdusattar",priority = 4)
    public void addSubCategory(){
        manageCategoriesPage.addSubCategory();
        Assert.assertTrue(manageCategoriesPage.verifyAddSubCategory());
    }


    @Test(description = "muyesser",dependsOnMethods = "addSubCategory",priority = 5)
    public void editSubCategoryTest(){
        manageCategoriesPage.editSubCategory();
        Assert.assertTrue(manageCategoriesPage.verifyEditSubCategory());
    }

    @Test(description = "Memet",dependsOnMethods = "addSubCategory",priority = 6)
    public void subCatDeleteTest(){
        manageCategoriesPage.subCatDelete();
        Assert.assertTrue(manageCategoriesPage.subCatDeleteSuccessful());
    }


    @Test(description = "rizvangul",priority = 7)
    public void addProductTest(){
        manageProductsPage.addProduct();
        Assert.assertTrue(manageProductsPage.verifyAddProduct());

    }

    @Test(description = "rizvangul",dependsOnMethods ={"addProductTest"},priority = 8)
    public void editProductTest(){
        manageProductsPage.editProduct();
        Assert.assertTrue(manageProductsPage.verifyEditProduct());

    }
    @Test(description = "Fazilet",dependsOnMethods ={"editProductTest"},priority = 9)
    public void deleteProductTest() {
        manageProductsPage.deleteproduct();
        Assert.assertTrue(manageProductsPage.verifydeletedproduct());
    }

    @Test(description = "kaysar", priority = 10)
    public void AddNewSeachTermTest() {
        searchTermsPage.NewSearchInfo();
        Assert.assertTrue( searchTermsPage.VerifyAddNewSerach());


    }

    @Test(description = "Mirehmidi",priority = 11)
    public void SeachEditTest(){
        searchTermsPage.NewSearchInfo();
        Assert.assertTrue(searchTermsPage.VerifyEditNewSerach());
    }


    @AfterClass
    public void tearDown(){
        closeBrowser();
    }

}
