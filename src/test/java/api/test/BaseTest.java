package api.test;

import api.payload.PetPayLoad;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    PetPayLoad payLoad;
    Faker faker;
    Response createPetResponse;
    @BeforeClass
    public void setUp(){
        payLoad = new PetPayLoad();
        faker = new Faker();
        payLoad.setId(faker.idNumber().hashCode());
        payLoad.setName(faker.dog().name());
        payLoad.setCategory(0, "string");
        payLoad.setTags(1, "kabansh");
        payLoad.setStatus("available");
        payLoad.setPhotoUrls("string");

    }

}
