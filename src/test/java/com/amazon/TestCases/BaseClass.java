package com.amazon.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.amazon.Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BaseClass {

	public  static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public String emailAddress = readConfig.getEmail();
	String password = readConfig.getPassword();

	//public static WebDriver driver;
	public static Logger logger;

	@BeforeMethod
	public void setup() {

		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		// implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logging
		logger = LogManager.getLogger("AmazonWord");

		// open url
		driver.get(url);
		logger.info("url opened");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	// user method to capture screen shot
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {

		// get current date time with Date() to create unique file name
		// get current date time with Date()

		String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "\\screenshots\\" + testName + " " + timestamp + ".png");

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}

}
