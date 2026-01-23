package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class HomePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    // payment block
    private final By PAYMENT_BLOCK = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section");
    private final By TITLE = By.xpath("div/h2");
    private final By PARTNER_LOGOS = By.xpath("div/div[@class=\"pay__partners\"]");
    private final By ABOUT_SERVICE_BUTTON = By.xpath("div/a");
    private final By TAB_SELECT_BUTTON = By.xpath("//button[@class=\"select__header\"]");
    private final By OPENED_PAY_FORM = By.xpath("//form[@class=\"pay-form opened\"]");
    private final By NUMBER_FIELD = By.xpath("div[1]/input");
    private final By SUM_FIELD = By.xpath("div[2]/input");
    private final By EMAIL_FIELD = By.xpath("div[3]/input");

    // payment form (iframe)
    private final By PAYMENT_FORM = By.xpath("//iframe[@class=\"payment-widget-iframe\"]");
    private final By DESCRIPTION = By.xpath("//*[@class=\"pay-description__text\"]");
    private final By SUM = By.xpath("//*[@class=\"pay-description__cost\"]");
    private final By SUBMIT_BUTTON = By.xpath("//button[@type=\"submit\"]");
    private final By CARD_NUMBER_LABEL = By.xpath("//input[@formcontrolname=\"creditCard\"]/following-sibling::label");
    private final By CARD_EXPIRATION_DATE_LABEL = By.xpath("//input[@formcontrolname=\"expirationDate\"]/following-sibling::label");
    private final By CARD_CVC_LABEL = By.xpath("//input[@formcontrolname=\"cvc\"]/following-sibling::label");
    private final By CARD_HOLDER_LABEL = By.xpath("//input[@formcontrolname=\"holder\"]/following-sibling::label");
    private final By CARD_PARTNER_LOGOS = By.xpath("//div[contains(@class, \"cards-brands__container\")]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Переходим на домашнюю страницу сайта")
    public void open() {
        driver.get("https://www.mts.by/");
    }

    @Step("Соглашаемся с предоставлением cookies")
    public void acceptCookies() {
        wait.until(
            ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector("#cookie-agree"))
            )
        ).click();
    }

    @Step
    public String getPaymentBlockTitleText() {
        return driver.findElement(PAYMENT_BLOCK)
            .findElement(TITLE)
            .getText();
    }

    @Step
    public List<WebElement> getPartnerLogos() {
        return driver.findElement(PAYMENT_BLOCK)
            .findElement(PARTNER_LOGOS)
            .findElements(By.tagName("img"));
    }

    @Step
    public WebElement getContinueButton() {
        WebElement button = driver.findElement(PAYMENT_BLOCK)
            .findElement(OPENED_PAY_FORM)
            .findElement(By.xpath("button"));
        return wait.until(
            ExpectedConditions.visibilityOf(button)
        );
    }

    @Step("Нажимаем на кнопку \"Подробнее о сервисе\"")
    public void clickAboutServiceButton() {
        WebElement button = driver.findElement(PAYMENT_BLOCK).findElement(ABOUT_SERVICE_BUTTON);
        wait.until(
            ExpectedConditions.elementToBeClickable(button)
        ).click();
    }

    @Step("Вводим номер: {number}")
    public void fillPhoneNumberField(String number) {
        WebElement field = driver.findElement(PAYMENT_BLOCK)
            .findElement(OPENED_PAY_FORM)
            .findElement(NUMBER_FIELD);
        field.clear();
        field.sendKeys(number);
    }

    @Step("Вводим сумму: {sum}")
    public void fillSumField(String sum) {
        WebElement field = driver.findElement(PAYMENT_BLOCK)
            .findElement(OPENED_PAY_FORM)
            .findElement(SUM_FIELD);
        field.clear();
        field.sendKeys(sum);
    }

    @Step("Нажимаем на кнопку \"Продолжить\"")
    public void clickContinueButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(
                getContinueButton()
            )
        ).click();
    }

    @Step
    public void switchToPaymentForm() {
        driver.switchTo().frame(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(PAYMENT_FORM)
            )
        );
    }

    @Step
    public String getPaymentFormDescriptionText() {
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(DESCRIPTION)
            )
        ).getText();
    }

    @Step("Нажимаем на кнопку со всплывающим меню и переключаемся на {id} тип формы")
    public void selectPaymentTab (int id) {
        WebElement button = driver.findElement(PAYMENT_BLOCK).findElement(TAB_SELECT_BUTTON);
        wait.until(
            ExpectedConditions.elementToBeClickable(button)
        ).click();

        WebElement tab = driver.findElement(PAYMENT_BLOCK).findElement(By.xpath(String.format(".//li[%d]", id)));
        wait.until(
            ExpectedConditions.elementToBeClickable(tab)
        ).click();
    }

    @Step
    public String getNumberFieldPlaceholder() {
        WebElement field = driver.findElement(PAYMENT_BLOCK)
            .findElement(OPENED_PAY_FORM)
            .findElement(NUMBER_FIELD);
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOf(field)
            )
        ).getAttribute("placeholder");
    }

    @Step
    public String getSumFieldPlaceholder() {
        WebElement field = driver.findElement(PAYMENT_BLOCK)
            .findElement(OPENED_PAY_FORM)
            .findElement(SUM_FIELD);
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOf(field)
            )
        ).getAttribute("placeholder");
    }

    @Step
    public String getEmailFieldPlaceholder() {
        WebElement field = driver.findElement(PAYMENT_BLOCK)
            .findElement(OPENED_PAY_FORM)
            .findElement(EMAIL_FIELD);
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOf(field)
            )
        ).getAttribute("placeholder");
    }

    @Step
    public String getPaymentFormSumText() {
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(SUM)
            )
        ).getText();
    }

    @Step
    public String getPaymentFormSubmitButtonText() {
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(SUBMIT_BUTTON)
            )
        ).getText();
    }

    @Step
    public String getPaymentFormCardNumberLabel() {
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(CARD_NUMBER_LABEL)
            )
        ).getText();
    }

    @Step
    public String getPaymentFormCardExpirationDateLabel() {
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(CARD_EXPIRATION_DATE_LABEL)
            )
        ).getText();
    }

    @Step
    public String getPaymentFormCardCVCLabel() {
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(CARD_CVC_LABEL)
            )
        ).getText();
    }

    @Step
    public String getPaymentFormCardHolderLabel() {
        return Objects.requireNonNull(
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(CARD_HOLDER_LABEL)
            )
        ).getText();
    }

    @Step
    public List<WebElement> getPaymentFormPartnerLogos() {
        WebElement container = wait.until(
            ExpectedConditions.visibilityOfElementLocated(CARD_PARTNER_LOGOS)
        );
        return container.findElements(By.tagName("img"));
    }
}
