package WalenskiCorp.labfive.selenium_digital_toys_inc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RegistrationValidationTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080"); //"window-size=800,480"
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(cap);
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testValidationOfForm() throws Exception {
        //Given
        int formErrorExist=0;
        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.name("fullName")).click();
        driver.findElement(By.name("fullName")).clear();
        driver.findElement(By.name("fullName")).sendKeys("");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.className("panel-body")).click();

        //When
        List<WebElement> listOfFormError = driver.findElements(By.className("has-error"));
        formErrorExist = listOfFormError.size();

        //Then
        assertEquals(3,formErrorExist);

            //Correction of data and registration
        driver.findElement(By.name("fullName")).click();
        driver.findElement(By.name("fullName")).clear();
        driver.findElement(By.name("fullName")).sendKeys("Lukasz Walenski");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("walenski.l@gmail.pl");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1990Walenski");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The password is required and cannot be empty.'])[1]/following::button[1]")).click();

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
