package GunTour.StepDefinitions.Admin;

import GunTour.API.GunTourAPI_Admin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PutUpdateProductAdminStep {
    @Steps
    GunTourAPI_Admin gunTourAPIAdmin;

    //Admin-022
    @Given("set path to put update product from id {string}")
    public void setRequestBodyPutUpdateFromId(String id_product) {
        gunTourAPIAdmin.putUpdateProductStringId(id_product);
    }
    @Given("set path to put update product unavailable {int}")
    public void setPathToPutUpdateProductUnavailable(int id_product) {
        gunTourAPIAdmin.putUpdateProductUnavailableId(id_product);
    }
    @When("send request put update product")
    public void sendRequestPutUpdateProduct() {
        SerenityRest.when().put(GunTourAPI_Admin.PUT_UPDATE_PRODUCT);
    }
    @Then("should return {int} accepted")
    public void shouldReturnAccepted(int acc) {
        SerenityRest.then().statusCode(acc);
    }
    @And("put update product json schema")
    public void putUpdateProductJsonSchema() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/JsonSchema/admin/PutUpdateProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-023, Admin-024, Admin-025, & Admin-026
    @And("put invalid update product json schema")
    public void putInvalidUpdateProductJsonSchema() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/JsonSchema/admin/PutUpdateProductInvJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-024
    @Given("set path to put empty product from id {string}")
    public void setPathToPutEmptyProductFromId(String id_product) {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/RequestBody/admin/PutUpdateEmptyProduct.json");
        gunTourAPIAdmin.setPutBodyJson(id_product,json);
    }

    //Admin-025
    @Given("set path to put incomplete product from id {string}")
    public void setRequestBodyIncompleteProductFromId(String id_product) {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/RequestBody/admin/PutUpdateIncompleteProduct.json");
        gunTourAPIAdmin.setPutBodyJson(id_product,json);
    }

    //Admin-026
    @Given("set path to put invalid product from id {string}")
    public void setPathToPutInvalidProductFromId(String id_product) {
        gunTourAPIAdmin.setPutBodyInvalid(id_product);
    }

}
