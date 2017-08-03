import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GoogleMailPage extends BasePage {
    public GoogleMailPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "com.google.android.gm:id/mail_toolbar")
    private MobileElement mailToolbar;

    public boolean googleMailisDisplayed() {
        boolean googleMailToolbar = mailToolbar.isDisplayed();
        return googleMailToolbar;
    }

}
