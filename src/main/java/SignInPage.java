import com.fasterxml.jackson.databind.ser.Serializers;
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




}
