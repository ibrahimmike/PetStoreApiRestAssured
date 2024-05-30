package api.payload;

import com.github.javafaker.Faker;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class MultipleUsers {
    
   private static List<User> users = new ArrayList<>();
    
   private static   int numberOfUsers = 5;
    
    private static List<User> createUsers(){
        for (int i = 0; i< numberOfUsers; i++){
            Faker faker = new Faker();
            User user = new User();
            user = new User();
            user.setId(faker.idNumber().hashCode());
            user.setUsername(faker.name().username());
            user.setFirstname(faker.name().firstName());
            user.setLastname(faker.name().lastName());
            user.setEmail((faker.internet().emailAddress()));
            user.setPassword(faker.internet().password());
            user.setPhone(faker.phoneNumber().phoneNumber());
            users.add(user);
        }
        return users;
    }

    public static JSONArray getUsers(){
        createUsers();
        JSONArray usersJson = new JSONArray();
        if (users.size() != 0){
            for( User user : users){
               // JSONTokener jt = new JSONTokener(user.toString());
                JSONObject userJson = new JSONObject(user);
                usersJson.put(userJson);
                System.out.println(user.getUsername());
            }
        }else {
            System.out.println("users is Empty");
        }
        return usersJson;
    }
    public static List<User> getUSersAsList(){
        return createUsers();
    }
}
