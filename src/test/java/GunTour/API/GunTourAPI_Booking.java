package GunTour.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class GunTourAPI_Booking {

    public static String URL = "https://mdanys.online";
    public static String AUTH = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NjYzNzc1LCJpZCI6MTIsInJvbGUiOiJwZW5kYWtpIn0.xojGQI34AK7qHBx3ZvaJlgA92BuA34yAoTLxIfL3OS0";
    public static String INVALID_AUTH = "Bearer diejdeokk933kd3k0";

    public static String GET_BOOKING_HISTORY = URL+"/{path}";
    public static String PATH_ADD_BOOKING_PLAN = URL+"/{path}";
    public static String ADD_BOOKING_PLAN = URL+"/booking";
    public static String BOOKING_DETAIL_BY_ID = URL+"/booking/{id}";
    public static String GET_BOOKING_RANGER = URL+"/booking/{path}";

    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY_BOOKING = DIR+"/src/test/resources/JSON/RequestBody/Booking";
    public static final String JSON_SCHEMA_VALIDATOR_BOOKING = DIR+"/src/test/resources/JSON/JsonSchema/Booking";


    @Step("Get booking history")
    public void getBookingHistory(String path) {
        SerenityRest.given().headers("Authorization", AUTH)
                .pathParam("path", path);
    }
    @Step("Get booking history")
    public void getBookingHistoryInvalidPathInteger(int path) {
        SerenityRest.given().headers("Authorization", AUTH)
                .pathParam("path", path);
    }
    @Step("Get booking history empty authorization")
    public void getBookingHistoryEmptyAuth(String path) {
        SerenityRest.given().pathParam("path",path);
    }
    @Step("Get booking history invalid authorization")
    public void getBookingHistoryInvalidAuth(String path) {
        SerenityRest.given().headers("Authorization", INVALID_AUTH)
                .pathParam("path",path);
    }
    @Step("Add booking plan")
    public void addBookingPlanwithPathParam(String path, File json) {
        SerenityRest.given().headers("Authorization", AUTH)
                .pathParam("path", path)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Add booking plan")
    public void addBookingPlan(File json) {
        SerenityRest.given().headers("Authorization", AUTH)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Add booking plan invalid path with integer")
    public void addBookingPlanInvalidPathInteger(int path) {
        SerenityRest.given().headers("Authorization", AUTH)
                .pathParam("path", path);
    }
    @Step("Add booking plan empty authorization")
    public void addBookingPlanEmptyAuth(String path, File json) {
        SerenityRest.given().pathParam("path", path)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Add booking plan invalid authorization")
    public void addBookingPlanInvalidAuth(File json) {
        SerenityRest.given().headers("Authorization", INVALID_AUTH)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get booking detail")
    public void getBookingDetail(String id) {
        SerenityRest.given().headers("Authorization", AUTH)
                .pathParam("id", id);
    }
    @Step("Get booking detail empty authorization")
    public void getBookingDetailWithoutAuth(String id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get booking detail invalid authorization")
    public void getBookingDetailInvalidAuth(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", INVALID_AUTH);
    }
    @Step("Delete booking plan")
    public void deleteBookingPlan(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", AUTH);
    }
    @Step("Delete booking plan without authorization")
    public void deleteBookingPlanWithoutAuth(String id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete booking plan invalid authorization")
    public void deleteBookingPlanInvalidAuth(String id) {
        SerenityRest.given().pathParam("id", id)
                .headers("Authorization", INVALID_AUTH);
    }

    @Step("Get booking ranger")
    public void getBookingRanger(String path) {
        SerenityRest.given().pathParam("path", path)
                .headers("Authorization", AUTH);
    }
    @Step("Get booking ranger without authorization")
    public void getBookingRangerWithoutAuth(String path) {
        SerenityRest.given().pathParam("path", path);
    }
    @Step("Get booking ranger invalid authorization")
    public void getBookingRangerInvalidAuth(String path) {
        SerenityRest.given().pathParam("path", path)
                .headers("Authorization", INVALID_AUTH);
    }
}
