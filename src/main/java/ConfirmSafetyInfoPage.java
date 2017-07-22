import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Created by v.bondarenko on 22.07.17.
 */
public class ConfirmSafetyInfoPage extends BasePage {
    public ConfirmSafetyInfoPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Created by v.bondarenko on 02.07.17.
     */
    public static class MainPage extends BasePage {
        public MainPage(AppiumDriver<MobileElement> driver) {
            super(driver);
        }
    }
}
