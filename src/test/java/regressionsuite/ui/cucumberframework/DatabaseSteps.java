package regressionsuite.ui.cucumberframework;

import com.magentoapplication.backend.database.ConnectionType;
import com.magentoapplication.backend.database.DataAccess;
import com.magentoapplication.backend.database.DatabaseConnection;
import com.magentoapplication.ui.backend.backendlogin.BackEndLogin;
import com.magentoapplication.ui.backend.catalogmodule.ManageCategoriesPage;
import com.magentoapplication.ui.backend.catalogmodule.TestHelperCatalog;
import com.magentoapplication.utility.ApplicationConfig;
import com.magentoapplication.utility.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.sql.Connection;

public class DatabaseSteps extends TestBase {

    BackEndLogin backEndLogin;
    ManageCategoriesPage manageCategoriesPage;
    Connection connection = null;
    DataAccess dataAccess;
    boolean isRootCategoryAdded = false;

    String config = "config.properties";
    String dbUrl = (ApplicationConfig.readFromConfigProperties(config, "dbIp"));
    String dbPort = (ApplicationConfig.readFromConfigProperties(config, "dbPort"));
    String dbUserName = ApplicationConfig.readFromConfigProperties(config, "dbUserName");
    String dbPassword = ApplicationConfig.readFromConfigProperties(config, "dbPassword");
    String dbDefault = ApplicationConfig.readFromConfigProperties(config, "dbDefault");


    @Before("@DatabaseTest")
    public void setUp() {
        connection = DatabaseConnection.connection(dbUrl, dbPort, dbDefault, dbUserName, dbPassword, ConnectionType.MYSQL);
        dataAccess = new DataAccess();


    }

    @After("@DatabaseTest")
    public void tearDown() {
        DatabaseConnection.closeDataBaseConnection(connection);
    }

    @Given("connection is already established")
    public void connectionIsAlreadyEstablished() {


    }

    @When("a new user registers to the system")
    public void aNewUserRegistersToTheSystem() {

    }

    @Then("the user should be in the database")
    public void theUserShouldBeInTheDatabase() {

    }
    @Then("the user should added new root category")
    public void theUserShouldAddedNewRootCategory() {
        Assert.assertTrue(dataAccess.verifyCatAdded(TestHelperCatalog.getRootName(),connection));

    }

    @When("user can add root category")
    public void userCanAddRootCategory() {
        setupBrowserBackEnd();
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.catalogModuleLogin();
        manageCategoriesPage = new ManageCategoriesPage(driver);
        manageCategoriesPage.fillCategoryInformationAndSave();
        Assert.assertTrue(manageCategoriesPage.VerifyAddCatogories());
    }
}
