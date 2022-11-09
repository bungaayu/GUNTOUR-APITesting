package GunTour.StepDefinitions.products;

import GunTour.API.GunTourAPI_Products;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class getProductsStepDef {

    @Steps
    GunTourAPI_Products gunTourAPI_Products;

    @When("user get product with valid page {int}")
    public void userGetProductWithValidPage(int page){
        gunTourAPI_Products.setGetProduct(page);
    }

    @And("send request get product")
    public void sendRequestGetProduct() {
        SerenityRest.when().get(GunTourAPI_Products.GET_PRODUCT);
    }

    @Then("API should return code {int} OK")
    public void apiShouldReturnCodeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("response body should match product json schema validator")
    public void responseBodyShouldMatchJsonSchemaValidator() {
        File json = new File(GunTourAPI_Products.JSON_SCHEMA_PRODUCTS+"/JsonSchemaValidatorValidPage.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("user get product with exceeded page limit {int}")
    public void userGetProductWithExceededPageLimitPage(int page) {
        gunTourAPI_Products.setGetProduct(page);
    }

    @Then("API should return code {int} BAD REQUEST")
    public void apiShouldReturnCodeBADREQUEST(int bad_request) {
        SerenityRest.then().statusCode(bad_request);
    }

    @And("response body should match invalid product json schema validator")
    public void responseBodyShouldMatchExceedPageLimitJsonSchemaValidator() {
        File json = new File(GunTourAPI_Products.JSON_SCHEMA_PRODUCTS+"/JsonSchemaValidatorInvalidPage.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("user get product with special char. {string}")
    public void userGetProductWithSpecialCharPage(String page) {
        gunTourAPI_Products.getProduct(page);
    }

    @When("user get product with decimal {double}")
    public void userGetProductWithDecimalPage(double page) {
        gunTourAPI_Products.getProduct(String.valueOf(page));
    }

    @When("user get product with alphabet {string}")
    public void userGetProductWithAlphabet(String page) {
        gunTourAPI_Products.getProduct(page);
    }

    @Then("API should return code {int} NOT FOUND")
    public void apiShouldReturnCodeNOTFOUND(int not_found) {
        SerenityRest.then().statusCode(not_found);
    }

    @And("send request get product with invalid parameter")
    public void sendRequestGetProductWithInvalidParameter() {
        SerenityRest.when().get(GunTourAPI_Products.GET_PRODUCT_INVALID_PARAMER);
    }

    @And("send request get product with no parameter")
    public void sendRequestGetProductWithNoParameter() {
        SerenityRest.when().get(GunTourAPI_Products.GET_PRODUCT_NO_PARAM);
    }

    @When("user get product detail with valid id {int}")
    public void userGetProductDetailWithValidIdId(int id) {
        gunTourAPI_Products.setGetProductDetails(id);
    }

    @And("send request get product detail")
    public void sendRequestGetProductDetail() {
        SerenityRest.when().get(GunTourAPI_Products.GET_PRODUCT_DETAILS);
    }

    @And("response body should match product detail json schema validator")
    public void responseBodyShouldMatchProductDetailJsonSchemaValidator() {
        File json = new File(GunTourAPI_Products.JSON_SCHEMA_PRODUCTS+"/JsonSchemaValidatorValidProductID.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("user get product with invalid id {int}")
    public void userGetProductWithInvalidIdId(int id) {
        gunTourAPI_Products.setGetProductDetails(id);
    }

    @And("response body should match invalid product detail json schema validator")
    public void responseBodyShouldMatchInvalidProductDetailJsonSchemaValidator() {
        File json = new File(GunTourAPI_Products.JSON_SCHEMA_PRODUCTS+"/JsonSchemaValidatorInvalidProductID.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("user get product detail with special char. {string}")
    public void userGetProducDetailWithSpecialChar(String id) {
        gunTourAPI_Products.GetProductDetails(id);
    }

    @When("user get product detail with decimal {double}")
    public void userGetProductDetailWithDecimalId(double id) {
        gunTourAPI_Products.GetProductDetails(String.valueOf(id));
    }

    @When("user get product detail with alphabet {string}")
    public void userGetProductDetailWithAlphabet(String id) {
        gunTourAPI_Products.GetProductDetails(id);
    }

    @And("send request get product detail with invalid parameter")
    public void sendRequestGetProductDetailWithInvalidParameter() {
        SerenityRest.when().get(GunTourAPI_Products.GET_PRODUCT_DETAILS_INVALID_PARAMETER);
    }

    @And("send request get product detail with no parameter")
    public void sendRequestGetProductDetailWithNoParameter() {
        SerenityRest.when().get(GunTourAPI_Products.GET_PRODUCT_DETAILS_NO_PARAM);
    }
}
