package api.extentReport;

public class ExtentReportReporter {

    public static void pass(String message){
        ExtentReportManager.getReport().pass(message);
    }

    public static void fail(String message){
        ExtentReportManager.getReport().fail(message);
    }
    public static void log(String message){
        ExtentReportManager.getReport().info(message);
    }
}
