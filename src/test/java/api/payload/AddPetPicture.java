package api.payload;

import java.io.File;

public class AddPetPicture {

   private String additionalMetadata;
   private File file;

   public String getAdditionalMetadata() {
      return this.additionalMetadata;
   }

   public void setAdditionalMetadata(String metada) {
      this.additionalMetadata = metada;
   }

   public File getFile() {
      return this.file;
   }

   public void setFile(String path) {

      file = new File(path);
      this.file = file;
   }
}
