package com.amazon.PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver ldriver;

	// Constructor

	public SignInPage(WebDriver rdriver) {
		ldriver = rdriver;

		// initialize elements
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "createAccountSubmit")
	WebElement SignInlink;

	@FindBy(id = "ap_email")
	WebElement enteremailadd;

	@FindBy(id = "continue")
	WebElement contunuebutt;

	@FindBy(id = "ap_password")
	WebElement enterpas;
	
	@FindBy(id = "signInSubmit")
	WebElement signinsubmitbut;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	WebElement invalidemail;
	
	
	public void SignInlinkClick() {
		SignInlink.click();
	}

	public void AcceptEmailadd(String emailadd) {
		enteremailadd.sendKeys(emailadd);
	}

	public void ContinueClick() {
		contunuebutt.click();
	}
	public void Acceptpassword(String passw) { 
		enterpas.sendKeys(passw);}
	
	public void signinbuttClick() {
		signinsubmitbut.click();

	}
	public String invalidemailmsg() {
		String Invalidmsg = invalidemail.getText();
		return Invalidmsg;

	}

	
	
}


