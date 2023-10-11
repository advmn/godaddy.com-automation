package godaddyautomation.tests.websitemenulinks;

import godaddyautomation.utilities.WebDriverFactory;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AllMenuLinks {

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
    @Description("All menu links test")
    public void test() {
        driver.get("https://www.godaddy.com/pl-pl");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement nazwyDomenButton = driver.findElement(By.xpath("//header[@id='header']/div/section//nav[@class='pqzxpf0']//ul[@class='c1p3h013']/li[1]/button[@class='fqpukcf']"));
        nazwyDomenButton.click();
        WebElement szukajNazwDomenButton = driver.findElement(By.linkText("Szukaj nazw domen"));
        szukajNazwDomenButton.click();
        driver.navigate().back();
        WebElement witrynyButton = driver.findElement(By.xpath("//header[@id='header']/div/section//nav[@class='pqzxpf0']//ul[@class='c1p3h013']/li[2]/button[@class='fqpukcf']"));
        witrynyButton.click();
        WebElement wszystkieOpcjeWitrynyButton = driver.findElement(By.linkText("Wszystkie opcje witryny"));
        wszystkieOpcjeWitrynyButton.click();
        driver.navigate().back();
        WebElement pocztaMarketingButton = driver.findElement(By.xpath("//header[@id='header']/div/section//nav[@class='pqzxpf0']//ul[@class='c1p3h013']/li[3]/button[@class='fqpukcf']"));
        pocztaMarketingButton.click();
        WebElement pocztaMicrosoftButton = driver.findElement(By.xpath("/html//header[@id='header']/div/section/div[@class='gdSherpa inverted p15h58fl']//nav[@class='pqzxpf0']//ul[@class='c1p3h013']/li[3]/div[@class='tccg8n2']//div[@class='p1l4r46u']/ul[1]//a[@href='https://www.godaddy.com/pl-pl/email']"));
        pocztaMicrosoftButton.click();
        driver.navigate().back();
    }
}
