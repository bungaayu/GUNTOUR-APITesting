package GunTour.API;

import GunTour.Responses.GlobalEnv;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class GunTourAPI_Admin {

    GlobalEnv globalEnv;
    public static String AUTH = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0MzE1LCJpZCI6Miwicm9sZSI6ImFkbWluIn0.BxrgatwoCX3sXoKrkZCqjC-grjeA-K7A5AphNEaqEDU";
    public static String AUTH_ADMIN;
    public static final String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String URL = "https://mdanys.online";
    public static String LOGIN_ADMIN = "https://mdanys.online/login";
    public static String GET_LIST_PENDAKI = URL+"/admin/pendaki";
//    public static String GET_INV = URL+"/admin";
    public static String GET_LIST_RANGER = URL+"/admin/ranger";
    public static String GET_LIST_BOOKING = URL+"/admin/booking";
    public static String POST_ADD_NEW_PRODUCT = "https://mdanys.online/admin/product";
    public static String GET_LIST_PRODUCT_NOPARAM = URL+"/admin/product";
    public static String GET_LIST_PRODUCT = URL+"/admin/product?page={page}";
    public static String PUT_UPDATE_PRODUCT = URL+"/admin/product/{id_product}";
    public static String DELETE_PRODUCT = URL+"/admin/product/{id_product}";
    public static String POST_TOTAL_PENDAKI = URL+"/admin/pendaki";

    //GET_LIST_PENDAKI
    @Step("Get list pendaki")
    public void getListPendaki(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN);
    }
//    @Step("Get list invalid pendaki")
//    public void getListInvalidPendaki(){
//        SerenityRest.given();
//    }

    //GET_LIST_RANGER
    @Step("Get list ranger")
    public void getListRanger(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN);
    }
    @Step("Get list invalid ranger")
    public void getListInvalidRanger(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN);
    }

    //GET_LIST_BOOKING
    @Step("Get list booking plan")
    public void getListBookingPlan(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN);
    }
    @Step("Get list invalid booking plan")
    public void getListInvalidBookingPlan(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN);
    }

    //POST_ADD_NEW_PRODUCT
    //"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0MzE1LCJpZCI6Miwicm9sZSI6ImFkbWluIn0.BxrgatwoCX3sXoKrkZCqjC-grjeA-K7A5AphNEaqEDU
    @Step("Post add new product")
    public void postAddNewProduct(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Tenda MultiPart")
                .multiPart("rent_price", 100000)
                .multiPart("detail", "Detail MultiPart")
                .multiPart("note", "Note MultiPart")
                .multiPart("product_picture", new File("src/test/resources/documents/Tenda.jpeg"));
    }
    @Step("Post add new product invalid")
    public void postAddNewProductInvalid(File json){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .contentType(ContentType.JSON).body(json);
    }
    @Step("Post add new product invalid")
    public void postAddNewProductInvalid(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .contentType("multipart/form-data")
                .multiPart("product_name", "Tenda Baru MultiPart")
                .multiPart("rent_price", "seratus") //harusnya int, dibuat string
                .multiPart("detail", "Detail Baru MultiPart")
                .multiPart("note", "Note Baru MultiPart")
                .multiPart("product_picture", new File("src/test/resources/documents/Tenda.jpeg"));
    }

    //POST_TOTAL_PENDAKi
    @Step("Post add total pendaki")
    public void postAddTotalPendaki(File json){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .contentType(ContentType.JSON).body(json);
    }

    //GET_LIST_PRODUCT
    @Step("Get list product")
    public void getListProduct(){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN);
    }
    @Step("Get list product with page")
    public void getListProductWithPage(int page){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AUTH_ADMIN)
                .pathParam("page", page);
    }
    @Step("Get list product with string page")
    public void getListProductWithStringPage(String page){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AUTH_ADMIN)
                .pathParam("page", page);
    }

    //PUT_UPDATE_PRODUCT
    @Step("Put update product unavailable id")
    public void putUpdateProductUnavailableId(int id_product){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AUTH_ADMIN)
                .pathParam("id_product", id_product);
    }
    @Step("Put update product string id")
    public void putUpdateProductStringId(String id_product){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .contentType("multipart/form-data")
                .pathParam("id_product", globalEnv.productID)
                .multiPart("product_name", "Tenda Update MultiPart")
                .multiPart("rent_price", 150000)
                .multiPart("detail", "Detail Update MultiPart")
                .multiPart("note", "Note Update MultiPart")
                .multiPart("product_picture", new File("src/test/resources/documents/Tenda Update.jpeg"));
    }
//    @Step("Set put body")
//    public void setPutBody(int id_product){
//        SerenityRest.given()
//                .headers("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3ODk0MzE1LCJpZCI6Miwicm9sZSI6ImFkbWluIn0.BxrgatwoCX3sXoKrkZCqjC-grjeA-K7A5AphNEaqEDU")
//                .contentType("multipart/form-data")
//                .pathParam("id_product", id_product)
//                .multiPart("product_name", "Tenda Update MultiPart")
//                .multiPart("rent_price", 150000)
//                .multiPart("detail", "Detail Update MultiPart")
//                .multiPart("note", "Note Update MultiPart")
//                .multiPart("product_picture", new File("src/test/resources/documents/Tenda Update.jpeg"));
//    }
    @Step("Set put body json")
    public void setPutBodyJson(String id_product,File json){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .pathParam("id_product", globalEnv.productID)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("set put body invalid")
    public void setPutBodyInvalid(String id_product) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+AUTH_ADMIN)
                .contentType("multipart/form-data")
                .pathParam("id_product", globalEnv.productID)
                .multiPart("product_name", "Tenda Update MultiPart")
                .multiPart("rent_price", "seratusribu")
                .multiPart("detail", "Detail Update MultiPart")
                .multiPart("note", "Note Update MultiPart")
                .multiPart("product_picture", new File("src/test/resources/documents/Tenda Update.jpeg"));
    }

    //DELETE_PRODUCT
    @Step("Delete product")
    public void deleteProduct(String id_product){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .pathParam("id_product", globalEnv.productID);
    }
    @Step("Delete product unregistered")
    public void deleteProductUnregistered(int id_product){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .pathParam("id_product", id_product);
    }
    @Step("Delete product invalid")
    public void deleteProductInvalid(String id_product){
        SerenityRest.given().headers("Authorization", "Bearer "+AUTH_ADMIN)
                .pathParam("id_product", id_product);
    }

    //POST_LOGIN
    @Step("Post login admin")
    public void postLoginAdmin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
