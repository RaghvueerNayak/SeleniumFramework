package com.amazon.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver ldriver;

	// Constructor

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;

		// initialize elements
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement HomePageSignInlink;

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement HomePageSignIn;
	
	
	@FindBy(id= "searchDropdownBox")
	WebElement SerchOption;
	

	public void HomePageSignInlinkClick() { 
		HomePageSignInlink.click();}

	public String HomePageSignIn() {
		String SigninPg = HomePageSignIn.getText();
		return SigninPg;
	}
	
	public void HomePAgeSerachOption() {
	
		Select selectitem = new Select(SerchOption);
		selectitem.selectByVisibleText("Books");
		
	}
	
		
		
		
	
}
