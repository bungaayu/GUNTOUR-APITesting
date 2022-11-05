package GunTour.StepDefinitions;

import GunTour.API.GunTourAPI_Booking;
import GunTour.Responses.GunTourResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

public class GetBookingHistoryStepsDef {
    @Steps
    GunTourAPI_Booking bookingAPI;
    GunTourResponse gunTourResponse;
    @Given("Get booking pendaki history with valid path {string}")
    public void getBookingPendakiHistoryWithValidPath(String path) {
        bookingAPI.getBookingHistory(path);
    }

    @When("Send request to get booking pendaki history")
    public void sendRequestToGetBookingPendakiHistory() {
        SerenityRest.when().get(GunTourAPI_Booking.GET_BOOKING_HISTORY);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Should return body contain message {string}")
    public void shouldReturnBodyContainMessage(String message) {
        SerenityRest.then().body(GunTourResponse.MESSAGE, equalTo(message));
    }

    @And("Get booking history json schema validator")
    public void getBookingHistoryJsonSchemaValidator() {
    }

    @Given("Get booking pendaki history invalid path {string} with string value")
    public void getBookingPendakiHistoryInvalidPathWithStringValue(String path) {
        bookingAPI.getBookingHistory(path);
    }

    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Given("Get booking pendaki history invalid path {int} with integer value")
    public void getBookingPendakiHistoryInvalidPathPathWithIntegerValue(int path) {
        bookingAPI.getBookingHistoryInvalidPathInteger(path);
    }

    @Given("Get booking pendaki history valid path {string} empty authorization")
    public void getBookingPendakiHistoryValidPathEmptyAuthorization(String path) {
        bookingAPI.getBookingHistoryEmptyAuth(path);
    }

    @Then("Should return {int} Unauthorized")
    public void shouldReturnUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }

    @Given("Get booking pendaki history valid path {string} invalid authorization")
    public void getBookingPendakiHistoryValidPathInvalidAuthorization(String path) {
        bookingAPI.getBookingHistoryInvalidAuth(path);
    }
}
