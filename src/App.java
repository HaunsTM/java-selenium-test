import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;  
import org.openqa.selenium.By;  

public class App {
    public static void main(String[] args) throws Exception {
        myFirstTestCase();
    }

    public static void myFirstTestCase() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.spicejet.com/");  
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());  
        System.out.println(driver.findElement(By.xpath("//div/text()[contains(.,'Join SpiceClub')]")).isDisplayed()); 
		driver.quit();		
	}


}
