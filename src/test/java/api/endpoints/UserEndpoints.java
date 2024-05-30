package api.endpoints;


import api.payload.MultipleUsers;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;

import javax.swing.text.AbstractDocument;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserEndpoints {

    public static Response createUser(User payload){
       return given()
               .contentType(ContentType.JSON)
               .accept(ContentType.JSON)
               .body(payload)
               .log().body()
                .when().post(Routes.post_url);
    }
    public static Response readUser(String userName){
        return  given()
                .pathParam("username",userName)
                .when().get(Routes.get_url);
    }
    public static Response updateUser(String userName, User payload){
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when().put(Routes.update_url);
    }
    public static Response deleteUser(String userName){
        return given()
                .pathParam("username", userName)
                .when().delete(Routes.delete_url);
    }
    public static Response addUsersAsAnArray(JSONArray users){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(users.toString())
                .when().post(Routes.addUsersAsArray_url);
    }

    public static Response loginUser(String userName, String userPassword){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .queryParam("username",userName)
                .queryParam("password", userPassword)
                .get(Routes.userLogin_url);
    }
    public static Response logoutUser(){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().get(Routes.userLogout_url);
    }
    public static Response createWithList(List<User> users){

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(users)
                .when().post(Routes.createUsersWithList_url);

    }
}
