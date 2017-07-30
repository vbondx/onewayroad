import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class SignInPage extends BasePage {
    public SignInPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "name_editText")
    private MobileElement emailPhoneField;

    @AndroidFindBy (id = "password_editText")
    private MobileElement passwordField;

    @AndroidFindBy (xpath = "//android.view.ViewGroup/android.widget.ImageButton")      //FIXME: TEST THIS LOCATOR
    private MobileElement backToUnAuthPageButton;

    @AndroidFindBy (id = "text_input_password_toggle")
    private MobileElement eyeButton;

    @AndroidFindBy (id = "tvForgotPassword")
    private MobileElement forgotPasswordButton;

    @AndroidFindBy (id = "openCabinet_button")
    private MobileElement cabinetAppButton;

    @AndroidFindBy (id = "btnLogin")
    private MobileElement submitButton;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Неверный формат']")
    private MobileElement inputErrorEmailOrPhoneField;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Обязательно для заполнения']")
    private MobileElement inputErrorPasswordField;

    public void enterValidEmail (String validEmail){
        emailPhoneField.sendKeys(validEmail);
    }

    public void enterNotValidEmailOrPhone (String notValidPhoneOrEmail) {
        emailPhoneField.sendKeys(notValidPhoneOrEmail);
    }

    public void enterValidPassword (String validPassword) {
        passwordField.sendKeys(validPassword);
    }

    public boolean notValidData() {
        boolean notValidDataText = inputErrorEmailOrPhoneField.isDisplayed();
        return notValidDataText;
    }

    public void submitNotValidData() {
        submitButton.click();
    }

    public ProfilePage goToProfilePageAfterAuthorization() {
        submitButton.click();
        return new ProfilePage(driver);
    }

    public void clearEmailField() {
        emailPhoneField.clear();
    }

    public void clearPasswordField() {
        passwordField.clear();
    }

    public boolean passwordFieldIsRequired(){
        boolean passwordIsRequiredText = inputErrorPasswordField.isDisplayed();
        return passwordIsRequiredText;
    }

    public boolean buttonLoginIsDisplayed() {
        boolean btnLogin = submitButton.isDisplayed();
        return btnLogin;
    }

    public boolean clickOnEye() {
        eyeButton.click();
        boolean passwordDisplayed = driver.findElementByXPath("//android.widget.EditText[@text='1gp7mn24']").isDisplayed();
        return passwordDisplayed;
    }

    public GooglePlayCabinetAppPage goToCabinetApp() {
        cabinetAppButton.click();
        return new GooglePlayCabinetAppPage(driver);
    }

    public RecoveryPasswordPage goToForgotPasswordPage() {
        forgotPasswordButton.click();
        return new RecoveryPasswordPage(driver);
    }
}
