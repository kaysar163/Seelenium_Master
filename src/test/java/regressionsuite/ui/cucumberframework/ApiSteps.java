package regressionsuite.ui.cucumberframework;

import com.magentoapplication.utility.ApplicationConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiSteps {

    final static String configFile="config.properties";


    String apiBaseUrl;
    String apiUsername;
    String apiPassword;
    int apiPort;

    Response response;


    @Given("a valid username and a password")
    public void aValidUsernameAndAPassword() {
        apiBaseUrl= ApplicationConfig.readFromConfigProperties(configFile,"apiBaseUrl");
        apiUsername=ApplicationConfig.readFromConfigProperties(configFile,"apiUserName");
        apiPassword=ApplicationConfig.readFromConfigProperties(configFile,"apiPassword");
        apiPort=Integer.parseInt(ApplicationConfig.readFromConfigProperties(configFile,"apiPort"));
    }

    @When("an authorized user sends a request to the product end point")
    public void anAuthorizedUserSendsARequestToTheProductEndPoint() {
        response= RestAssured.given().auth().basic(apiUsername,apiPassword).when()
                .get(apiBaseUrl+":"+apiPort+"/products");
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("the api should return all product with {int} response code")
    public void theApiShouldReturnAllProductWithResponseCode(int arg0) {
        arg0=200;
        Assert.assertTrue(response.getStatusCode()==arg0);
    }
}
