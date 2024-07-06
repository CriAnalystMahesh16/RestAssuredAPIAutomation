package com.theRohitKingKohali.actions;


import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class AssertActions {
    public void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(float actual, float expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(double actual, double expected, String description) {
        assertEquals(actual, expected, description);

    }
    public void verifyResponseBody(boolean actual, boolean expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyStatusCodeInvalidReq(Response response) {
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("200"), true,
                "value of status code is" + response.getStatusCode());
    }
    public void verifyStatusCode(Response response,Integer expected) {
        assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStatusCode(Response response) {

    }
}
