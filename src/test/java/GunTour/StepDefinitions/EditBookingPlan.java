package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class EditBookingPlan {
    @Steps
    GunTourAPI_Booking bookingAPI;
    @Given("Edit booking plan with all valid value id {string}")
    public void editBookingPlanWithAllValidValue(String id) {
        File json = new File(GunTourAPI_Booking.JSON_REQUEST_BODY_BOOKING +"/EditBookingPlan.json");
        bookingAPI.editBookingPlan(id, json);
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
    }

    @Given("Edit booking plan without authorization with id {string}")
    public void editBookingPlanWithoutAuthorizationWithId(String id) {
    }

    @Given("Edit booking plan invalid authorization with id {string}")
    public void editBookingPlanInvalidAuthorizationWithId(String id) {
    }

    @Given("Edit booking plan valid id {string} without input start date")
    public void editBookingPlanValidIdWithoutInputStartDate(String id) {
    }

    @Given("Edit booking plan valid id {string} without input end date")
    public void editBookingPlanValidIdWithoutInputEndDate(String id) {
    }

    @Given("Edit booking plan valid id {string} without input entrance")
    public void editBookingPlanValidIdWithoutInputEntrance(String id) {
    }

    @Given("Edit booking plan valid id {string} without input ticket")
    public void editBookingPlanValidIdWithoutInputTicket(String id) {
    }

    @Given("Edit booking plan valid id {string} without input ranger")
    public void editBookingPlanValidIdWithoutInputRanger(String id) {
    }
}
