import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends BasePage {
    public ProfilePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Профиль']")
    private MobileElement profileHeader;

    public boolean profileHeaderTextIsDisplayed(){
        boolean profileHeaderText = profileHeader.isDisplayed();
        return profileHeaderText;
    }
}


