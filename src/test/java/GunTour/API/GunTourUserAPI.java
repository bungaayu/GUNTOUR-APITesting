package GunTour.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
//import org.junit.Before;

import java.io.File;

public class GunTourUserAPI {
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE_USER = DIR+"/src/test/resources/JSON";
    public static String BASE_URL_USER= "https://mdanys.online";
    public static String POST_REGISTER=BASE_URL_USER+"/user";
    public static String PUT_USER=BASE_URL_USER+"/user";
    public static String DELETE_USER=BASE_URL_USER+"/user";
    public static String AUTH_USER;
    public static String AUTH_USER_DELETE="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY4MDgzMzczLCJpZCI6MTIwLCJyb2xlIjoicGVuZGFraSJ9.dI1b4wdQsPdB_4S2GBrdvkPGEjWM1Epfk6vMabtgu6U";

    @Step("Post Register User")
    public void postUserRegister(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }


    //    @Step("Put User")
//    public void putUser(File json){
//        SerenityRest.given().contentType(ContentType.JSON)
//                .body(json);
//    }

//    @Step("Login Token")
//    public void loginToken(File json){
//        SerenityRest.given()
//                .contentType(ContentType.JSON)
//                .body(json)
//                .headers("Authorization", TOKEN_USER);
//
//    }

    @Step("Update Put User")
    public void updatePutUser(File json){
        SerenityRest.given().headers("Authorization","Bearer "+AUTH_USER)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Login Update User")
    public void loginUpdateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteUser(){
        SerenityRest.given().headers("Authorization",AUTH_USER_DELETE);
    }

}
