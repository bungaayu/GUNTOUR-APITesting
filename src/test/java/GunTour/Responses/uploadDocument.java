package GunTour.Responses;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class uploadDocument {

    @Test
    public void uploadPDFforApplyRanger(){
        File pdfToUpload = new File("F:\\apply form ranger.pdf");

        RestAssured.baseURI = "https://mdanys.online";

        Response response = given()
                .multiPart(pdfToUpload).when().post("/ranger");
    }
}
