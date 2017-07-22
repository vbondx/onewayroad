import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class HelloPage extends BasePage {
    public HelloPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (className = "android.widget.ImageButton")
    public MobileElement closeHelloPageButton;

    public ConfirmSafetyInfoPage.MainPage goToMainPage() {
        closeHelloPageButton.click();
        return new ConfirmSafetyInfoPage.MainPage(driver);
    }
}
