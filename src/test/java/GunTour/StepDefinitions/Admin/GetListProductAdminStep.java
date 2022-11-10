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

public class GetListProductAdminStep {

    @Steps
    AdminAPI adminAPI;

    //Admin-017
    @Given("set path to get list product")
    public void setPathToGetListProduct(){
        adminAPI.getListProduct();
    }
    @When("send request get list product")
    public void sendRequestGetListProduct() {
        SerenityRest.when().get(AdminAPI.GET_LIST_PRODUCT_NOPARAM);
    }
    @Then("response should return {int} ok and body page {int}")
    public void responseShouldReturnOkAndBodyPage(int ok, int page) {
        SerenityRest.then().statusCode(ok);
        SerenityRest.then().body(AdminResponse.PAGE,equalTo(page));
    }
    @And("get list product json schema validator")
    public void getListProductJsonSchemaValidator() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/GetListProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-018
    @Given("set path to get list product with parameter page {int}")
    public void setPathToGetListProductWithParameterPage(int page) {
        adminAPI.getListProductWithPage(page);
    }
    @When("send request get list product with page")
    public void sendRequestGetListProductWithPage() {
        SerenityRest.when().get(AdminAPI.GET_LIST_PRODUCT);
    }
    @Then("should return {int} bad request")
    public void shouldReturnBadRequest(int badreq) {
        SerenityRest.then().statusCode(badreq);
    }

    //Admin-020
    @Given("set path to get list product with string page {string}")
    public void setPathToGetListProductWithString(String page) {
        adminAPI.getListProductWithStringPage(page);
    }
    @And("get list product invalid json schema validator")
    public void getListProductInvalidJsonSchemaValidator() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/GetListProductInvJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
}
