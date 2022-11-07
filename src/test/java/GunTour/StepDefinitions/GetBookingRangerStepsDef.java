package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetBookingRangerStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
    @Given("Get booking ranger with valid path {string}")
    public void getBookingRangerWithValidPath(String path) {
        bookingAPI.getBookingRanger(path);
    }

    @When("Send request get booking ranger")
    public void sendRequestGetBookingRanger() {
        SerenityRest.when().get(GunTourAPI_Booking.GET_BOOKING_RANGER);
    }

    @Given("Get booking ranger with invalid path {string}")
    public void getBookingRangerWithInvalidPath(String path) {
        bookingAPI.getBookingRanger(path);
    }

    @Given("Get booking ranger with valid path {string} without authorization")
    public void getBookingRangerWithValidPathWithoutAuthorization(String path) {
        bookingAPI.getBookingRangerWithoutAuth(path);
    }

    @Given("Get booking ranger with valid path {string} invalid authorization")
    public void getBookingRangerWithValidPathInvalidAuthorization(String path) {
        bookingAPI.getBookingRangerInvalidAuth(path);
    }
}
