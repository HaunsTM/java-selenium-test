
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {

    private RemoteWebDriver _driver;

    public PageObjects(RemoteWebDriver driver) {
        _driver = driver;
    }

    public WebElement inputButtonLogin() {
        var e = _driver.findElement(By.xpath("//input[@value='Login']"));
        return e;
    }

    public WebElement inputUserName() {
        var e = _driver.findElement(By.id("uid"));
        return e;
    }

    public WebElement inputPassword() {
        var e = _driver.findElement(By.id("passw"));
        return e;
    }

    public WebElement h1Greetings(String visitorName) {
        var xpath = "//h1[contains(., 'Hello " + visitorName + "')]";
        var e = _driver.findElement(By.xpath(xpath));
        return e;
    }
}