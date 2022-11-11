package GunTour.StepDefinitions.Admin;

import GunTour.API.GunTourAPI_Admin;
import GunTour.Responses.GlobalEnv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.io.File;

public class PostNewProductAdminStep {
    @Steps
    GunTourAPI_Admin gunTourAPIAdmin;
    GlobalEnv globalEnv;

    //Admin-013
    @Given("set post valid request body to json data")
    public void setPostValidRequestBodyToJsonData(){
        gunTourAPIAdmin.postAddNewProduct();
    }
    @When("send request post add new product")
    public void sendRequestPostAddNewProduct() {
        SerenityRest.when().post(GunTourAPI_Admin.POST_ADD_NEW_PRODUCT);
    }
    @Then("should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @Then("should return {int} ok")
    public void shouldReturnOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("post add new product json schema")
    public void postAddNewProductJsonSchema() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/JsonSchema/admin/PostNewProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-014
    @Given("set post empty request body to json data")
    public void setPostEmptyRequestBodyToJsonData() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/RequestBody/admin/PostNewProductEmptyBody.json");
        gunTourAPIAdmin.postAddNewProductInvalid(json);
    }
    @And("post new product with invalid body json schema")
    public void postNewProductWithInvalidBodyJsonSchema() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/JsonSchema/admin/PostNewProductInvJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-015
    @Given("set post incomplete request body to json data")
    public void setPostIncompleteRequestBodyToJsonData() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/RequestBody/admin/PostNewProductIncomplete.json");
        gunTourAPIAdmin.postAddNewProductInvalid(json);
    }

    //Admin-016
    @Given("set post invalid request body to json data")
    public void setPostInvalidRequestBodyToJsonData() {
        gunTourAPIAdmin.postAddNewProductInvalid();
    }

    @And("API send productID to dynamic variable")
    public int apiSendProductIDToDynamicVariable() {
        return globalEnv.productID = SerenityRest.then().extract().path("data.id_product");
    }

    @And("assert productID not {int}")
    public void assertUsersIDNot(int val) {
        Assert.assertNotEquals(globalEnv.productID, val);
    }

    //LOGIN_ADMIN
    @Given("set post login with body json")
    public void setPostLoginWithBodyJson() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/RequestBody/admin/LoginAdmin.json");
        gunTourAPIAdmin.postLoginAdmin(json);
    }

    @When("send request post login admin")
    public void sendRequestPostLoginAdmin() {
        SerenityRest.when().post(GunTourAPI_Admin.LOGIN_ADMIN);
    }
    @Then("API should return {int} accepted")
    public void apiShouldReturnCreated(int accepted) {
        SerenityRest.then().statusCode(accepted);
    }
    @And("API send token to dynamic variable")
    public void apiSendTokenToDynamicVariable() {
        gunTourAPIAdmin.AUTH_ADMIN = SerenityRest.then().extract().path("data.token");
    }
    @And("assert token not {int}")
    public void assertTokenNot(int val) {
        Assert.assertNotEquals(gunTourAPIAdmin.AUTH_ADMIN, val);
    }

}
