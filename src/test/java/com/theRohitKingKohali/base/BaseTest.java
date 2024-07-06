package com.theRohitKingKohali.base;

import com.theRohitKingKohali.actions.AssertActions;
import com.theRohitKingKohali.endpoints.APIConstants;
import com.theRohitKingKohali.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
// Common to All to TestCase
    //Single Inheritance
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadmanager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;
    @BeforeTest
    public void setUp(){
        System.out.println("Before Test");
         payloadmanager=new PayloadManager();
        assertActions=new AssertActions();
        requestSpecification=new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();



    }
    public String getToken(){
        //Set up the URL
        requestSpecification= RestAssured
                .given()
                .baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);

        //Setting up the Payload

        String payload=payloadmanager.setAuthPayload();

        //Getting the response
        response=requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post();
        // Extracting of the Token via Deserialization.
        String token=payloadmanager
                .getTokenFromJSON(response.asString());

        //verify
        return token;
    }


}
