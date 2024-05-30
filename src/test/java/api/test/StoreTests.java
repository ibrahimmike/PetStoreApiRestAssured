package api.test;

import api.endpoints.StoreEndpoints;
import api.payload.OrderData;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeClass;
import api.endpoints.UserEndpoints;
import api.payload.MultipleUsers;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import static org.testng.TestRunner.PriorityWeight.priority;

public class StoreTests extends BaseTest {

//    Faker faker;
     OrderData order ;

    @BeforeClass
    public void setup(){
        faker = new Faker();
        order = new OrderData();

        order.setId(faker.idNumber().hashCode());
        order.setComplete(false);
        order.setPetId(faker.idNumber().hashCode());
        order.setQuantity(3);
        order.setShipDate("2024-05-25T15:20:21.140Z");
        order.setStatus("placed");


    }
    @Test(priority= 1)
    public void getInventory(){
        Response response = StoreEndpoints.getInventory();
      //  response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeEndpointsSchema/getInventorySchema.json"));
      Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(priority = 2)
    public void getOrders(){
        Response response = StoreEndpoints.postOrders(order);
       // response.then().log().all();
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeEndpointsSchema/getOrdersResponse.json")).log().all();
    }
    @Test (priority = 3)
    public void getSpecificOrder(){
        Response response = StoreEndpoints.getSingleOrderData(2);
        response.then().log().all();
    }
    @Test(priority = 4)
    public void deleteOrder(){
        Response response = StoreEndpoints.deleteSingleOrder(order.getId());
        response.then().log().all();

    }




}
