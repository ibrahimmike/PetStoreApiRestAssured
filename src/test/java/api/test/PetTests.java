package api.test;

import api.endpoints.PetEndpoints;
import api.payload.AddPetPicture;
import api.payload.PetPayLoad;
import api.payload.UpdateNameAndStaus;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class PetTests extends BaseTest {



    @Test(priority = 1)
    public void  addPet(){
        createPetResponse = PetEndpoints.addNewPet(payLoad);

//        System.out.println(payLoad.getCategory().toString());
//        System.out.println(payLoad.getId());
//        System.out.println(payLoad.getName());
//        System.out.println(payLoad.getTags().toString());
//        System.out.println(payLoad.getPhotoUrls().toString());
      //  System.out.println(payLoad.toString());
        createPetResponse.then().statusCode(200);
    }
    @Test(priority = 2)
    public void uploadPetPicture(){
       // System.out.println(createPetResponse.jsonPath().get("id").toString());
        String petId = createPetResponse.jsonPath().get("id").toString();
        AddPetPicture petPicture = new AddPetPicture();
        petPicture.setAdditionalMetadata("The new Meta data for the pet");
        petPicture.setFile("images.jpeg");
        Response petMetadata = PetEndpoints.addPetPicture(petId, petPicture);
        petMetadata.then().log().all();

    }
    @Test(priority = 3)
    public void upDatePetInfo(){
        payLoad.setId(payLoad.getId());
        payLoad.setName(faker.dog().name());
        payLoad.setCategory(0, "string");
        payLoad.setTags(1, "kabansh2");
        payLoad.setStatus("available");
        payLoad.setPhotoUrls("images.jpeg");
        Response response = PetEndpoints.updatePetInfo(payLoad);
        response.then().statusCode(200);

    }
    @Test(priority = 4)
    public void findPetByStatus(){
        Response response = PetEndpoints.findPetByStatus("available");
        ArrayList<String> soldArray = new ArrayList<>(response.jsonPath().get("status"));
        System.out.println(soldArray);
        boolean check = soldArray.stream().allMatch(e->e.equals("available"));
         Assert.assertTrue(check);
    }
    @Test(priority = 5)
    public void getPetById(){
        Response response = PetEndpoints.findPetById(payLoad.getId());
        response.then().log().all();
    }
    @Test(priority =  6)
    public void upDatePetNameAndStatusById(){
        UpdateNameAndStaus ns = new UpdateNameAndStaus();
        ns.setName(faker.dog().name());
        ns.setStatus("sold");
        Response response = PetEndpoints.updatePetNameAndStatus(payLoad.getId(),ns);
        response.then().statusCode(200).log().all();
    }
    @Test(priority= 7)
    public void deletePetWithId(){
        Response response = PetEndpoints.deletePet(payLoad.getId());
        response.then().log().all();
    }


}
