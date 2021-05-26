import entities.Message;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiTestSteps {
    private Response response;
    private String route;


    @Given("route is {string}")
    public void getRequest(String route) {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://gorest.co.in/public-api/" +route +"/")
                .then()
                .extract().response();
    }

    @When("user try to get order by id")
    public void getOrderById() {
    }

    @Then("user receive status code {int}")
    public void compareStatusCodes(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @Then("user receive message {string}")
    public void compareResponseMessage(String expectedMessage) {
        Message message = response.body().as(Message.class);
        Assert.assertEquals(expectedMessage, message.getMessage());
    }

    @Then("response don't equal zero")
    public void checkThatResponseNotNull() {
        response.then().body(Matchers.notNullValue());
    }
}
