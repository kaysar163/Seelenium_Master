package regressionsuite.ui.cucumberframework;

import com.magentoapplication.backend.api.CustomerPayload;
import com.magentoapplication.backend.api.PayloadUtility;
import com.magentoapplication.utility.ApplicationConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

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
        response= given().auth().basic(apiUsername,apiPassword).when()
                .get(apiBaseUrl+":"+apiPort+"/products");
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("the api should return all product with {int} response code")
    public void theApiShouldReturnAllProductWithResponseCode(int arg0) {
        arg0=200;
        Assert.assertTrue(response.getStatusCode()==arg0);
    }


    @When("an authorized user sends a request to the customer end point")
    public void anAuthorizedUserSendsARequestToTheCustomerEndPoint() {
        response= given().header("Content-Type","application/json").and()
                .body(PayloadUtility.createCustomerPayload()).auth().basic(apiUsername,apiPassword).when().
                post(apiBaseUrl+":"+apiPort+"/customer").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("the api should return created customer with {int} response code")
    public void theApiShouldReturnCreatedCustomerWithResponseCode(int arg0) {
        Assert.assertTrue(response.getStatusCode()==arg0);
    }

    @When("user makes a request to update customer group info")
    public void userMakesARequestToUpdateCustomerGroupInfo() {
        String cusGroupPayload=PayloadUtility.putCustomerGroupPayload();
        response=given().
                header("Content-Type","application/json").and().body(cusGroupPayload)
                .auth().basic(apiUsername,apiPassword)
                .when().put(apiBaseUrl+":"+apiPort+"/customergroup"+"/600")
                .then().extract().response();
        System.out.println(response.getBody().asString());
    }
    @Then("user should have the status code {string} displayed")
    public void userShouldHaveTheStatusCodeDisplayed(String arg0) {
        Assert.assertEquals(Integer.parseInt(arg0),response.getStatusCode());
    }

    @When("user should be able to send Get request with customer group end point")
    public void userShouldBeAbleToSendGetRequestWithCustomerGroupEndPoint() {
        response= given().auth().basic(apiUsername,apiPassword).when().
                get(apiBaseUrl+":"+apiPort+"/customergroup").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
    }



    @Then("the api should return a response code of {int}")
    public void theApiShouldReturnAResponseCodeOf(int arg0) {
        Assert.assertEquals(response.getStatusCode(),arg0);
    }
    @When("an authorized user sends a request to the product put in point")
    public void auAuthorizedUserSendsARequestToTheProductPutInPoint() {
        response=RestAssured.given().headers("Content-Type","application/json").and()
                .body(PayloadUtility.createProductPayload()).auth().basic(apiUsername,apiPassword).when().
                put(apiBaseUrl+":"+apiPort+"/product/238").then().extract().response();
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("the api should return update product with {int} response code")
    public void theApiShouldReturnUpdateProductWithResponseCode(int arg0) {
        Assert.assertTrue(response.getStatusCode()==arg0);
    }

    @When("an authorized user sends a request to the category end point")
    public void anAuthorizedUserSendsARequestToTheCategoryEndPoint() {
        response= given().auth().basic(apiUsername,apiPassword).when()
                .get(apiBaseUrl+":"+apiPort+"/categories");
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("the api should return all categories with {int} response code")
    public void theApiShouldReturnAllCategoriesWithResponseCode(int arg0) {
        arg0=200;
        Assert.assertTrue(response.getStatusCode()==arg0);
    }

    @When("an authorized user sends a put request to the category end point")
    public void anAuthorizedUserSendsAPutRequestToTheCategoryEndPoint() {
        response=given().auth().basic(apiUsername,apiPassword).when().put(apiBaseUrl+":"+apiPort+"/category/1");
        System.out.println(response.getBody().prettyPrint());

    }

    @Then("the api should retur")
    public void theApiShouldRetur(int arg0) {
        arg0=200;
        Assert.assertTrue(response.getStatusCode()==arg0);
    }
}
