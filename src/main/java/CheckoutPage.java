import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by v.bondarenko on 04.08.17.
 */
public class CheckoutPage extends BasePage {
    public CheckoutPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "action_login")
    private MobileElement loginButton;

    @AndroidFindBy(id = "input_layout_name")
    private MobileElement nameField;
}
