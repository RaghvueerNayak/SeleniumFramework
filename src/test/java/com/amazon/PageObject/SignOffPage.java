package com.amazon.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOffPage {

	WebDriver ldriver;

	// Constructor

	public SignOffPage(WebDriver rdriver) {
		ldriver = rdriver;

		// initialize elements
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Account & Lists']")
	WebElement Signofflink;

	public void SignOfflinkClick() {
		Signofflink.click();
	}

}