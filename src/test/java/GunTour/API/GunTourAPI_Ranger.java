package GunTour.API;

import GunTour.Responses.GlobalEnv;
import com.gargoylesoftware.htmlunit.javascript.host.fetch.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.given;

public class GunTourAPI_Ranger {

    public static final String URL = "https://mdanys.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY_RANGER = DIR+"/src/test/resources/JSON/RequestBody/Ranger";
    public static final String JSON_SCHEMA_RANGER = DIR+"/src/test/resources/JSON/JsonSchema/Ranger";

    public static String POST_RANGER = URL+"/ranger";
    public static String POST_RANGER_WITH_INVALID_PARAMETER = URL+"/=ranger";
    public static String POST_RANGER_WITHOUT_PARAMETER = URL+"/";
    public static String GET_RANGER = URL+"/ranger?date_start={date_start}&date_end={date_end}";
    public static String GET_RANGER_WITH_INVALID_PARAMETER = URL+"/=-/ranger?date_start={date_start}&date_end={date_end}";
    public static String GET_RANGER_WITHOUT_PARAMETER = URL+"/rangerdate_start={date_start}&date_end={date_end}";
    public static String PUT_UPDATE_RANGER = URL+"/admin/ranger/{id_ranger}";
    public static String PUT_UPDATE_RANGER_INVALID_PARAMETER = URL+"/admin/ranger==-/";
    public static String PUT_UPDATE_RANGER_NO_PARAMETER = URL+"/";
    public static String PUT_UPDATE_RANGER_WITH_NO_ID = URL+"/admin/ranger/";
    public static String USER_FAUZAN_TOKEN_STATIS = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3OTk1MzkwLCJpZCI6NDksInJvbGUiOiJwZW5kYWtpIn0.dXjffnlmyH7LY_GEN74Lz_hTmqGwwkfE1eLqF5USAzc";
    public static String USER_FAUZAN_TOKEN_DINAMIS = "";
    public static String ADMIN_FAUZAN_TOKEN_STATIS = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3OTk1NDQwLCJpZCI6Miwicm9sZSI6ImFkbWluIn0.Q73MF9gbqrrmV9Pc3PMrjkYB1SEW_BqMdM9qZz54mQI";
    public static String ADMIN_FAUZAN_TOKEN_DINAMIS = "";
    public static String GET_LIST_RANGER_APPLY = URL+"/admin/ranger";

    @Step("post apply as ranger valid body")
    public void postApplyAsRangerValidBody() {
        given().headers("Authorization", USER_FAUZAN_TOKEN_STATIS)
                .contentType("multipart/form-data")
                .multiPart("fullname", "Bambang Gentoled")
                .multiPart("ttl", "Surabaya, 31 Desember 1945")
                .multiPart("address", "Jl. Ir. Asep Syaepuloh")
                .multiPart("phone", "081919191919")
                .multiPart("gender", "Laki-Laki")
                .multiPart("docs", new File("src/test/resources/documentToUpload/apply_form_ranger.pdf"));
    }

    @Step("post apply as ranger without fullname")
    public void postApplyAsRangerWithoutfullname() {
        given().headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0ODQxLCJpZCI6MTgsInJvbGUiOiJwZW5kYWtpIn0.-IATEY_pngGU7Ac-XXy9uZKEmfzb91DZjhDsnJnWB78")
                .contentType("multipart/form-data")
//                .multiPart("fullname", "Bambang Gentoled")
                .multiPart("ttl", "Surabaya, 31 Desember 1945")
                .multiPart("address", "Jl. Ir. Asep Syaepuloh")
                .multiPart("phone", "081919191919")
                .multiPart("gender", "Laki-Laki")
                .multiPart("docs", new File("src/test/resources/documentToUpload/apply_form_ranger.pdf"));
    }

    @Step("post apply as ranger without ttl")
    public void postApplyAsRangerWithoutttl() {
        given().headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0ODQxLCJpZCI6MTgsInJvbGUiOiJwZW5kYWtpIn0.-IATEY_pngGU7Ac-XXy9uZKEmfzb91DZjhDsnJnWB78")
                .contentType("multipart/form-data")
                .multiPart("fullname", "Bambang Gentoled")
//                .multiPart("ttl", "Surabaya, 31 Desember 1945")
                .multiPart("address", "Jl. Ir. Asep Syaepuloh")
                .multiPart("phone", "081919191919")
                .multiPart("gender", "Laki-Laki")
                .multiPart("docs", new File("src/test/resources/documentToUpload/apply_form_ranger.pdf"));
    }

