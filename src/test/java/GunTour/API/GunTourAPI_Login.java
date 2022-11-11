package GunTour.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class GunTourAPI_Login {

    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_LOGIN = DIR+"/src/test/resources/JSON";
    public static String BASE_URL_LOGIN= "https://mdanys.online";
    public static String POST_LOGIN=BASE_URL_LOGIN+"/login";


    @Step("Post Login User")
    public void postLoginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Login Admin")
    public void postLoginAdmin(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
}
