package com.test.cucumber.steps;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.cucumber.pageobjects.Checkout_pageobjects;
import com.test.cucumber.pageobjects.Results_pageobjects;
import com.test.cucumber.pageobjects.Search_pageobjects;
import com.test.cucumber.utilities.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;

public class Unitestudents_steps {

	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait;
	
	public Unitestudents_steps() throws Exception {
		ReadProperties propertiesReader = new ReadProperties();
		this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	}
	
	@Given("The user search student accomodation in {string}")
	public void i_search_student_accomodation(String location) {
		Search_pageobjects po = new Search_pageobjects(driver, wait);
		po.clickAcceptCookies();
		po.typeSearch(location);
		po.waitSearchListDisplayed();
		po.clickSearch();
	}
	
	@When("user click on {string} view rooms")
	public void i_click_on_view_rooms(String hotel) {
		Results_pageobjects po = new Results_pageobjects(driver, wait);
		po.isPropertylistDisplayed();
		po.clickOnViewRooms(hotel);
	}
	
	@Then("Validate {string} is displayed to book a viewing")
	public void i_validate_book_viewing(String hotel) {
		Results_pageobjects po = new Results_pageobjects(driver, wait);
		Assert.assertTrue(po.validateBooking(hotel));	
	}
	
	@When("user select {string} to book")
	public void i_select_rooms_to_book(String room) {
		Results_pageobjects po = new Results_pageobjects(driver, wait);
		po.ClickOnBook(room);
	}
	
	@Then("Validate checkout page displayed")
	public void i_validate_checkout_page() {
		Checkout_pageobjects po = new Checkout_pageobjects(driver, wait);
		Assert.assertTrue(po.isCheckoutDisplayed());	
	}
	
	@When("the user enters new account details and continue")
	public void user_enters_new_account_details() {
		Checkout_pageobjects po = new Checkout_pageobjects(driver, wait);
		po.typeEmailAddress();
		po.typeFirstName();
		po.typelastName();
		po.setGender();
		po.typeDateOfBirth();
		po.selectCountry();
		po.clickOnContinue();
	}

}
