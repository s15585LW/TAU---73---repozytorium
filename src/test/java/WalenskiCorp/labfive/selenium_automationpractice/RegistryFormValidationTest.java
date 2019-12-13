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

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
@RunWith(JUnit4.class)
public class RegistryFormValidationTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    String formInfoPassword;
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
        driver.findElement(By.id("email_create")).sendKeys("lukWalenski"+numberTest+"@wp.pl");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]")).click();
    }

    @Test
    public void FormGroupInputValidationTest() throws Exception {
        //Give
        int numberOfWrongInput = 3;

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys(";");
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys(";");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::div[1]")).click();
        driver.findElement(By.id("email")).click();

        //When
        List<WebElement> countOfWrongInputs = driver.findElements(By.className("form-error"));

        //Then
        assertEquals(numberOfWrongInput,countOfWrongInputs.size());

        //After
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys("Lukasz");
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("Walenski");
    }

    @Test
    public void PasswordValidationTest() throws Exception {
        //Give
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[1]/following::div[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[3]/following::div[1]")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("1");
        driver.findElement(By.id("days")).click();

        //When
        formInfoPassword = driver.findElement(By.className("form_info")).getText();

        //Then
        assertEquals("(Five characters minimum)",formInfoPassword);

        //After
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("1990Walenski");
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
