import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentBlockTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
        cookieAcceptButton.click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
    }

    @Test
    void checkPartnerLogos() {
        WebElement logosContainer = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]"));
        List<WebElement> logos = logosContainer.findElements((By.tagName("img")));
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    void aboutServiceButtonTest() {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        assertTrue(driver.getCurrentUrl().contains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    void continueButtonTest() {
        String phoneNumber = "297777777";
        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumberField.sendKeys(phoneNumber);

        WebElement sumField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumField.sendKeys("228");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        assertTrue(continueButton.isEnabled());
        continueButton.click();

        WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[9]/div/iframe")));
        driver.switchTo().frame(paymentForm);

        WebElement paymentFormDescription = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]"));
        String expectedDescription = "Оплата: Услуги связи Номер:375" + phoneNumber;
        assertEquals(expectedDescription, paymentFormDescription.getText());
    }
}
