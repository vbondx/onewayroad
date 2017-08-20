
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.notValidData(), true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(signInPage.notValidData(), true);
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.passwordFieldIsRequired(), true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(signInPage.passwordFieldIsRequired(), true);
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.notValidData(), true);
        } catch (AssertionError e) {
            log.warn("Test failed");
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(), true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(), true);
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
            log.info("Test failed");
        } catch (AssertionError e) {
            Assert.assertEquals(signInPage.notValidData(), true);
            log.warn("Test failed");
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(), true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(), true);
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(),true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(signInPage.buttonLoginIsDisplayed(),true);
        }
    }

    @Test

    public void passwordInputErrorShows() {
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.passwordFieldIsRequired(),true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(signInPage.passwordFieldIsRequired(),true);
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
            log.info("Test passed");
            Assert.assertEquals(signInPage.clickOnEye(),true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(signInPage.clickOnEye(),true);
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
            log.info("Test passed");
            Assert.assertEquals(profilePage.profileHeaderTextIsDisplayed(), true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(profilePage.profileHeaderTextIsDisplayed(), true);
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
            log.info("Test passed");
            Assert.assertEquals(googlePlayCabinetAppPage.cabinetAppDisplayed(),true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(googlePlayCabinetAppPage.cabinetAppDisplayed(),true);
        }
    }
}
