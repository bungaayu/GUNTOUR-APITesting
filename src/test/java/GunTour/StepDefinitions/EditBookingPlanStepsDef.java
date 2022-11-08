package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class EditBookingPlanStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
    @Given("Edit booking plan with all valid value id")
    public void editBookingPlanWithAllValidValue() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlan.json");
        bookingAPI.editBookingPlan(json);
    }

    @When("Send request put edit booking plan")
    public void sendRequestPutEditBookingPlan() {
        SerenityRest.when().put(GunTourAPI_Booking.BOOKING_DETAIL_BY_ID);
    }

    @Then("Should return {int} Accepted")
    public void shouldReturnAccepted(int accepted) {
        SerenityRest.then().statusCode(accepted);
    }

    @Given("Edit booking plan with invalid id {string}")
    public void editBookingPlanWithInvalidId(String id) {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlan.json");
        bookingAPI.editBookingPlanInvalidID(id, json);
    }

    @Given("Edit booking plan without authorization with id")
    public void editBookingPlanWithoutAuthorizationWithId() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlan.json");
        bookingAPI.editBookingPlanWithoutAuth(json);
    }

    @Given("Edit booking plan invalid authorization with id")
    public void editBookingPlanInvalidAuthorizationWithId() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlan.json");
        bookingAPI.editBookingPlanInvalidAuth(json);
    }

    @Given("Edit booking plan valid id without input start date")
    public void editBookingPlanValidIdWithoutInputStartDate() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlanWithoutStartDate.json");
        bookingAPI.editBookingPlan(json);
    }

    @Given("Edit booking plan valid id without input end date")
    public void editBookingPlanValidIdWithoutInputEndDate() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlanWithoutEndDate.json");
        bookingAPI.editBookingPlan(json);
    }

    @Given("Edit booking plan valid id without input entrance")
    public void editBookingPlanValidIdWithoutInputEntrance() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlanWithoutEntrance.json");
        bookingAPI.editBookingPlan(json);
    }

    @Given("Edit booking plan valid id without input ticket")
    public void editBookingPlanValidIdWithoutInputTicket() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlanWithoutTicket.json");
        bookingAPI.editBookingPlan(json);
    }

    @Given("Edit booking plan valid id without input ranger")
    public void editBookingPlanValidIdWithoutInputRanger() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlanWithoutRanger.json");
        bookingAPI.editBookingPlan(json);
    }

    @Given("Edit booking plan with all valid created ID booking")
    public void editBookingPlanWithAllValidCreatedIDBooking() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlan.json");
        bookingAPI.editBookingPlan(json);
    }

    @Given("Edit booking plan valid id without input status")
    public void editBookingPlanValidIdWithoutInputStatus() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlanWithoutStatus.json");
        bookingAPI.editBookingPlan(json);
    }

    @Given("Edit booking plan valid id without input body request")
    public void editBookingPlanValidIdWithoutInputBodyRequest() {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlanEmptyAll.json");
        bookingAPI.editBookingPlan(json);
    }

    @And("Assert json schema edit booking plan")
    public void assertJsonSchemaEditBookingPlan() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/EditBookingPlanJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Assert json schema edit booking plan without input start date")
    public void assertJsonSchemaEditBookingPlanWithoutInputStartDate() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/EditBookingPlanWithoutStartDateJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Assert json schema edit booking plan without input end date")
    public void assertJsonSchemaEditBookingPlanWithoutInputEndDate() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/EditBookingPlanWithoutEndDateJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Assert json schema edit booking plan without input entrance")
    public void assertJsonSchemaEditBookingPlanWithoutInputEntrance() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/EditBookingPlanWithoutEntranceJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Assert json schema edit booking plan without input ticket")
    public void assertJsonSchemaEditBookingPlanWithoutInputTicket() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/EditBookingPlanWithoutTicketJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Assert json schema edit booking plan without input ranger")
    public void assertJsonSchemaEditBookingPlanWithoutInputRanger() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/EditBookingPlanWithoutRangerJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Assert json schema edit booking plan without input status")
    public void assertJsonSchemaEditBookingPlanWithoutInputStatus() {
        File json = new File(GunTourAPI_Booking.JSON_SCHEMA_VALIDATOR_BOOKING+"/EditBookingPlanWithoutStatusJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
