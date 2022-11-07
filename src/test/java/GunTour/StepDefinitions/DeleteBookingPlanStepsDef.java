package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteBookingPlanStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
    AddBookingPlanStepsDef addBookingPlanStepsDef;
    @Given("Delete booking plan with valid id {string}")
    public void deleteBookingPlanWithValidId(String id) {
        bookingAPI.deleteBookingPlanWithString(id);
    }

    @When("Send request delete booking plan by id")
    public void sendRequestDeleteBookingPlanById() {
        SerenityRest.when().delete(GunTourAPI_Booking.BOOKING_DETAIL_BY_ID);
    }

    @Given("Delete booking plan with valid id {string} empty authorization")
    public void deleteBookingPlanWithValidIdEmptyAuthorization(String id) {
        bookingAPI.deleteBookingPlanWithoutAuth(id);
    }

    @Given("Delete booking plan with valid id {string} invalid authorization")
    public void deleteBookingPlanWithValidIdInvalidAuthorization(String id) {
        bookingAPI.deleteBookingPlanInvalidAuth(id);
    }

    @Given("Delete booking plan with deleted id")
    public void deleteBookingPlanWithDeletedId() {
        bookingAPI.deleteBookingPlanWithGlobalEnv();
    }

    @Then("Should return {int} Internal Server Error")
    public void shouldReturnInternalServerError(int internalServerError) {
        SerenityRest.then().statusCode(internalServerError);
    }

    @Given("Delete booking plan with invalid id {string}")
    public void deleteBookingPlanWithInvalidId(String id) {
        bookingAPI.deleteBookingPlanWithString(id);
    }

    @Given("Delete booking plan with created id")
    public void deleteBookingPlanWithCreatedId() {
        bookingAPI.deleteBookingPlanWithGlobalEnv();
    }
}
