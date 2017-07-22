import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by v.bondarenko on 02.07.17.
 */
public class BluetoothProblemsPage extends BasePage {
    public BluetoothProblemsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "button2")
    private MobileElement dismissButton;

    public SignInPage goToSignInPage() {
        dismissButton.click();
        return new SignInPage(driver);
    }
}
