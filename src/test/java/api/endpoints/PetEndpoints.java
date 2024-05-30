package api.endpoints;

import api.payload.AddPetPicture;
import api.payload.PetPayLoad;
import api.payload.UpdateNameAndStaus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndpoints {

    public static Response addNewPet(PetPayLoad pet){

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .log().body()
                .when().
                post(Routes.postAddPet_url);

    }
    public static Response addPetPicture(String id, AddPetPicture file){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .pathParam("petId",id)
                .multiPart("additionalMetadata",file.getAdditionalMetadata(), "text/plain")
                .multiPart("file" , file.getFile())
                .log().all()
                .when()
                .post(Routes.addPetPicture_url);
    }
    public static Response updatePetInfo(PetPayLoad pet){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .put(Routes.updatePetInfo_url);

    }
    public static Response findPetByStatus(String status){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("status", status)
                .when().get(Routes.getPetByStatus_url);
    }
    public static Response findPetById(int petID){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("petId",petID)
                .when()
                .get(Routes.getPetById_url);
    }

    public static Response updatePetNameAndStatus(int id, UpdateNameAndStaus data){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.URLENC)
                .pathParam("id",id)
                .formParam("name", data.getName())
                .formParam("status", data.getStatus())
                .when().post(Routes.updatePetNameAndStatus);
    }
    public static Response deletePet(int id){
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("api_key", "ergergewrgergerg")
                .pathParam("id", id)
                .log().all()
                .when().delete(Routes.deletePet_url);
    }
}
