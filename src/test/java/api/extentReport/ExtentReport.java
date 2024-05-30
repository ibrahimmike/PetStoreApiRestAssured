package api.extentReport;

import api.utilities.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

    private static ExtentTest test;

    private static ExtentReports extentReports;

    public static void extentInit(){

        extentReports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(Constants.extentReportPath);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("PetStore API Tests");
        spark.config().setReportName("Complete API test");
        extentReports.attachReporter(spark);
    }

    public static void createTest(String testName){
        test = extentReports.createTest(testName);
        ExtentReportManager.setTest(test);
    }
    public static void closeTest(){
        ExtentReportManager.removeTest();
        extentReports.flush();
    }




}
