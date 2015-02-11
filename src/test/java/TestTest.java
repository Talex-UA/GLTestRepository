import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestTest {

/*    @Test
    public void firefoxWebDriver() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("http://mvnrepository.com/");
        webDriver.findElement(By.id("query")).sendKeys("junit");
        webDriver.findElement(By.className("button")).click();
        Assert.assertTrue(webDriver.findElement(By.className("im-description")).getText().contains("JUnit"));
        webDriver.close();
    }*/

/*    @Test
    public void chromeWebDriver() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("http://mvnrepository.com/");
        webDriver.findElement(By.id("query")).sendKeys("junit");
        webDriver.findElement(By.className("button")).click();
        Assert.assertTrue(webDriver.findElement(By.className("im-description")).getText().contains("JUnit"));
        webDriver.close();
    }*/

    @Test
    public void ieWebDriver() throws InterruptedException {
        WebDriver webDriver = new InternetExplorerDriver();
        webDriver.navigate().to("http://mvnrepository.com/");
        Thread.sleep(5000);
        webDriver.findElement(By.id("query")).sendKeys("junit");
        webDriver.findElement(By.className("button")).click();
        Assert.assertTrue(webDriver.findElement(By.className("im-description")).getText().contains("JUnit"));
        webDriver.close();
    }
}
