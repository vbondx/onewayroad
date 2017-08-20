import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

public class RecoveryPasswordPage extends BasePage {
    public RecoveryPasswordPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "etMailPhone")
    private MobileElement emailPhoneField;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Неверный формат']")
    private MobileElement inputErrorEmail;

    @AndroidFindBy (id = "btnContinue")
    private MobileElement continueButton;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Восстановление пароля']")
    private MobileElement headerText;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Телефон в формате: +380XXXXXXX']")
    private MobileElement inputErrorPhone;

    public void enterEmailOrPhone (String emailOrPhone) {
        emailPhoneField.sendKeys(emailOrPhone);
    }

    public String inputErrorEmail() {
        String inputErrorEmailText = inputErrorEmail.getText();
        return inputErrorEmailText;
    }

    public String inputErrorPhone() {
        String inputErrorPhoneText = inputErrorPhone.getText();
        return inputErrorPhoneText;
    }

    public RecoveryPasswordNextPage goToRecoveredPasswordPage() {
        continueButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new RecoveryPasswordNextPage(driver);
    }

    public void submitNotValidData() {
        log.info("Click on submit button with incorrect data");
        continueButton.click();
    }

    public void clearData() { emailPhoneField.clear();
    }

    public boolean emailOrPhoneFieldDisplayed() {
        boolean emailOrPhoneField = emailPhoneField.isDisplayed();
        return emailOrPhoneField;
    }

    public RecoveryPasswordNextPage goToNextPage() {
        log.info("Click on submit button with correct data");
        continueButton.click();
        return new RecoveryPasswordNextPage(driver);
    }
}
