package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import GunTour.Responses.GlobalEnv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RestAssuredResponseOptionsGroovyImpl;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.io.File;

public class AddBookingPlanStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
    GlobalEnv environment;
    public RestAssuredResponseOptionsGroovyImpl response;
    @Given("Add booking plan with all valid value {string}")
    public void addBookingPlanWithAllValidValue(String path) {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlan.json");
        bookingAPI.addBookingPlanwithPathParam(path, json);
    }

    @When("Send request post add booking plan with all valid body request")
    public void sendRequestPostAddBookingPlanWithAllValidBodyRequest() {
        SerenityRest.when().post(GunTourAPI_Booking.PATH_ADD_BOOKING_PLAN);
    }

    @Then("Should return {int} Created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Given("Add booking plan empty authorization valid path {string}")
    public void addBookingPlanEmptyAuthorization(String path) {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlan.json");
        bookingAPI.addBookingPlanEmptyAuth(path, json);
    }

    @Given("Add booking plan with all valid path {string} with string")
    public void addBookingPlanWithAllValidPathWithString(String path) {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlan.json");
        bookingAPI.addBookingPlanwithPathParam(path, json);
    }

    @Given("Add booking plan without input start date")
    public void addBookingPlanWithoutInputStartDate() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanWithoutStartDate.json");
        bookingAPI.addBookingPlan(json);
    }

    @When("Send request post add booking plan")
    public void sendRequestPostAddBookingPlan() {
        SerenityRest.when().post(GunTourAPI_Booking.ADD_BOOKING_PLAN);
    }

    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Assert booking plan json schema validator")
    public void addBookingPlanJsonSchemaValidator() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/AddBookingJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Add booking plan without input end date")
    public void addBookingPlanWithoutInputEndDate() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanWithoutEndDate.json");
        bookingAPI.addBookingPlan(json);
    }

    @Given("Add booking plan without input entrance gate")
    public void addBookingPlanWithoutInputEntranceGate() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanWithoutEntrance.json");
        bookingAPI.addBookingPlan(json);
    }

    @Given("Add booking plan without input number of ticket")
    public void addBookingPlanWithoutInputNumberOfTicket() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanWithoutTicket.json");
        bookingAPI.addBookingPlan(json);
    }

    @Given("Add booking plan without input any product")
    public void addBookingPlanWithoutInputAnyProduct() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanWithoutProduct.json");
        bookingAPI.addBookingPlan(json);
    }

    @And("Assert booking plan without input product json schema validator")
    public void addBookingPlanWithoutInputProductJsonSchemaValidator() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/AddBookingWithoutInputProductJsonSchemaValidator.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Add booking plan invalid authorization")
    public void addBookingPlanInvalidAuthorization() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlan.json");
        bookingAPI.addBookingPlanInvalidAuth(json);
    }

    @Given("Add booking plan without input body request")
    public void addBookingPlanWithoutInputBodyRequest() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanEmptyAll.json");
        bookingAPI.addBookingPlan(json);
    }

    @Given("Add booking plan without input ranger")
    public void addBookingPlanWithoutInputRanger() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanWithoutRanger.json");
        bookingAPI.addBookingPlan(json);
    }

    @And("Get created booking id")
    public int getCreatedBookingId() {
        return GlobalEnv.BOOKING_ID = SerenityRest.then().extract().path("data.id_booking");
    }

    @And("Assert that booking id is not {int}")
    public void assertThatBookingIdIsNot(int val) {
        Assert.assertNotEquals(GlobalEnv.BOOKING_ID, val);
    }

    @Given("Add booking plan without input gross amount")
    public void addBookingPlanWithoutInputGrossAmount() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/AddBookingPlanWithoutGrossAmount.json");
        bookingAPI.addBookingPlan(json);
    }
}
