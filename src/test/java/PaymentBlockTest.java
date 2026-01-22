import org.example.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentBlockTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open();
        homePage.acceptCookies();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkBlockTitle() {
        assertEquals("Онлайн пополнение\nбез комиссии", homePage.getPaymentBlockTitleText());
    }

    @Test
    void checkPartnerLogos() {
        for (WebElement logo : homePage.getPartnerLogos()) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    void aboutServiceButtonTest() {
        homePage.clickAboutServiceButton();
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    void continueButtonTest() {
        String phoneNumber = "297777777";
        String expectedDescription = "Оплата: Услуги связи Номер:375" + phoneNumber;

        homePage.fillPhoneNumberField(phoneNumber);
        homePage.fillSumField("228");
        assertTrue(homePage.getContinueButton().isEnabled());
        homePage.clickContinueButton();
        homePage.switchToPaymentForm();
        assertEquals(expectedDescription, homePage.getPaymentFormDescriptionText());
    }

    @Test
    void checkPlaceholders() {
        for (int i = 1; i <= 4; i++) {
            homePage.selectPaymentTab(i);
            switch (i) {
                case 1:
                    assertEquals("Номер телефона", homePage.getNumberFieldPlaceholder());
                    break;
                case 2:
                    assertEquals("Номер абонента", homePage.getNumberFieldPlaceholder());
                    break;
                case 3:
                    assertEquals("Номер счета на 44", homePage.getNumberFieldPlaceholder());
                    break;
                case 4:
                    assertEquals("Номер счета на 2073", homePage.getNumberFieldPlaceholder());
                    break;
            }
            assertEquals("Сумма", homePage.getSumFieldPlaceholder());
            assertEquals("E-mail для отправки чека", homePage.getEmailFieldPlaceholder());
        }
    }

    @Test
    void checkPaymentForm() {
        String phoneNumber = "297777777";
        String sum = "249.99";

        homePage.fillPhoneNumberField(phoneNumber);
        homePage.fillSumField(sum);
        homePage.clickContinueButton();
        homePage.switchToPaymentForm();

        assertEquals(String.format("%s BYN", sum), homePage.getPaymentFormSumText());
        assertEquals(String.format("Оплатить %s BYN", sum), homePage.getPaymentFormSubmitButtonText());
        assertEquals(String.format("Оплата: Услуги связи Номер:375%s", phoneNumber), homePage.getPaymentFormDescriptionText());

        assertEquals("Номер карты", homePage.getPaymentFormCardNumberLabel());
        assertEquals("Срок действия", homePage.getPaymentFormCardExpirationDateLabel());
        assertEquals("CVC", homePage.getPaymentFormCardCVCLabel());
        assertEquals("Имя и фамилия на карте", homePage.getPaymentFormCardHolderLabel());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (WebElement logo : homePage.getPaymentFormPartnerLogos()) {
            wait.until(ExpectedConditions.visibilityOf(logo));
            assertTrue(logo.isDisplayed());
        }
    }
}
