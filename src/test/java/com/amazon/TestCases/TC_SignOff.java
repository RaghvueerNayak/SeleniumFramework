package com.amazon.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.Listeners.AllureListener;
import com.amazon.PageObject.CreateAccountPage;
import com.amazon.PageObject.HomePage;
import com.amazon.PageObject.SignInPage;
import com.amazon.PageObject.SignOffPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import com.amazon.PageObject.Puzzlepage;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class TC_SignOff extends BaseClass {
	
	@Test(description = "Validate user deatils for sign in process")
	@Description ("Validate user deatils for sign off process")
	@Epic("SignOff functionality")
	@Feature("SignOff user functionality")
	@Story("Verify valid Signin/Signoff creadentials ")
	public void Verifyusingvalidcredential() throws InterruptedException {

	logger.info("***************Start Validate sign off *****************");

	HomePage Homepg = new HomePage(driver);
	Homepg.HomePageSignInlinkClick();
	logger.info("Clicked on Sign In Button");

	SignInPage signinpg = new SignInPage(driver);
	signinpg.AcceptEmailadd("raghuveer.nayak@gmail.com");
	logger.info("Provided correct email address");

	signinpg.ContinueClick();
	logger.info("Clicked on continue button");

	signinpg.Acceptpassword("Raghu@123");
	logger.info("Entered password");
	
	signinpg.signinbuttClick();
	logger.info("Sign in button clicked");
	
	
	SignOffPage signoff = new SignOffPage(driver);
	signoff.SignOfflinkClick();
	logger.info("Sign off button clicked");
	
	
}
}
