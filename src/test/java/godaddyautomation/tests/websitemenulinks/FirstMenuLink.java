package godaddyautomation.tests.websitemenulinks;

import godaddyautomation.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FirstMenuLink {
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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement nazwyDomenButton = driver.findElement(By.xpath("//header[@id='header']/div/section//nav[@class='pqzxpf0']//ul[@class='c1p3h013']/li[1]/button[@class='fqpukcf']"));
        nazwyDomenButton.click();
        WebElement szukajNazwDomenButton = driver.findElement(By.linkText("Szukaj nazw domen"));
        szukajNazwDomenButton.click();

        driver.navigate().forward();
        String expectedTitleValue = "Wyszukiwarka domen GoDaddy – kup i zarejestruj dostępne nazwy domen";
        String actualTitleValue = driver.getTitle();
        System.out.println(actualTitleValue);

        if (actualTitleValue.equals(expectedTitleValue)) {
            System.out.println("Pass");
        }
        else System.out.println("Failed");
    }
}
