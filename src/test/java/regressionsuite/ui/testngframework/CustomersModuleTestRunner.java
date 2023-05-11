package regressionsuite.ui.testngframework;

import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.customersmodule.CustomerGroupPage;
import com.magentoapplication.ui.backend.customersmodule.CustomerInformationPage;
import com.magentoapplication.ui.backend.customersmodule.CustomersManagerPage;
import com.magentoapplication.ui.backend.customersmodule.EditCustomerGroupPage;
import com.magentoapplication.utility.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CustomersModuleTestRunner extends TestBase {

    BackEndLogin backEndLogin;
    EditCustomerGroupPage editCustomerGroupPage;
    CustomersManagerPage customersManagerPage;
    CustomerInformationPage customerInformationPage;
    CustomerGroupPage customerGroupPage;


    @BeforeClass
    public void setUp(ITestContext context) {
        setupBrowserBackEnd();
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.customersModuleLogin();
        customersManagerPage = new CustomersManagerPage(driver);
        customerInformationPage=new CustomerInformationPage(driver);
        editCustomerGroupPage=new EditCustomerGroupPage(driver);
        customerGroupPage=new CustomerGroupPage(driver);
        context.setAttribute("driver", driver);
    }



    @Test(description= "kaysar", priority = 1)
    public void managerAddNewCustomerTest(){
        customerInformationPage.addCustomerMethod();
        Assert.assertTrue(customerInformationPage.verifyCustomer());


    }

    @Test(description = "Memet",dependsOnMethods = {"managerAddNewCustomerTest"},priority = 2,enabled = false)
    public void passwordResetTest(){
        customerInformationPage.customerPasswordChange();
        Assert.assertTrue(customerInformationPage.passwordSuccessfullyChanged());
    }

    @Test(description= "omercan", priority = 3,dependsOnMethods = "managerAddNewCustomerTest")
    public void emailFilterTest() {
        customersManagerPage.FilterCustomersByEmail();
    }

    @Test(priority = 4,dependsOnMethods = "managerAddNewCustomerTest")
    public void assignACustomerToCustomerGroupTest() {
        customersManagerPage.assignGroupToCustomer();
        Assert.assertTrue(customersManagerPage.verifyUpdate());
    }

    @Test(description = "murdail",priority = 5)
    public void addNewAddressTest(){
        customerInformationPage.customerManagerCanAddANewAddressForACustomer();
        Assert.assertTrue(customerInformationPage.verifyAddNewAddress());

    }

    @Test(description = "Irshad",dependsOnMethods = {"managerAddNewCustomerTest"}, priority =6)
    public void deleteCustomerTest(){
        customersManagerPage.deleteCustomer();
        Assert.assertTrue(customersManagerPage.verifyDeleteCustomer());
    }


    @Test(description = "manager can export customers-muyesser",priority = 7)
    public void managerExportCustomerTest(){
        customersManagerPage.exportCustomers();
        Assert.assertTrue(customersManagerPage.verifyExportCustomer());

    }


    @Test(description = "renagul",priority = 8)
    public void FilterCustomerBySate() {
        customersManagerPage.filterCustomerBySate();
        Assert.assertTrue(customersManagerPage.verifyCustomerFilterByState());
    }

    @Test(description= "Fazilet", priority = 9)
    public void filterCustomerByCountry(){
        customersManagerPage.filterCustomerByCountry();
        Assert.assertTrue(customersManagerPage.verifyCustomerFilteredByCountry());
    }

    @Test(description = "Filter the Customer By Group Test-Rizvangul", priority = 10)
    public void filterTheCustomerByGroupTest(){
        customersManagerPage.filterTheCustomerByGroup();
        Assert.assertTrue(customersManagerPage.verifyFilterTheCustomerByGroup());
    }

    @Test(description= "Mirehmidi",priority = 11)
    public void FilterCustomersBywebsite() {
        customersManagerPage.filterCustomersBywebsite();
        Assert.assertTrue(customersManagerPage.verifyWebsite());

    }



    @Test(description = "Fazilet", priority = 12)
    public void addNewCustomerGroup(){
        customerGroupPage.addNewCustomerGroup();
        Assert.assertTrue(customerGroupPage.verifyTheCustomerGroupHasBeenSaved());
    }


    @Test(description = "meryem",dependsOnMethods = {"addNewCustomerGroup"}, priority = 13)
    public void editCustomerGroup() {
        editCustomerGroupPage.editCustomerGroupInfo();
        Assert.assertTrue(editCustomerGroupPage.verifyCustomerGroupEditedTest());

    }
    @Test(description = "meryem",dependsOnMethods = {"addNewCustomerGroup"}, priority = 14)
    public void deleteCustomerGroup() {
        editCustomerGroupPage.deleteCustomerGroupInfo();
        Assert.assertTrue(editCustomerGroupPage.verifyCustomerGroupDeletedTest1());
    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }


}
