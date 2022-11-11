package GunTour.StepDefinitions.Ranger;

import GunTour.API.GunTourAPI_Ranger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class getRangerStepDef {

    @Steps
    GunTourAPI_Ranger gunTourAPI_ranger;

    @Given("user get ranger list with date format {string} {string}")
    public void userGetRangerListWithDateFormat(String date_start, String date_end){
        gunTourAPI_ranger.getRangerList(date_start, date_end);
    }

    @When("send request get ranger")
    public void sendRequestGetRanger() {
        SerenityRest.when().get(GunTourAPI_Ranger.GET_RANGER);
    }

    @And("get ranger json schema validator")
    public void getRangerJsonSchemaValidator() {
        File json = new File(GunTourAPI_Ranger.JSON_SCHEMA_RANGER + "/JsonSchemaValidatorRangerListValid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("send request get ranger with invalid parameter")
    public void sendRequestGetRangerWithInvalidParameter() {
        SerenityRest.when().get(GunTourAPI_Ranger.GET_RANGER_WITH_INVALID_PARAMETER);
    }

    @When("send request get ranger without parameter")
    public void sendRequestGetRangerWithoutParameter() {
        SerenityRest.when().get(GunTourAPI_Ranger.GET_RANGER_WITHOUT_PARAMETER);
    }

    @And("get ranger invalid json schema validator")
    public void getRangerInvalidJsonSchemaValidator() {
        File json = new File(GunTourAPI_Ranger.JSON_SCHEMA_RANGER + "/JsonSchemaValidatorIRangerListInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
