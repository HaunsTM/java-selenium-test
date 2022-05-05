import java.util.concurrent.TimeUnit;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
	private static ChromeDriver driver;
	private static PageObjects po;
	private static Actions a;

	@BeforeClass
	public static void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		po = new PageObjects(driver);
		a = new Actions(driver);
	} 

	private WebDriverWait waitShort() {	
		final Duration TIMEOUT_S = Duration.ofSeconds(20); //The timeout in seconds when an expectation is called	
		var wait = new WebDriverWait(driver, TIMEOUT_S);

		return wait;
	}

	@Test
	public void valid_UserCredential(){

		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("http://demo.testfire.net/login.jsp");
		po.inputUserName().sendKeys("jsmith");
		po.inputPassword().sendKeys("demo1234");

		a.moveToElement(po.inputButtonLogin());
		waitShort().until(ExpectedConditions.elementToBeClickable(po.inputButtonLogin()));
		po.inputButtonLogin().click();

		WebElement h1Greetings = null;
		
		try{
			h1Greetings = po.h1Greetings("John");

		}catch (Exception e){
			int i = 0;
		}
		Assert.assertNotNull(h1Greetings);
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser(){
		driver.quit();
	}
}