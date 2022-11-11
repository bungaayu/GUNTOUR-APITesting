package GunTour.StepDefinitions.Login;

import GunTour.API.GunTourAPI_Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class PostLoginStepDef {
    @Steps
    GunTourAPI_Login gunTourAPILogin;

    //User Login
    @Given("Post login user with valid json file")
    public void postLoginUserWithValidJsonFile(){
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyValidUser.json");
        gunTourAPILogin.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(GunTourAPI_Login.POST_LOGIN);
    }

    @Then("API response status code should be {int} accepted")
    public void apiResponseStatusCodeShouldBeOK(int accepted) {
        SerenityRest.then().statusCode(accepted);
    }

    @Given("Post login user with invalid password json file")
    public void postLoginUserWithInvalidPasswordJsonFile() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyInvalidPassword.json");
        gunTourAPILogin.postLoginUser(json);
    }

    @Then("API response status code should be {int} Bad Request")
    public void apiResponseStatusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @Given("Post login user with invalid email json file")
    public void postLoginUserWithInvalidEmailJsonFile() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyInvalidEmail.json");
        gunTourAPILogin.postLoginUser(json);
    }

    @Given("Post login user with invalid email & invalid password")
    public void postLoginUserWithInvalidEmailInvalidPassword() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyInvalidEmailAndPassword.json");
        gunTourAPILogin.postLoginUser(json);
    }

    @Given("Post login user without email")
    public void postLoginUserWithoutEmail() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyWithoutEmail.json");
        gunTourAPILogin.postLoginUser(json);
    }

    @Given("Post login user without password")
    public void postLoginUserWithoutPassword() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyWithoutPassword.json");
        gunTourAPILogin.postLoginUser(json);
    }

    @Given("Post login user without email & password")
    public void postLoginUserWithoutEmailPassword() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyWithoutEmailAndPassword.json");
        gunTourAPILogin.postLoginUser(json);
    }


    @Given("User Login with invalid path")
    public void userLoginWithInvalidPath() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyValidUser.json");
        gunTourAPILogin.postLoginUser(json);
    }

    @When("Send request post login user invalid path")
    public void sendRequestPostLoginUserInvalidPath() {
        SerenityRest.when().post(GunTourAPI_Login.BASE_URL_LOGIN+"/lologin");
    }

    @Then("API response status code should be {int} Not Found")
    public void apiResponseStatusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    //Admin Login
    @Given("Post login admin with valid json file")
    public void postLoginAdminWithValidJsonFile() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyValidAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @When("Send request post login admin")
    public void sendRequestPostLoginAdmin() {
        SerenityRest.when().post(GunTourAPI_Login.POST_LOGIN);
    }

    @Given("Post login Admin with invalid password json file")
    public void postLoginAdminWithInvalidPasswordJsonFile() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyInvalidPasswordAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @Given("Post login admin with invalid email json file")
    public void postLoginAdminWithInvalidEmailJsonFile() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyInvalidEmailAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @Given("Post login admin with invalid email & invalid password")
    public void postLoginAdminWithInvalidEmailInvalidPassword() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyInvalidEmailAndPasswordAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @Given("Post login admin without email")
    public void postLoginAdminWithoutEmail() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyWithoutEmailAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @Given("Post login admin without password")
    public void postLoginAdminWithoutPassword() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyWithoutPasswordAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @Given("Post login admin without email & password")
    public void postLoginAdminWithoutEmailPassword() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyWithoutEmailAndPasswordAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @Given("Admin Login with invalid path")
    public void adminLoginWithInvalidPath() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/LoginRequestBody/LoginRequestBodyValidAdmin.json");
        gunTourAPILogin.postLoginAdmin(json);
    }

    @When("Send request post login admin invalid path")
    public void sendRequestPostLoginAdminInvalidPath() {
        SerenityRest.when().post(GunTourAPI_Login.BASE_URL_LOGIN+"/lologin");
    }
}
