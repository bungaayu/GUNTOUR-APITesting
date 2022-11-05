package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class AddBookingPlanStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
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

    @And("Add booking plan json schema validator")
    public void addBookingPlanJsonSchemaValidator() {

    }
}
