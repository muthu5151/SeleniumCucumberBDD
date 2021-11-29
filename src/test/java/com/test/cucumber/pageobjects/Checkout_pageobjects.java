package com.test.cucumber.pageobjects;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.cucumber.utilities.ReusableOperations;


public class Checkout_pageobjects extends ReusableOperations {

	public Checkout_pageobjects(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Checkout']")
	public WebElement lblCheckout;
	
	@FindBy(id="emailAddress")
	public WebElement txtemailAddress;

	@FindBy(id="firstName")
	public WebElement txtfirstName;
	
	@FindBy(id="lastName")
	public WebElement txtlastName;
	
	@FindBy(xpath="//*[contains(@for,'PREFER_TO_SELF_DESCRIBE')]")
	public WebElement rdoOther;
	
	@FindBy(xpath="//*[@placeholder='Prefer to self describe']")
	public WebElement txtOther;
	
	@FindBy(xpath="//*[text()='Continue']/parent::button")
	public WebElement btnContinue;
	
	@FindBy(id="countryOfNationality")
	public WebElement cbocountryOfNationality;
	
	@FindBy(id="dateOfBirth")
	public WebElement txtdateOfBirth;
	
	
	public boolean isCheckoutDisplayed() {
		WaitUntilElementVisible(lblCheckout);
		return lblCheckout.isDisplayed();
	}
	
	public void typeEmailAddress() {
		typeIntoElement(txtemailAddress, randomString(12)+"@qualitestgroup.com");
	}
	
	public void typeFirstName() {
		typeIntoElement(txtfirstName, randomString(10));
	}
	
	public void typelastName() {
		typeIntoElement(txtlastName, randomString(6));
	}
	
	public void setGender() {
		List<String> givenList = Arrays.asList("Male", "Female", "Other");
	    Random rand = new Random();
	    String randomElement = givenList.get(rand.nextInt(givenList.size()));
	    switch(randomElement) {
	    case "Male":
	    case "Female":
	    	 driver.findElement(By.id(randomElement)).click();
	    	break;
	    case "Other":
	    	clickOnElement(rdoOther);
	    	typeIntoElement(txtOther, randomString(7));
	    	break;
	    }
	}
	
	public void typeDateOfBirth() {
		typeIntoElement(txtdateOfBirth, "01/01/2000");
	}
	
	public void selectCountry() {
		typeIntoElement(cbocountryOfNationality,"United Kingdom");
	}
	
	public void clickOnContinue() {
		clickOnElement(btnContinue);
	}
	
}
