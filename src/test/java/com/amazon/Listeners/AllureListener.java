package com.amazon.Listeners;
import io.qameta.allure.*;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.amazon.TestCases.BaseClass;

public class AllureListener extends BaseClass implements ITestListener {
	WebDriver driver;
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();}
	// Text attachments for Allure
	@Attachment(value = "Page Screenshot", type = "image/png")
	public byte[] saveScreenshot(WebDriver driver) {
		System.out.println("Screenshot fully captured for test case:" );
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);}
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		//Capture screen shot and stored in folder	
		BaseClass BaseCl = new BaseClass();
		try {
			BaseCl.captureScreenShot(BaseClass.driver, iTestResult.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseClass) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshot(driver);
        }}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", BaseClass.driver);
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	}

	// @Override
	// public void onTestFailure(ITestResult iTestResult) {

	// System.out.println("I am in onTestFailure method " +
	// getTestMethodName(iTestResult) + " failed");
	// Object testClass = iTestResult.getInstance();
	// WebDriver driver = BaseClass.driver;
	// Allure ScreenShotRobot and SaveTestLog
	// if (driver instanceof WebDriver) {
	// System.out.println("Screenshot captured for test case:" +
	// getTestMethodName(iTestResult));
	// saveScreenshotPNG(driver);
	// }
	// Save a log on allure.
	// saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot
	// taken!");
	// }

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}
