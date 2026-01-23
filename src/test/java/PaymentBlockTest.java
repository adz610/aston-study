import io.qameta.allure.Feature;
import io.qameta.allure.Step;
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

@Feature("Блок \"Онлайн пополнение без комиссии\"")
@DisplayName("Проверка блока \"Онлайн пополнение без комиссии\"")
public class PaymentBlockTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    @Step("Инициализация драйвера")
    void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.open();
        homePage.acceptCookies();
    }

    @AfterEach
    @Step("Завершение работы драйвера")
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка названия")
    void checkBlockTitle() {
        assertEquals("Онлайн пополнение\nбез комиссии", homePage.getPaymentBlockTitleText());
    }

    @Test
    @DisplayName("Проверка отображения логотипов партнёров")
    void checkPartnerLogos() {
        for (WebElement logo : homePage.getPartnerLogos()) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    @DisplayName("Проверка кнопки \"Подробнее о сервисе\"")
    void aboutServiceButtonTest() {
        homePage.clickAboutServiceButton();
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @Test
    @DisplayName("Проверка кнопки \"Продолжить\" после заполнения обязательных полей")
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
    @DisplayName("Проверка плейсхолдеров")
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
    @DisplayName("Проверка корректности отображаемой информации в модальном окне")
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
