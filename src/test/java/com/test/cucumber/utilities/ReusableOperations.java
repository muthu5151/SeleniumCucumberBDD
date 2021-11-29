package com.test.cucumber.utilities;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableOperations {

	public static WebDriver driver;
	private static WebDriverWait wait;

	public ReusableOperations(WebDriver driver, WebDriverWait wait) {
		ReusableOperations.driver = driver;
		ReusableOperations.wait = wait;
	}

	protected void WaitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickOnElement(WebElement element) {
		WaitUntilElementVisible(element);
		element.click();
	}

	public void typeIntoElement(WebElement element, String textTotype) {
		WaitUntilElementVisible(element);
		element.sendKeys(textTotype);
	}

	public String getTextFromElement(WebElement element) {
		WaitUntilElementVisible(element);
		return element.getText();
	}

	public void moveToElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public String randomString(int length) {
		return RandomStringUtils.random(length, true, false);
	}
	
	public void selectValueByIndex(WebElement element, int index) {
		WaitUntilElementVisible(element);
		Select value = new Select(element);
		value.selectByIndex(index);
	}
	
}
