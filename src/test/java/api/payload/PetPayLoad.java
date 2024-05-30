package api.payload;

/*
{
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PetPayLoad {
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;

    private class Tag{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class Category{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(int id, String name) {
//        JSONObject cat = new JSONObject();
//        cat.put("name", name);
//        cat.put("id", id);
        category = new Category();
        category.setId(id);
        category.setName(name);

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return this.photoUrls;
    }

    public void setPhotoUrls(String  photoUrl) {
        //JSONArray photoUrls = new JSONArray();
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add(photoUrl);
        this.photoUrls = photoUrls;
    }

    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    public void setTags(int id, String name) {
        tags = new ArrayList<>();
        Tag tag = new Tag();
        tag.setId(id);
        tag.setName(name);
        tags.add(tag);
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return "id:" + id + "\n" + "category: "+ category.toString() + "\n" + "name:"+ name +"\n" +"photoUrls:"+ photoUrls.toString() + "\n" +
//                "tags:"+ tags.toString() +"\n"+ "status: " + status;
//    }
}
