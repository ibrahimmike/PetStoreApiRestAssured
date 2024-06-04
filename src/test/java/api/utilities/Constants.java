package api.utilities;

import java.util.Date;

public class Constants {

   private static Date dt = new Date();
    public static String extentReportPath = createExtentReportPath();




    private static String createExtentReportPath(){
        if(ReadPropertyFiles.getProperty("overrideResults").equalsIgnoreCase("no")){
            return "testOutput/" + dt.toString()+"test.html";
        }else {
            return "testOutput/"+"test.html";
        }
    }
}
