package GunTour.StepDefinitions.Ranger;


import GunTour.API.GunTourAPI_Ranger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class postRangerStepDef {

    @Steps
    GunTourAPI_Ranger guntourAPI_ranger;

    @Given("user apply as ranger with valid data")
    public void userApllyAsRangerWithValidData() {
        guntourAPI_ranger.postApplyAsRangerValidBody();
    }

    @And("send request post ranger")
    public void sendRequestPostRanger() {
        SerenityRest.when().post(GunTourAPI_Ranger.POST_RANGER);
    }

    @Then("API should return code {int} CREATED")
    public void apiShouldReturnCodeCREATED(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("post ranger json schema validator")
    public void postRangerJsonSchemaValidator() {
        File json = new File(GunTourAPI_Ranger.JSON_SCHEMA_RANGER + "/JsonSchemaValidatorRangerValidBody.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("user apply as ranger without fullname")
    public void userApplyAsRangerWithInvalidBody() {
        guntourAPI_ranger.postApplyAsRangerWithoutfullname();
    }

    @When("user apply as ranger without ttl")
    public void userApplyAsRangerWithoutTtl() {
        guntourAPI_ranger.postApplyAsRangerWithoutttl();
    }

    @When("user apply as ranger without address")
    public void userApplyAsRangerWithoutAddress() {
        guntourAPI_ranger.postApplyAsRangerWithoutaddress();
    }

    @When("user apply as ranger without phone")
    public void userApplyAsRangerWithoutPhone() {
        guntourAPI_ranger.postApplyAsRangerWithoutphone();
    }

    @When("user apply as ranger without gender")
    public void userApplyAsRangerWithoutGender() {
        guntourAPI_ranger.postApplyAsRangerWithoutgender();
    }

    @When("user apply as ranger without docs")
    public void userApplyAsRangerWithoutDocs() {
        guntourAPI_ranger.postApplyAsRangerWithoutdocs();
    }

    @And("send request post ranger with invalid parameter")
    public void sendRequestPostRangerWithInvalidParameter() {
        SerenityRest.when().post(GunTourAPI_Ranger.POST_RANGER_WITH_INVALID_PARAMETER);
    }

    @And("send request post ranger without parameter")
    public void sendRequestPostRangerWithNoParameter() {
        SerenityRest.when().post(GunTourAPI_Ranger.POST_RANGER_WITHOUT_PARAMETER);
    }

    @And("post ranger invalid json schema validator")
    public void postRangerInvalidJsonSchemaValidator() {
        File json = new File(GunTourAPI_Ranger.JSON_SCHEMA_RANGER + "/JsonSchemaValidatorIRangerListInvalid.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}