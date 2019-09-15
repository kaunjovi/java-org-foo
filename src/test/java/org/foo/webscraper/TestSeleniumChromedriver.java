package org.foo.webscraper;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSeleniumChromedriver {

	private final Logger logger = LoggerFactory.getLogger(TestSeleniumChromedriver.class);

	@Test
	public void test() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/parthabhattacharjee/git/java-org-foo/src/test/resources/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(800, 1000));

		WebDriverWait wait = new WebDriverWait(driver, 40);

		driver.navigate().to("https://beta.nseindia.com/get-quotes/equity?symbol=YESBANK");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"quoteName\"]")));

		WebElement e = driver.findElement(By.xpath("//*[@id=\"quoteName\"]"));
		logger.debug(e.getAttribute("innerText"));

		WebElement e1 = driver.findElement(By.xpath("//*[@id=\"quoteLtp\"]"));
		logger.debug(e1.getAttribute("innerText"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 450)");

		WebElement element = driver.findElement(By.cssSelector("a[href*='#info-tradeinfo']"));
		element.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"securityWiseDQTQ\"]")));
		WebElement e3 = driver.findElement(By.xpath("//*[@id=\"securityWiseDQTQ\"]"));
		logger.debug(e3.getAttribute("innerText"));

		driver.close();

		fail("Not yet implemented");
	}

}
