import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import org.aspectj.lang.annotation.AdviceName;

/**
 * Created by v.bondarenko on 22.07.17.
 */
public class AfterRegisterPage extends BasePage {
    public AfterRegisterPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidBy (id = "login")
    private MobileElement loginButton;

    @AndroidBy (id = "resend_validation_link")
    private MobileElement resendEmailLink;


    public SignInPage goToSignInPage(){
        loginButton.click();
        return new SignInPage(driver);
    }

    public void resendEmail(){
        resendEmailLink.click();
    }
}

