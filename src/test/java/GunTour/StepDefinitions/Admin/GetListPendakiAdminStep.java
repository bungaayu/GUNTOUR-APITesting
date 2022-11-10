package GunTour.StepDefinitions.Admin;

import GunTour.API.AdminAPI;
import GunTour.Responses.AdminResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListPendakiAdminStep {
    @Steps
    AdminAPI adminAPI;

    //Admin-001
    @Given("set path to get list pendaki")
    public void setPathToGetListPendaki(){
        adminAPI.getListPendaki();
    }
    @When("send request get list pendaki")
    public void sendRequestGetListPendaki() {
        SerenityRest.when().get(AdminAPI.GET_LIST_PENDAKI);
    }
    @Then("response should return {int} ok")
    public void responseShouldReturnOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("get list pendaki json schema validator")
    public void getListPendakiJsonSchemaValidator() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/GetListPendakiJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-002
    @When("send request get list string pendaki")
    public void sendRequestGetListStringPendaki() {
        SerenityRest.when().get(AdminAPI.GET_LIST_PENDAKI+"berani");
    }
    @Then("should return {int} not found")
    public void shouldReturnNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }
    @And("response body should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then().body(AdminResponse.MESSAGE,equalTo(message));
    }
    @And("get list pendaki invalid json schema validator")
    public void getListPendakiInvalidJsonSchemaValidator() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/GetListPendakiInvJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-003
    @When("send request get list special char pendaki")
    public void sendRequestGetListSpecialCharPendaki() {
        SerenityRest.when().get(AdminAPI.GET_LIST_PENDAKI+"@$^$");
    }

    //Admin-004
    @When("send request get list int pendaki")
    public void sendRequestGetListintPendaki() {
        SerenityRest.when().get(AdminAPI.GET_LIST_PENDAKI+"123");
    }


}
