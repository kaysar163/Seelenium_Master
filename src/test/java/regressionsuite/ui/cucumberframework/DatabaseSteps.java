package regressionsuite.ui.cucumberframework;

import com.magentoapplication.backend.database.ConnectionType;
import com.magentoapplication.backend.database.DataAccess;
import com.magentoapplication.backend.database.DatabaseConnection;
import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.storemodule.ManageStoresPage;
import com.magentoapplication.ui.backend.storemodule.TestHelperStore;
import com.magentoapplication.ui.frontend.usermodule.CreateAnAccountPage;
import com.magentoapplication.ui.frontend.usermodule.TestHelperFrontEnd;
import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Connection;

public class DatabaseSteps extends TestBase {

    Connection connection;

    String config="config.properties";

    CreateAnAccountPage createAnAccountPage;

    BackEndLogin backEndLogin;

    DataAccess dataAccess;

    String dbUrl= ApplicationConfig.readFromConfigProperties(config,"dbIp");
    String dbPort= (ApplicationConfig.readFromConfigProperties(config,"dbPort"));
    String dbUserName= ApplicationConfig.readFromConfigProperties(config,"dbUserName");
    String dbPassword= ApplicationConfig.readFromConfigProperties(config,"dbPassword");
    String dbDefault= ApplicationConfig.readFromConfigProperties(config,"dbDefault");




    @Before("@DatabaseTest")
    public void setUp(){
        connection= DatabaseConnection.connection(dbUrl,dbPort,dbDefault,dbUserName,dbPassword, ConnectionType.MYSQL);
        //backEndLogin=new BackEndLogin(driver);
        dataAccess=new DataAccess();
    }

    @After("@DatabaseTest")
    public void tearDown(){
        DatabaseConnection.closeDataBaseConnection(connection);
        closeBrowser();
    }

    @Given("connection is already established")
    public void connectionIsAlreadyEstablished() {
    }

    @When("a new user registers to the system")
    public void aNewUserRegistersToTheSystem() {
        setupBrowserFrontEnd();
        createAnAccountPage=new CreateAnAccountPage(driver);
        createAnAccountPage.fillAccountRegistrationForm();
        Assert.assertTrue(createAnAccountPage.verifyCreateAnAccountSuccessful());
    }

    @Then("the user should be in the database")
    public void theUserShouldBeInTheDatabase() {
        boolean isCustomerAdded=dataAccess.getRegisteredCustomer(TestHelperFrontEnd.getEmail(),connection);
        Assert.assertTrue(isCustomerAdded);
    }

    @Then("the added store should appear in the database")
    public void theAddedStoreShouldAppearInTheDatabase() {
        Assert.assertTrue(dataAccess.assertStoreExists(TestHelperStore.getStoreName()));



    }

    @When("a new store should be added on the store page")
    public void aNewStoreShouldBeAddedOnTheStorePage() {
        backEndLogin=new BackEndLogin(driver);
        backEndLogin.storeModuleLogin();
        ManageStoresPage manageStoresPage=new ManageStoresPage(driver);
        manageStoresPage.createStore();
        Assert.assertTrue(manageStoresPage.verifyCreateStore());
    }
}
