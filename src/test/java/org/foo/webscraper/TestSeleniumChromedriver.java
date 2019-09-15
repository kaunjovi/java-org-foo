package org.foo.webscraper;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

		final String CHROME_DRIVER_PATH = "/Users/parthabhattacharjee/git/java-org-foo/src/test/resources/chromedriver";

		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(800, 1000));

		WebDriverWait wait = new WebDriverWait(driver, 40);

//		Lets get some data from valuereaseachonline 
//		https://www.valueresearchonline.com/stocks/snapshot.asp?code=15907

		final String VALUE_RESEARCH_ONLINE_YESBANK = "https://www.valueresearchonline.com/stocks/snapshot.asp?code=15907";

		final String STOCK_TITLE = "STOCK_TITLE";
		final String STOCK_TITLE_XPATH = "//*[@id=\"super-container\"]/div[2]/div/div/div[1]/h1";

		final String STOCK_PRICE = "STOCK_PRICE";
		final String STOCK_PRICE_XPATH = "//*[@id=\"stockPrice\"]/div[1]/table/tbody/tr[1]/td[1]";

		final String PE_RATIO = "PE_RATIO";
		final String PE_RATIO_XPATH = "//*[@id=\"stockPrice\"]/div[1]/table/tbody/tr[1]/td[6]";

		Map<String, String> dataPoints = new HashMap<String, String>();

		driver.navigate().to(VALUE_RESEARCH_ONLINE_YESBANK);

		fetchData(driver, wait, STOCK_TITLE, STOCK_TITLE_XPATH, dataPoints);
		fetchData(driver, wait, STOCK_PRICE, STOCK_PRICE_XPATH, dataPoints);
		fetchData(driver, wait, PE_RATIO, PE_RATIO_XPATH, dataPoints);

		Iterator<Entry<String, String>> dpIterator = dataPoints.entrySet().iterator();
		while (dpIterator.hasNext()) {
			Map.Entry<String, String> mapElement = dpIterator.next();
			logger.debug("{} : {}", mapElement.getKey(), mapElement.getValue());
		}

//		driver.navigate().to("https://beta.nseindia.com/get-quotes/equity?symbol=YESBANK");
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"quoteName\"]")));
//		WebElement e = driver.findElement(By.xpath("//*[@id=\"quoteName\"]"));
//		logger.debug(e.getAttribute("innerText"));
//
//		WebElement e1 = driver.findElement(By.xpath("//*[@id=\"quoteLtp\"]"));
//		logger.debug(e1.getAttribute("innerText"));
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0, 450)");
//
//		WebElement element = driver.findElement(By.cssSelector("a[href*='#info-tradeinfo']"));
//		element.click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"securityWiseDQTQ\"]")));
//		WebElement e3 = driver.findElement(By.xpath("//*[@id=\"securityWiseDQTQ\"]"));
//		logger.debug(e3.getAttribute("innerText"));

		driver.close();

		fail("Not yet implemented");
	}

	private void fetchData(WebDriver driver, WebDriverWait wait, final String key, final String xpath,
			Map<String, String> dataPoints) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		WebElement e = driver.findElement(By.xpath(xpath));
		String stock_title = e.getAttribute("innerText");
		dataPoints.put(key, stock_title);
//		logger.debug("{} : {} .", key, stock_title);
	}

}
