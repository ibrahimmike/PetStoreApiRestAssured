package api.endpoints;


import io.restassured.RestAssured;

public class Routes {
    public static String base_url ="https://petstore.swagger.io/v2";



    /*
    User endpoints
     */

    public static String post_url = base_url+"/user";
    public static String get_url = base_url+"/user/{username}";
    public static String update_url = base_url+"/user/{username}";
    public static String delete_url = base_url +"/user/{username}";
    public static String addUsersAsArray_url = base_url + "/user/createWithArray";
    public static String createUsersWithList_url = base_url +"/user/createWithList";
    public static String userLogin_url = base_url +"/user/login";
    public static String userLogout_url = base_url +"/user/logout";

    //Store endpoints

    public static String getStoreInventory_url = base_url + "/store/inventory";
    public static String getStoreOrders_url = base_url + "/store/order";
    public static String getSingleOrder_url = base_url + "/store/order/{id}";
    public static String deleteOrder_url = base_url + "/store/order/{id}";



    //pet endpoints
    public static String postAddPet_url = base_url +"/pet";
    public static String addPetPicture_url = base_url +"/pet/{petId}/uploadImage";
    public static String updatePetInfo_url = base_url +"/pet";
    public static String getPetByStatus_url = base_url +"/pet/findByStatus";
    public static String getPetById_url = base_url + "/pet/{petId}";
    public static String updatePetNameAndStatus = base_url + "/pet/{id}";
    public static String deletePet_url = base_url + "/pet/{id}";









}
