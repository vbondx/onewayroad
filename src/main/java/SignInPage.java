import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class SignInPage extends BasePage {

    public SignInPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "login")
    private MobileElement loginButton;

    @AndroidFindBy (id = "sign_up")
    private MobileElement signUpButton;

    @AndroidFindBy (id = "username")
    private MobileElement usernameField;

    @AndroidFindBy (id = "password")
    private MobileElement passwordField;

    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword (String password) {
        passwordField.sendKeys(password);
    }

    public HelloPage enterValidData(){
        loginButton.click();
        return new HelloPage(driver);
    }

    public boolean enterNotValidData() {
        loginButton.click();
        MobileElement loginPopUp = driver.findElementById("parentPanel");
        boolean b = loginPopUp.isDisplayed();
        return b;

    }

    public SignUpPage goToSignUpPage(){
        signUpButton.click();
        return new SignUpPage(driver);
    }


}
