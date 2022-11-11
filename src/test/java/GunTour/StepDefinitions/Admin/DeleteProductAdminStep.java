package GunTour.StepDefinitions.Admin;

import GunTour.API.GunTourAPI_Admin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class DeleteProductAdminStep {
    @Steps
    GunTourAPI_Admin gunTourAPIAdmin;

    //Admin-027 & Admin-028
    @Given("set path to delete product from id {string}")
    public void setPathToDeleteProductFromId(String id_product){
        gunTourAPIAdmin.deleteProduct(id_product);
    }
    @When("send request delete product")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(GunTourAPI_Admin.DELETE_PRODUCT);
    }
    @And("delete product json schema validator")
    public void deleteProductJsonSchemaValidator() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/JsonSchema/admin/DeleteProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Admin-028 & Admin-029
    @Given("set path to delete product {int}")
    public void setPathToDeleteProduct(int id_product) {
        gunTourAPIAdmin.deleteProductUnregistered(id_product);
    }
    @And("delete product invalid json schema validator")
    public void deleteProductInvalidJsonSchemaValidator() {
        File json = new File(GunTourAPI_Admin.JSON_FILE+"/JsonSchema/admin/DeleteProductInvJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-029
    @Given("set path to delete product with invalid id {string}")
    public void setPathToDeleteProductWithInvalidId(String id_product) {
        gunTourAPIAdmin.deleteProductInvalid(id_product);
    }

}
