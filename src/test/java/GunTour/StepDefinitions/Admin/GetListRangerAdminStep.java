package GunTour.StepDefinitions.Admin;

import GunTour.API.AdminAPI;
import GunTour.Responses.AdminResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListRangerAdminStep {
    @Steps
    AdminAPI adminAPI;

    //Admin-005
    @Given("set path to get list ranger")
    public void setPathToGetListRanger() {
        adminAPI.getListRanger();
    }
    @When("send request get list ranger")
    public void sendRequestGetListRanger() {
        SerenityRest.when().get(AdminAPI.GET_LIST_RANGER);
    }
    @And("get list ranger json schema validator")
    public void getListRangerJsonSchemaValidator() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/GetListRangerJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-006
    @Given("set path to get list ranger with invalid path")
    public void setPathToGetListRangerWithInvalidPath() {
        adminAPI.getListInvalidRanger();
    }
    @When("send request get list string ranger")
    public void sendRequestGetListStringRanger() {
        SerenityRest.when().get(AdminAPI.GET_LIST_RANGER+"hebat");
    }
    @And("get list ranger invalid json schema validator")
    public void getListRangerInvalidJsonSchemaValidator() {
        File json = new File(AdminAPI.JSON_FILE+"/JsonSchema/admin/GetListRangerInvJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Admin-007
    @When("send request get list special char ranger")
    public void sendRequestGetListSpecialCharRanger() {
        SerenityRest.when().get(AdminAPI.GET_LIST_RANGER+"@$^$");
    }

    //Admin-008
    @When("send request get list int ranger")
    public void sendRequestGetListIntRanger() {
        SerenityRest.when().get(AdminAPI.GET_LIST_RANGER+"123");
    }

}
