package GunTour.StepDefinitions.Booking;

import GunTour.API.GunTourAPI_Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GetBookingDetailStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
    @Given("Get booking detail with valid id")
    public void getBookingDetailWithInvalidId() {
        bookingAPI.getBookingDetailWithGlobalEnv();
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

    @Given("Get booking detail with valid id without authorization")
    public void getBookingDetailWithValidIdWithoutAuthorization() {
        bookingAPI.getBookingDetailWithGlobalEnvWithoutAUTH();
    }

    @Given("Get booking detail with valid id invalid authorization")
    public void getBookingDetailWithValidIdInvalidAuthorization() {
        bookingAPI.getBookingDetailInvalidAuthWithGlobalEnv();
    }
}
