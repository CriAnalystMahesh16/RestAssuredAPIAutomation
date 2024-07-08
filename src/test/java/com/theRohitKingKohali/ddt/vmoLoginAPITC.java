package com.theRohitKingKohali.ddt;

import com.google.gson.Gson;
import com.theRohitKingKohali.utils.UtilsExcel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class vmoLoginAPITC {
   RequestSpecification r2;
   ValidatableResponse vR2;
   Integer ID;
   Response res2;


    @Test(dataProvider = "getData", dataProviderClass = UtilsExcel.class)
    public void testVMOLogin(String email, String password) {
        System.out.println("--Login API Testing");
        System.out.println(email);
        System.out.println(password);

        //Payload
        VMOloginPojo vmOloginPojo = new VMOloginPojo();
        vmOloginPojo.setUsername(email);
        vmOloginPojo.setPassword(password);
        vmOloginPojo.setRecaptchaResponseField("");
        vmOloginPojo.setRemember(false);



        Gson gson=new Gson();
        String payload=gson.toJson(vmOloginPojo);


        //
r2= RestAssured.given();
r2.baseUri("https://app.vwo.com");
r2.basePath("/login");
r2.contentType(ContentType.JSON);
r2.body(vmOloginPojo).log().all();
res2=r2.when().post();
vR2= res2.then();

String resString=res2.asString();
        System.out.println(resString);
        vR2.statusCode(401);



//Rest Assured
    }
}
