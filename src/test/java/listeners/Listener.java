package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import base.Base;

public class Listener extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.INFO, result.getName() + " has started");
	}

	public void onTestSuccess(ITestResult result) {
		try {
			//test.log(Status.PASS, result.getName() + " has Passed");

			// System.out.println(getScreenshot() +"<--PATH");

			// test.log(Status.PASS,
			// result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
			test.log(Status.PASS, result.getName() + " passed",
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		} catch (Exception e) {
			System.out.println("Exception in onTestSuccess" + e.getMessage());
		}
	}

	public void onTestFailure(ITestResult result) {
		// test.log(Status.FAIL, result.getThrowable());

		try {
			//test.log(Status.FAIL, result.getThrowable());
			test.log(Status.FAIL, result.getName() + " failed",
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot()).build());
		} catch (Exception e) {

			System.out.println("Exception in onTestFailure" + e.getMessage());
		}
		// afterMethod();
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName() + " skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		flushExtent();

	}

}