package com.amazon.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.Listeners.AllureListener;
//import com.amazon.PageObject.CreateAccountPage;
import com.amazon.PageObject.HomePage;
import com.amazon.PageObject.SignInPage;
import com.amazon.Utilities.ReadExcelFile;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;




@Listeners({AllureListener.class})
public class TC_Signin extends BaseClass {
	
	@Test(priority = 1, description = "Validate user deatils for sign in process",dataProvider="LoginDataProvider" )
	@Description ("Validate user deatils for sign in process")
	@Epic("SignIn functionality")
	@Feature("SignIn user functionality")
	@Story("Verify valid Signin creadentials ")
	@Step("All fileds")	
	
	public void Verifyusingvalidcredential(String username, String passwd, String expuser) {

		logger.info("***************Start Validate valid Sign In  credentials (Data driven )*****************");

		HomePage Homepg = new HomePage(driver);
		Homepg.HomePAgeSerachOption();
		logger.info("Option Books Selected");
		Homepg.HomePageSignInlinkClick();
		logger.info("Clicked on Sign In Button");
		
		SignInPage signinpg = new SignInPage(driver);
		signinpg.AcceptEmailadd(username);
		logger.info("Provided correct email address");

		signinpg.ContinueClick();
		logger.info("Clicked on continue button");


		signinpg.Acceptpassword(passwd);
		logger.info("Entered password");
		
		signinpg.signinbuttClick();
		logger.info("Sign in button clicked");
		
		Assert.assertEquals(Homepg.HomePageSignIn().contains(expuser),true,"Username not confirmed from home page ");
		
	}

	
	
	@Test(priority = 2, description = "Validate user deatils for sign in process")
	@Description ("Validate user deatils for sign in process")
	@Epic("SignIn functionality")
	@Feature("SignIn user functionality")
	@Story("Verify invalid Signin creadentials ")
	@Story("Verify valid Signin creadentials ")	
	public void Verifyusinginvalidcredential() {

		logger.info("***************Start Validate invalid Sign In  credentials (without Data driven )*****************");

		HomePage Homepg = new HomePage(driver);
		Homepg.HomePageSignInlinkClick();
		logger.info("Clicked on Sign In Button");

		SignInPage signinpg = new SignInPage(driver);
		signinpg.AcceptEmailadd("raghuveer.nayak45@gmail.com");
		logger.info("Provided incorrect email address");

		signinpg.ContinueClick();
		logger.info("Clicked on continue button");

		Assert.assertEquals(signinpg.invalidemailmsg().contains("We cannot find an account with that email address"),true,"Validation messgae are not captured");
		
		
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\Test Data\\TestdataforAmozon.xlsx";

		
		int ttlRows = ReadExcelFile.getRowCount(fileName, "SignIn");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "SignIn");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"SignIn", i,j);
			}

		}
		return data;
	}
	
}
