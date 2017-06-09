package myTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by student01 on 15.12.15.
 */
public class TestLogin {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        String nodeURL = "http://192.168.33.10:4444";
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);
        driver = new ChromeDriver();
        //driver = new RemoteWebDriver(new URL(nodeURL),capabilities);
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    //@Test
    public void testLoginPage() {
        driver.navigate().to("https://github.com/login");
       // driver.findElement(By.id("userNameBox")).sendKeys("admin\n");
       // driver.findElement(By.id("passBox")).sendKeys("haslo");
        System.out.println(driver.findElement(By.id("login_field")).getAttribute("value"));
        System.out.println(driver.findElement(By.id("password")).getAttribute("value"));
        //driver.findElement(By.id("logon")).submit();
        Assert.assertEquals("logowanie", driver.getTitle());
    }

//    @Test
//    public void testLoginPage2() {
//        driver.navigate().to("https://owa.pgs-soft.com/");
//        WebElement usernameInput = driver.findElement(By.id("username"));
//        usernameInput.sendKeys("login");
//    }

//    @Test
//    public void testRadioButton() throws InterruptedException {
//        driver.navigate().to("http://codeseven.github.io/toastr/demo.html");
//        List<WebElement> toastTypeRadioButtons = driver.findElements(By.xpath("//*[@id='toastTypeGroup']//input[@type='radio']"));
//        int i = 0;
//        while(true) {
//            toastTypeRadioButtons.get(i).click();
//            //Thread.sleep(1);
//            Assert.assertTrue("Radio button should be selected", toastTypeRadioButtons.get(i).isSelected());
//            i++;
//            if (i==4) i=0;
//        }
//    }

    @Test
    public void testDropdown() {
        driver.navigate().to("https://testingcup.pgs-soft.com/");
        driver.findElement(By.linkText("Zadanie 8")).click();

        WebElement typyKartyWebElement = driver.findElement(By.id("task8_form_cardType"));
        Select typyKarty = new Select(typyKartyWebElement);
        typyKarty.selectByVisibleText("Discover");
        WebElement miesiacWebElement = driver.findElement(By.id("task8_form_cardInfo_month"));
        Select miesiacKarty = new Select(miesiacWebElement);
        miesiacKarty.selectByVisibleText("August");

        Assert.assertEquals("Discover", typyKarty.getFirstSelectedOption().getText());
    }



    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
