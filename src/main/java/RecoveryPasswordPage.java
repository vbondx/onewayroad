import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by v.bondarenko on 27.07.17.
 */
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

    public void incorrectEmailOrPhone (String incorrectEmailOrPhone) {
        emailPhoneField.sendKeys(incorrectEmailOrPhone);
    }

    public boolean inputErrorEmailDisplayed() {
        boolean inputErrorEmailText = inputErrorEmail.isDisplayed();
        return inputErrorEmailText;
    }

    public boolean inputErrorPhoneDisplayed() {
        boolean inputErrorPhoneText = inputErrorPhone.isDisplayed();
        return inputErrorPhoneText;
    }

    public RecoveryPasswordNextPage goToRecoveredPasswordPage() {
        continueButton.click();
        return new RecoveryPasswordNextPage(driver);
    }

    public void submitNotValidData() {
        continueButton.click();
    }

    public void clearData() {
        emailPhoneField.clear();
    }

    public boolean emailOrPhoneFieldDisplayed() {
        boolean emailOrPhoneField = emailPhoneField.isDisplayed();
        return emailOrPhoneField;
    }

    public RecoveryPasswordNextPage goToNextPage() {
        continueButton.click();
        return new RecoveryPasswordNextPage(driver);
    }
}
