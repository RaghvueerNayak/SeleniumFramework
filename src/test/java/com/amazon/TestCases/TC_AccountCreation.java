package com.amazon.TestCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Listeners;

//port java.io.IOException;
import java.io.ByteArrayInputStream;

//port org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.Listeners.AllureListener;
import com.amazon.PageObject.CreateAccountPage;
import com.amazon.PageObject.HomePage;
import com.amazon.PageObject.SignInPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({AllureListener.class})
public class TC_AccountCreation extends BaseClass {

	
	@Test(priority = 2, description = "Validate new user deatils for account creation")
	@Description ("New user deatils for new account creation")
	@Epic("Register functionality")
	@Feature("Register with new user functionality")
	@Story("Verify new account creation by providing deatils all fileds ")
	@Step("All fileds")
	public void VerifyCreationAccount_byproviding_allfields() {

		logger.info("***************Start Validate correct values provided to all fileds*****************");

		HomePage Homepg = new HomePage(driver);
		Homepg.HomePageSignInlinkClick();
		logger.info("Clicked on Sign In Button");

		SignInPage signinpg = new SignInPage(driver);
		signinpg.SignInlinkClick();
		logger.info("Clicked on Create your Amazon Account Button");

		CreateAccountPage Createaccpg = new CreateAccountPage(driver);
		Createaccpg.set_custname("Anagha Nayak");
		Createaccpg.set_phonenum("9665239538");
		Createaccpg.set_email("rrraghuveer.nayak@gmail.com");
		Createaccpg.set_passowrd("anagha123");
		Createaccpg.continueButtonClick();
		logger.info("Clicked on verify mobile number button");

	
	}

	@Test(priority = 1, description = "Validate new user deatils for account creation")
	@Description ("New user deatils for new account creation")
	@Epic("Register functionality")
	@Feature("Register new user functionality")
	@Story("Verify new account creation by providing deatils with empty fileds ")
	@Step("Empty fileds")
	public void VerifyCreationAccount_byproviding_emptyfields() {

		logger.info("***************Start Validate blanks values provided to all fileds*****************");

		HomePage Homepg = new HomePage(driver);
		Homepg.HomePageSignInlinkClick();
		logger.info("Clicked on Sign In Button");

		SignInPage signinpg = new SignInPage(driver);
		signinpg.SignInlinkClick();
		logger.info("Clicked on Create your Amazon Account Button");

		CreateAccountPage Createaccpg = new CreateAccountPage(driver);
		Createaccpg.set_custname("");
		Createaccpg.set_phonenum("");
		Createaccpg.set_email("");
		Createaccpg.set_passowrd("");
		Createaccpg.continueButtonClick();
		logger.info("Clicked on verify mobile number button");

		Assert.assertEquals("Enter your name", Createaccpg.Set_BlanknameText());
		Assert.assertEquals("Enter your mobile number", Createaccpg.Set_BlankMobText());
		Assert.assertEquals("Enter your password", Createaccpg.Set_BlankPassText());

		logger.info("Validation Completed for Blank Fileds");

		
	}

	@Test(priority = 0, description = "Validate new user deatils for account creation")
	@Description ("New user deatils for new account creation")
	@Epic("Register functionality")
	@Feature("Register new user functionality")
	@Story("Verify new account creation by providing deatils ")
	@Step("Existance email address fileds existance emaill address")
	public void VerifyexistanceemailAccount() {

		logger.info("***************Start Validate existance email adddress*****************");

		HomePage Homepg = new HomePage(driver);
		Homepg.HomePageSignInlinkClick();
		logger.info("Clicked on Sign In Button");

		SignInPage signinpg = new SignInPage(driver);
		signinpg.SignInlinkClick();
		logger.info("Clicked on Create your Amazon Account Button");

		CreateAccountPage Createaccpg = new CreateAccountPage(driver);
		Createaccpg.set_custname("Anagha Nayak");
		Createaccpg.set_phonenum("9665239538");
		Createaccpg.set_email("raghuveer.nayak@gmail.com");
		Createaccpg.set_passowrd("anagha123");
		Createaccpg.continueButtonClick();
		System.out.println("Value " + Createaccpg.Set_existemailText());
		
		Assert.assertEquals(Createaccpg.Set_existemailText().contains("has already been used"),false,"Email address verification checked");
	    

		logger.info("Validation Completed for Exitance email address");
	}

}
