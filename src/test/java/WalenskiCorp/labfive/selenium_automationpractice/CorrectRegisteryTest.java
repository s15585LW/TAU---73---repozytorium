package WalenskiCorp.labfive.selenium_automationpractice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class CorrectRegisteryTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    static int numberTest=15;

    @Before
        public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080"); //"window-size=800,480"
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        numberTest = numberTest + 1;

        driver = new ChromeDriver(cap);
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.id("email_create")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys("lukWalenski"+numberTest+"tests@wp.pl");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]")).click();
    }

    @Test
    public void RegisteryTest() throws Exception {
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys("Lukasz");
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("Walenski");
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("walenskitest");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::div[1]")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("1990Walenski");
        driver.findElement(By.id("days")).click();
        driver.findElement(By.id("days")).sendKeys("12");
        driver.findElement(By.id("months")).click();
        driver.findElement(By.id("months")).sendKeys("April");
        driver.findElement(By.id("years")).click();
        driver.findElement(By.id("years")).sendKeys("1990");
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your address'])[1]/following::p[1]")).click();
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("Jednosci");
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Tczew");
        driver.findElement(By.id("id_state")).click();
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Alaska");
        driver.findElement(By.id("id_state")).click();
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("00000");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='T-shirts'])[2]/following::div[1]")).click();
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys("111233455");
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys("111233455");
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='T-shirts'])[2]/following::div[1]")).click();
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("alias")).click();
        driver.findElement(By.id("address2")).click();
        driver.findElement(By.id("address2")).clear();
        driver.findElement(By.id("address2")).sendKeys("tt");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DNI / NIF / NIE'])[1]/following::span[1]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
