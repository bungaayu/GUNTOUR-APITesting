package GunTour.API;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GunTourAPI_Products {

    public static final String URL = "https://mdanys.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_SCHEMA_PRODUCTS = DIR+"/src/test/resources/JSON/JsonSchema/Products";

    public static String GET_PRODUCT = URL+"/product?page={page}";
    public static String GET_PRODUCT_INVALID_PARAMER = URL+"/@!@!#$product?page={page}";
    public static String GET_PRODUCT_NO_PARAM = URL+"/page{id}";
    public static String GET_PRODUCT_DETAILS = URL+"/product/{id}";
    public static String GET_PRODUCT_DETAILS_INVALID_PARAMETER = URL+"/product+=/{id}";
    public static String GET_PRODUCT_DETAILS_NO_PARAM = URL+"product{id}";

    @Step("get product int")
    public void setGetProduct(int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("get product string")
    public void getProduct(String page) {
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("get product detail")
    public void setGetProductDetails(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("get product detail")
    public void GetProductDetails(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
