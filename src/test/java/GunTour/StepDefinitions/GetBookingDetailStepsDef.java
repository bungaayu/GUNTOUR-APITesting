package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetBookingDetailStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
    @Given("Get booking detail with valid id {string}")
    public void getBookingDetailWithValidId(String id) {
        bookingAPI.getBookingDetail(id);
    }

    @When("Send request get booking detail")
    public void sendRequestGetBookingDetail() {
        SerenityRest.when().get(GunTourAPI_Booking.BOOKING_DETAIL_BY_ID);
    }

    @Given("Get booking detail invalid id outside maximal expected value {string}")
    public void getBookingDetailInvalidIdOutsideMaximalExpectedValue(String id) {
        bookingAPI.getBookingDetail(id);
    }

    @Given("Get booking detail invalid id with value string {string}")
    public void getBookingDetailInvalidIdWithValueString(String id) {
        bookingAPI.getBookingDetail(id);
    }

    @Given("Get booking detail with valid id {string} without authorization")
    public void getBookingDetailWithValidIdWithoutAuthorization(String id) {
        bookingAPI.getBookingDetailWithoutAuth(id);
    }

    @Given("Get booking detail with valid id {string} invalid authorization")
    public void getBookingDetailWithValidIdInvalidAuthorization(String id) {
        bookingAPI.getBookingDetailInvalidAuth(id);
    }
}
