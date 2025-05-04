package com.ajay.api.tests;

import com.ajay.api.base.BaseTest;
import com.ajay.api.endpoints.UserEndpoints;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTests extends BaseTest {

    @Test(priority = 1)
    public void testGetUsers() {
        test = extent.createTest("GET Users Test");
        Response response = UserEndpoints.getUsers();
        test.log(Status.INFO, "Fetching users from /users endpoint");
        Assert.assertEquals(response.statusCode(), 200);
        test.log(Status.PASS, "GET /users successful");
    }

    @Test(priority = 2)
    public void testAddUser() {
        test = extent.createTest("POST Add User Test");
        Response response = UserEndpoints.addUser("Ajay", "QA Engineer");
        test.log(Status.INFO, "Adding new user with POST");
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertTrue(response.getBody().asString().contains("Ajay"));
        test.log(Status.PASS, "POST /users successful");
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        test = extent.createTest("PUT Update User Test");
        Response response = UserEndpoints.updateUser("2", "Ajay", "SDET");
        test.log(Status.INFO, "Updating user with PUT");
        Assert.assertEquals(response.statusCode(), 200);
        test.log(Status.PASS, "PUT /users/2 successful");
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        test = extent.createTest("DELETE User Test");
        Response response = UserEndpoints.deleteUser("2");
        test.log(Status.INFO, "Deleting user with DELETE");
        Assert.assertEquals(response.statusCode(), 204);
        test.log(Status.PASS, "DELETE /users/2 successful");
    }
}
