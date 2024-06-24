package com.amazon.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Puzzlepage {

	WebDriver ldriver;

	//Contructor 

 	public Puzzlepage (WebDriver rdriver) { 
		ldriver = rdriver;	
		// initialize elements 
		PageFactory.initElements(rdriver, this); 
	} 


	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/button[1]")
	
	WebElement startpuzzle; 

	public void puzzleButtonClick() { 
		startpuzzle.click(); 
	}
}
