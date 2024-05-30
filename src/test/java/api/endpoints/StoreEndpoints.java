package api.endpoints;

import api.payload.OrderData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndpoints {

    public static Response getInventory(){
        return given()
                .accept("application/json")
                .when().get(Routes.getStoreInventory_url);
    }
    public static Response postOrders(OrderData order){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(order)
                .when().post(Routes.getStoreOrders_url);
    }
    public static Response getSingleOrderData(int id){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .when().get(Routes.getSingleOrder_url);
    }
    public static Response deleteSingleOrder(int id){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id",id)
                .when().delete(Routes.deleteOrder_url);
    }
}
