package com.test.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.cucumber.utilities.ReusableOperations;

public class Search_pageobjects extends ReusableOperations {

	public Search_pageobjects(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search by City, Property, University']")
	public WebElement txtSearch;
	
	@FindBy(xpath="(//button[@aria-label='Close'])[2]")
	public WebElement btnAcceptCookies;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement btnSearch;
	
	@FindBy(xpath="//button[@type='submit']//parent::form/div")
	public WebElement lstSearch;
	
	public void waitSearchListDisplayed() {
		WaitUntilElementVisible(lstSearch);
	}
	
	public void clickAcceptCookies() {
		WaitUntilElementVisible(btnAcceptCookies);
		clickOnElement(btnAcceptCookies);
	}
	
	public void typeSearch(String location) {
		typeIntoElement(txtSearch,location);
	}
	
	public void clickSearch() {
		WaitUntilElementVisible(btnSearch);
			clickOnElement(btnSearch);
	}
}