    @Step("post apply as ranger without address")
    public void postApplyAsRangerWithoutaddress() {
        given().headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0ODQxLCJpZCI6MTgsInJvbGUiOiJwZW5kYWtpIn0.-IATEY_pngGU7Ac-XXy9uZKEmfzb91DZjhDsnJnWB78")
                .contentType("multipart/form-data")
                .multiPart("fullname", "Bambang Gentoled")
                .multiPart("ttl", "Surabaya, 31 Desember 1945")
//                .multiPart("address", "Jl. Ir. Asep Syaepuloh")
                .multiPart("phone", "081919191919")
                .multiPart("gender", "Laki-Laki")
                .multiPart("docs", new File("src/test/resources/documentToUpload/apply_form_ranger.pdf"));
    }

    @Step("post apply as ranger without phone")
    public void postApplyAsRangerWithoutphone() {
        given().headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0ODQxLCJpZCI6MTgsInJvbGUiOiJwZW5kYWtpIn0.-IATEY_pngGU7Ac-XXy9uZKEmfzb91DZjhDsnJnWB78")
                .contentType("multipart/form-data")
                .multiPart("fullname", "Bambang Gentoled")
                .multiPart("ttl", "Surabaya, 31 Desember 1945")
                .multiPart("address", "Jl. Ir. Asep Syaepuloh")
//                .multiPart("phone", "081919191919")
                .multiPart("gender", "Laki-Laki")
                .multiPart("docs", new File("src/test/resources/documentToUpload/apply_form_ranger.pdf"));
    }

    @Step("post apply as ranger without gender")
    public void postApplyAsRangerWithoutgender() {
        given().headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0ODQxLCJpZCI6MTgsInJvbGUiOiJwZW5kYWtpIn0.-IATEY_pngGU7Ac-XXy9uZKEmfzb91DZjhDsnJnWB78")
                .contentType("multipart/form-data")
                .multiPart("fullname", "Bambang Gentoled")
                .multiPart("ttl", "Surabaya, 31 Desember 1945")
                .multiPart("address", "Jl. Ir. Asep Syaepuloh")
                .multiPart("phone", "081919191919")
//                .multiPart("gender", "Laki-Laki")
                .multiPart("docs", new File("src/test/resources/documentToUpload/apply_form_ranger.pdf"));
    }

    @Step("post apply as ranger without docs")
    public void postApplyAsRangerWithoutdocs() {
        given().headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0ODQxLCJpZCI6MTgsInJvbGUiOiJwZW5kYWtpIn0.-IATEY_pngGU7Ac-XXy9uZKEmfzb91DZjhDsnJnWB78")
                .contentType("multipart/form-data")
                .multiPart("fullname", "Bambang Gentoled")
                .multiPart("ttl", "Surabaya, 31 Desember 1945")
                .multiPart("address", "Jl. Ir. Asep Syaepuloh")
                .multiPart("phone", "081919191919")
                .multiPart("gender", "Laki-Laki");
//                .multiPart("docs", new File("src/test/resources/documentToUpload/apply_form_ranger.pdf"))
    }

    @Step("get ranger list")
    public void getRangerList(String date_start, String date_end){
              given().log().all()
                    .pathParam("date_start", date_start)
                    .given()
                    .header("Authorization", USER_FAUZAN_TOKEN_STATIS)
                    .pathParam("date_end", date_end);
    }

    @Step("put update ranger apply status")
    public void putUpdateRangerApplyStatus(File json, int id_ranger){
             given().log().all()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3OTgyNTA4LCJpZCI6Miwicm9sZSI6ImFkbWluIn0.aA4h2zKOSzCcWq-X57IBt1a1HZpf4BH8FP-KNcqLr-U")
                .pathParam("id_ranger", id_ranger)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("put update ranger apply status")
    public void putUpdateRangerApplyStatusWithNoID(File json){
             given().log().all()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3OTgyNTA4LCJpZCI6Miwicm9sZSI6ImFkbWluIn0.aA4h2zKOSzCcWq-X57IBt1a1HZpf4BH8FP-KNcqLr-U")
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("get ranger list apply")
    public void getRangerListApply(){
        given().header("Authorization", ADMIN_FAUZAN_TOKEN_STATIS);
    }
}