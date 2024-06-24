package com.amazon.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

	WebDriver ldriver;

	// Constructor

	public CreateAccountPage(WebDriver rdriver) {
		ldriver = rdriver;

		// initialize elements
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "ap_customer_name")
	WebElement custname;
	@FindBy(id = "ap_phone_number")
	WebElement phonenum;
	@FindBy(id = "ap_email")
	WebElement email;
	@FindBy(id = "ap_password")
	WebElement password;
	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(xpath = "//div[contains(text(),'Enter your name')]")
	WebElement BlankEnterName;
	@FindBy(xpath = "//div[@id='auth-phoneNumber-missing-alert']//div[@class='a-alert-content'][normalize-space()='Enter your mobile number']")
	WebElement BlankMobnumber;
	@FindBy(xpath = "//div[contains(text(),'Enter your password')]")
	WebElement BlankPass;
	@FindBy(xpath = "//span[@class='a-list-item']")
	WebElement Blankemailaddress;
	
	// Actions
	public void set_custname(String CustName) {
		custname.clear();
		custname.sendKeys(CustName);
	}

	public void set_phonenum(String phonenumber) {
		phonenum.clear();
		phonenum.sendKeys(phonenumber);
	}

	public void set_email(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}

	public void set_passowrd(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void continueButtonClick() {
		continueButton.click();
	}

	public String Set_BlanknameText() {
		String Blank_name_text = BlankEnterName.getText();
		return Blank_name_text;
	}

	public String Set_BlankMobText() {
		String Blank_mob_text = BlankMobnumber.getText();
		return Blank_mob_text;
	}

	public String Set_BlankPassText() {
		String Blank_pass_text = BlankPass.getText();
		return Blank_pass_text;
	}

	public String Set_existemailText() {
		String Blank_email_text = Blankemailaddress.getText();
		return Blank_email_text;
	}
	
}
