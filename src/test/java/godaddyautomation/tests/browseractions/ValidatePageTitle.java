package godaddyautomation.tests.browseractions;

import godaddyautomation.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ValidatePageTitle {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test() {
        driver.get("https://www.godaddy.com/pl-pl");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(title,expectedTitle);
        String url = driver.getCurrentUrl();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(url, expectedUrl);
        String source = driver.getPageSource();
        Assert.assertTrue(source.contains(title));
    }
}
