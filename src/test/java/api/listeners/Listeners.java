package api.listeners;

import api.extentReport.ExtentReport;
import api.extentReport.ExtentReportManager;
import api.extentReport.ExtentReportReporter;
import org.testng.*;

public class Listeners implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        ExtentReport.extentInit();

    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        ExtentReport.closeTest();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);

        ExtentReport.createTest(result.getTestContext().getName()+ " : " + "\n" + result.getTestClass().getName() );
        //+result.getMethod().getMethodName()
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        ExtentReportReporter.pass(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
       // ExtentReportReporter.fail(result.getMethod().getMethodName());
       ExtentReportReporter.fail(result.getMethod().getMethodName() + " test thrown error:  " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }




}
