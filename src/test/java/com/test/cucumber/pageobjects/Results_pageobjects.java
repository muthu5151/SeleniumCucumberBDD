package com.test.cucumber.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.cucumber.utilities.ReusableOperations;

public class Results_pageobjects extends ReusableOperations {

	public Results_pageobjects(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[contains(@class,'PropertyListing')]")
	public WebElement lblPropertylist;

	public boolean isPropertylistDisplayed() {
		WaitUntilElementVisible(lblPropertylist);
		return lblPropertylist.isDisplayed();
	}

	public void clickOnViewRooms(String hotel) {
		WebElement element = driver.findElement(By.xpath("//a[text()='"+hotel+"']"
				+ "/ancestor::div[contains(@class,'PropertyListing')]"
				+ "//span[text()='View rooms']//parent::button"));
		moveToElement(element);
		clickOnElement(element);
	}

	public boolean validateBooking(String hotel) {
		List<WebElement> elements = driver.findElements(By.xpath("//h1[text()='"+hotel+"']"));
		if(elements.size()>0)
			return true;
		else
			return false;
	}

	public void ClickOnBook(String room) {
		String[] value = room.split("\\,");
		WebElement element = driver.findElement(By.xpath("//*[text()='"+value[0].trim()
				+"']/../..//*[text()='"+value[1].trim()+"']"
				+ "/ancestor::div[@class='list-element']//*[text()='Book']//parent::button"));
		moveToElement(element);
		clickOnElement(element);
	}

}
