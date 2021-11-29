package com.test.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import com.test.cucumber.utilities.ReadProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void openBrowser() throws Exception {

		ReadProperties propertiesReader = new ReadProperties();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ReadProperties.getValue("url"));
	}

	@After
	public void teardown(Scenario scenario) {

		if(scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				//				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException noSupportScreenshot) {
				System.err.println(noSupportScreenshot.getMessage());
			}
		}
		driver.quit();
	}
}
