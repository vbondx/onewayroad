import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import javafx.beans.NamedArg;

import java.util.List;

import static io.appium.java_client.remote.MobilePlatform.IOS;

public class EndpointChoosePage extends BasePage {
    public EndpointChoosePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidBy (id = "go_button")
    private MobileElement goButton;

    @AndroidBy (id = "save_checkBox")
    private MobileElement saveCheckBox;

    @AndroidBy (id = "customEndpoint_checkBox")
    private MobileElement customEndPointCheckBox;

    @AndroidBy (id = "customEndpoint_editText")
    private MobileElement customEndpointEditText;

    @AndroidBy (id = "api_spinner")
    private MobileElement apiSpinner;


    public void chooseApiVersion(int api) {
        apiSpinner.click();
        MobileElement versionMenu = driver.findElementByClassName("android.widget.ListView");
        List<MobileElement> versionList = versionMenu.findElementsById("android:id/text1");
        versionList.get(api).click();
    }

    public void saveEndpoint() {
        saveCheckBox.click();
    }

    public void customEndpoint(String endpoint) {
        customEndPointCheckBox.click();
        customEndpointEditText.sendKeys(endpoint);
    }

    public MainPage goToMainPage(){
        goButton.click();
        return new MainPage(driver);
    }
}
