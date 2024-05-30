package api.extentReport;

import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.ss.formula.functions.T;
import org.testng.ITestListener;

public class ExtentReportManager extends ThreadLocal<T> {
    private static ThreadLocal<ExtentTest> report = new ThreadLocal<>();

    protected  static ExtentTest getReport() {
        return report.get();
    }

    protected static void setTest(ExtentTest test){
        report.set(test);
    }

    public static void removeTest(){
        report.remove();
    }

}
