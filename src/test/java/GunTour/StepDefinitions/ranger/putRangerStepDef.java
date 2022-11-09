package GunTour.StepDefinitions.ranger;

import GunTour.API.GunTourAPI_Ranger;
import GunTour.Responses.GlobalEnv;
import GunTour.Responses.GunTourResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.io.File;

public class putRangerStepDef {

    @Steps
    GunTourAPI_Ranger guntourAPI_ranger;
    GlobalEnv globalEnv;

    @Given("admin update status ranger to accepted")
    public void adminUpdateStatusRangerToAccepted(){
        int id = (GunTourResponse.GET_ID_RANGER_APPLY);
        File json = new File(GunTourAPI_Ranger.JSON_REQUEST_BODY_RANGER + "/PutValidAcceptedBody.json");
        guntourAPI_ranger.putUpdateRangerApplyStatus(json, id);
    }

    @When("send request put update ranger")
    public void sendRequestPutUpdateRanger() {
        SerenityRest.when().put(GunTourAPI_Ranger.PUT_UPDATE_RANGER);
    }

    @And("API should return code {int} ACCEPTED")
    public void apiShouldReturnCodeACCEPTED(int accepted) {
        SerenityRest.then().statusCode(accepted);
    }

    @Then("put update ranger json schema validator")
    public void putUpdateRangerJsonSchemaValidator() {
        File json = new File(GunTourAPI_Ranger.JSON_SCHEMA_RANGER + "/JsonSchemaValidatorAcceptedRanger.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("API send dynamic ID to variable")
    public void  apiSendDynamicIDtoVariable(){
        GunTourResponse.GET_ID_RANGER_APPLY = SerenityRest.then().extract().path("data_apply.data[0].id_ranger");
    }

    @And("assert ID not {int}")
    public void assertIDNot(int id) {
        Assert.assertNotEquals(GunTourResponse.GET_ID_RANGER_APPLY, 0);
    }

    @Given("get ranger applied ranger list")
    public void getRangerAppliedRangerList() {
        guntourAPI_ranger.getRangerListApply();
    }

    @When("send request get applied ranger list")
    public void sendRequestGetAppliedRangerList() {
        SerenityRest.when().get(GunTourAPI_Ranger.GET_LIST_RANGER_APPLY);
    }

    @Given("admin update status ranger to accepted {int}")
    public void adminUpdateStatusRangerToAcceptedId(int id_ranger) {
        File json = new File(GunTourAPI_Ranger.JSON_REQUEST_BODY_RANGER + "/PutValidAcceptedBody.json");
        guntourAPI_ranger.putUpdateRangerApplyStatus(json, id_ranger);
    }

    @Given("admin update status ranger to accepted with no id")
    public void adminUpdateStatusRangerToAcceptedWithNoId() {
        File json = new File(GunTourAPI_Ranger.JSON_REQUEST_BODY_RANGER + "/PutValidAcceptedBody.json");
        guntourAPI_ranger.putUpdateRangerApplyStatusWithNoID(json);
    }

    @Then("put update ranger invalid json schema validator")
    public void putUpdateRangerInvalidJsonSchemaValidator() {
        File json = new File(GunTourAPI_Ranger.JSON_SCHEMA_RANGER + "/JsonSchemaValidatorRangerInvalidID.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("API should return code {int} METHOD NOT ALLOWED")
    public void apiShouldReturnCodeMETHODNOTALLOWED(int method_not_allowed) {
        SerenityRest.then().statusCode(method_not_allowed);
    }

    @When("send request put update ranger with no id")
    public void sendRequestPutUpdateRangerWithNoId() {
        SerenityRest.when().put(GunTourAPI_Ranger.PUT_UPDATE_RANGER_WITH_NO_ID);
    }

    @Given("admin update status ranger without body {int}")
    public void adminUpdateStatusRangerWithoutBody(int id_ranger) {
        File json = new File(GunTourAPI_Ranger.JSON_REQUEST_BODY_RANGER + "/PutInvalidAcceptedBody.json");
        guntourAPI_ranger.putUpdateRangerApplyStatus(json, id_ranger);
    }

    @Given("admin update status ranger with invalid body {int}")
    public void adminUpdateStatusRangerWithInvalidBodyId(int id_ranger) {
        File json = new File(GunTourAPI_Ranger.JSON_REQUEST_BODY_RANGER + "/PutInvalidAcceptedBody.json");
        guntourAPI_ranger.putUpdateRangerApplyStatus(json, id_ranger);
    }

    @Given("admin update status ranger to rejected")
    public void adminUpdateStatusRangerToRejected() {
        int id = (GunTourResponse.GET_ID_RANGER_APPLY);
        File json = new File(GunTourAPI_Ranger.JSON_REQUEST_BODY_RANGER + "/PutValidRejectedBody.json");
        guntourAPI_ranger.putUpdateRangerApplyStatus(json, id);
    }

    @Given("admin update status ranger to rejected with no id")
    public void adminUpdateStatusRangerToRejectedWithNoId() {
        File json = new File(GunTourAPI_Ranger.JSON_REQUEST_BODY_RANGER + "/PutValidRejectedBody.json");
        guntourAPI_ranger.putUpdateRangerApplyStatusWithNoID(json);
    }
}
