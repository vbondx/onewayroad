import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by v.bondarenko on 27.07.17.
 */
public class UnAuthProfilePage extends BasePage {
    public UnAuthProfilePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy(id = "btnLoginProfile")
    private MobileElement signInButton;

    @AndroidFindBy (id = "tvWriteUsUnauthorizedProfile")
    private MobileElement writeToUsButton;

    @AndroidFindBy (id = "action_search")                           //FIXME: ADD STANDART SEARCH TO ALL PAGES, WHERE HE STANDING
    private MobileElement standartSearch;

    public SignInPage goToSignInPage() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public WriteUsPage goToWriteToUsPage(){
        writeToUsButton.click();
        return new WriteUsPage(driver);
    }

}
