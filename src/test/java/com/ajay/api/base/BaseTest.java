package com.ajay.api.base;

import com.ajay.api.utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import org.testng.annotations.*;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;


public class BaseTest {
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.createInstance("reports/extent.html");
    }

    
    @BeforeClass
     public void setupBaseURI() {
    RestAssured.baseURI = "https://reqres.in/api";
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
}


    @AfterMethod
    public void flushReport() {
        extent.flush();
    }

    @AfterSuite
    public void closeReport() {
        extent.flush();
    }
}
