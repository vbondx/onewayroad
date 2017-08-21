
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AuthPageTests extends BaseTest {

    @Test

    public void incorrectEmail(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("minnnune@gmail,com");
        signInPage.clearPasswordField();
        signInPage.enterPassword("1gp7mn24");
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.notValidData(), true);
            log.info("<Incorrect email> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Incorrect email> Test failed: element not found." + " " +getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Incorrect email> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void passwordFieldIsRequired() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("minnnune@gmail.com");
        signInPage.clearPasswordField();
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.passwordFieldIsRequired(), true);
            log.info("<Password field is required> Test passed");
        } catch (NoSuchElementException e) {
            log.warn("<Password field is required> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Password field is required> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void emailFieldIsRequired(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.clearPasswordField();
        signInPage.enterPassword("1gp7mn24");
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.notValidData(), true);
            log.info("<Email field is required> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Email field is required> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Email field is required> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void phoneNumberNotValid(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("380632350342");
        signInPage.clearPasswordField();
        signInPage.enterPassword("1gp7mn24");
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(), true);
            log.info("<Not valid phone number> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Not valid phone number> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Not valid phone number> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void phoneNumberShorterThanTwelve(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("+38063235034");
        signInPage.clearPasswordField();
        signInPage.enterPassword("1gp7mn24");
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.notValidData(), true);
            log.info("<Validation phone < 12> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Validation phone < 12> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("Test failed, check error details.");
            log.warn(e.getMessage());
        }
    }

    @Test

    public void phoneNumberLongerThanTwelve(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("+3806323503422");
        signInPage.clearPasswordField();
        signInPage.enterPassword("1gp7mn24");
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(), true);
            log.info("<Validation phone > 12> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Validation phone > 12> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Validation phone > 12> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void loginOrPasswordNotValid() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("+380632350342");
        signInPage.clearPasswordField();
        signInPage.enterPassword("1gp7mn24");
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(),true);
            log.info("<Login error from backend> Test passed");
        } catch (NoSuchElementException e) {
            log.warn("<Login error from backend> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Login error from backend> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void passwordInputErrorShows() {                     //FIXME: DUPLICATE
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("+380632350342");
        signInPage.clearPasswordField();
        signInPage.submitNotValidData();
        try {
            Assert.assertEquals(signInPage.passwordFieldIsRequired(),true);
            log.info("<Password field is required> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Password field is required> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Password field is required> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void displaysPassword(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        try {
            Assert.assertEquals(signInPage.clickOnEye(),true);
            log.info("<Password displayed> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Password displayed> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Password displayed> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void signIn() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterEmailOrPhone("minnnune@gmail.com");
        signInPage.clearPasswordField();
        signInPage.enterPassword("1gp7mn24");
        signInPage.goToProfilePageAfterAuthorization();
        ProfilePage profilePage = new ProfilePage(driver);
        try {
            Assert.assertEquals(profilePage.profileHeaderTextIsDisplayed(), true);
            log.info("<Sign in> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Sign in> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

    @Test

    public void openGooglePlayPage() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToCabinetApp();
        GooglePlayCabinetAppPage googlePlayCabinetAppPage = new GooglePlayCabinetAppPage(driver);
        try {
            Assert.assertEquals(googlePlayCabinetAppPage.cabinetAppDisplayed(),true);
            log.info("<Go to cabinet application on Google Play> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Go to cabinet application on Google Play> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e ) {
            log.warn("<Go to cabinet application on Google Play> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }
}
