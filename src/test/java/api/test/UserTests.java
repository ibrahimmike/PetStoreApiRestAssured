package api.test;

import api.endpoints.UserEndpoints;
import api.payload.MultipleUsers;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserTests extends BaseTest {

    //Faker faker ;
    User userPayload;

    @BeforeClass
    public void setUpData(){
      faker = new Faker();

        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail((faker.internet().emailAddress()));
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().phoneNumber());
       // userPayload.setUserStatus(1);
    }

    @Test(priority = 1)
    public void testCreateUser(){
        System.out.println(this.userPayload.getUsername());
        System.out.println(this.userPayload.getFirstname());
        System.out.println(this.userPayload.getLastname());
        System.out.println(userPayload.toString());
       Response response = UserEndpoints.createUser(userPayload);
       response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("usersEndpointResponseSchema/createSingleUser.json"));



       // Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 2)
    public void getUserData(){
        System.out.println( "From the getUSer " + this.userPayload.getUsername());
        Response response = UserEndpoints.readUser(this.userPayload.getUsername());
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("usersEndpointResponseSchema/getUserDataResponseSchema.json"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 3)
    public void updateUser(){
        this.userPayload.setFirstname(faker.name().firstName());
        this.userPayload.setLastname(faker.name().lastName());
        Response repsonse = UserEndpoints.updateUser(userPayload.getUsername(), this.userPayload);
        repsonse.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("usersEndpointResponseSchema/updateUserResponseSchema.json"));
        System.out.println(repsonse.body().print());
        Assert.assertEquals(repsonse.getStatusCode(), 200);
    }
    @Test(priority = 4)
    public void loginUser(){
        Response response = UserEndpoints.loginUser(userPayload.getUsername(), userPayload.getPassword());
        response.then().log().all();
    }
    @Test(priority = 5)
    public void logoutUser(){
        Response response = UserEndpoints.logoutUser();
        response.then().log().all();
    }
    @Test(priority = 6)
    public void deleteUser(){
        Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("usersEndpointResponseSchema/deleteUserResponseSchema.json"));
        Assert.assertEquals(response.statusCode(), 200);

    }
    @Test(priority = 7)
    public void createMultipleUsersWithJsonArray(){
        Response response = UserEndpoints.addUsersAsAnArray(MultipleUsers.getUsers());
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("usersEndpointResponseSchema/createMultipleUsersWithJsonArray.json")).log().all();
    }
    @Test(priority = 8)
    public void createWithList(){

       // List<User> users = new ArrayList<>((Collection) MultipleUsers.getUsers());

        Response response = UserEndpoints.createWithList(MultipleUsers.getUSersAsList());
        response.then().log().all();
    }

}
