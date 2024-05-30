package api.test;

import api.endpoints.UserEndpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ResponseTime extends BaseTest {

    @Test
    public void testUserEndpointResponseTime(){
        Response response = UserEndpoints.logoutUser();

        long time = response.timeIn(TimeUnit.MILLISECONDS);
        System.out.println(time);
    }
}
