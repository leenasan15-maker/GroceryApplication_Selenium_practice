package reportgeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationcore.Base;
import utility.ExtendReportUtility;

public class Listeners implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtendReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

	ITestListener.super.onTestStart(result);
	test = extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {

	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {

	ITestListener.super.onTestFailure(result);

	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());
	
	 Base base = (Base) result.getInstance();
	    WebDriver driver = base.driver;
	//WebDriver driver = null;

	//String testMethodName = result.getMethod().getMethodName();

	}
	public void onTestSkipped(ITestResult result) {

	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");
	String testMethodName = result.getMethod().getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {

	ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {

	ITestListener.super.onFinish(context);
	extent.flush();
	}

}
