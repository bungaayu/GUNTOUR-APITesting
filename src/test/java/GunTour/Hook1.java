package GunTour;

import GunTour.API.GunTourAPI_Ranger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;
import static GunTour.API.GunTourAPI_Ranger.URL;

public class Hook1 {


    @Before("@loginUserFauzan")
    public void loginUserFauzan(){
        File json = new File("src/test/resources/JSON/RequestBody/Login/validLoginUserFauzan.json");
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .post(URL+"/login");
        JsonPath jsonPath = response.jsonPath();
        GunTourAPI_Ranger.USER_FAUZAN_TOKEN_DINAMIS = "Bearer "+ jsonPath.get("data.token");
    }

    @After
    public void reset_token_fauzan(){
        GunTourAPI_Ranger.USER_FAUZAN_TOKEN_DINAMIS = "x";
        GunTourAPI_Ranger.ADMIN_FAUZAN_TOKEN_DINAMIS = "x";
    }
}
