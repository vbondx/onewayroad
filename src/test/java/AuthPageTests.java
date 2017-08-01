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
        signInPage.enterNotValidEmailOrPhone("minnnune@gmail,com");
        signInPage.clearPasswordField();
        signInPage.enterValidPassword("1gp7mn24");
        signInPage.submitNotValidData();
        Assert.assertEquals(signInPage.notValidData(), true);
    }

    @Test

    public void passwordFieldIsRequired() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterValidEmail("minnnune@gmail.com");
        signInPage.clearPasswordField();
        signInPage.submitNotValidData();
        Assert.assertEquals(signInPage.passwordFieldIsRequired(), true);
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
        signInPage.enterValidPassword("1gp7mn24");
        signInPage.submitNotValidData();
        Assert.assertEquals(signInPage.notValidData(), true);
    }

    @Test

    public void phoneNumberNotValid(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterNotValidEmailOrPhone("380632350342");
        signInPage.clearPasswordField();
        signInPage.enterValidPassword("1gp7mn24");
        signInPage.submitNotValidData();
        Assert.assertEquals(signInPage.buttonLoginIsDisplayed(), true);
    }

    @Test

    public void phoneNumberShorterThanTwelve(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterNotValidEmailOrPhone("+38063235034");
        signInPage.clearPasswordField();
        signInPage.enterValidPassword("1gp7mn24");
        signInPage.submitNotValidData();
        Assert.assertEquals(signInPage.notValidData(), true);
    }

    @Test

    public void phoneNumberLongerThanTwelve(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterNotValidEmailOrPhone("+3806323503422");
        signInPage.clearPasswordField();
        signInPage.enterValidPassword("1gp7mn24");
        signInPage.submitNotValidData();
        Assert.assertEquals(signInPage.notValidData(), true);
    }

    @Test

    public void loginOrPasswordNotValid() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterNotValidEmailOrPhone("+380632350342");
        signInPage.clearPasswordField();
        signInPage.enterValidPassword("1gp7mn24");
        signInPage.submitNotValidData();
        Assert.assertEquals(signInPage.buttonLoginIsDisplayed(),true);
    }

    @Test

    public void displaysPassword(){
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertEquals(signInPage.clickOnEye(),true);
    }

    @Test

    public void signIn() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.clearEmailField();
        signInPage.enterNotValidEmailOrPhone("minnnune@gmail.com");
        signInPage.clearPasswordField();
        signInPage.enterValidPassword("1gp7mn24");
        signInPage.goToProfilePageAfterAuthorization();
        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertEquals(profilePage.profileHeaderTextIsDisplayed(), true);
    }

    @Test

    public void openCabinetApp() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToCabinetApp();
        GooglePlayCabinetAppPage googlePlayCabinetAppPage = new GooglePlayCabinetAppPage(driver);
        Assert.assertEquals(googlePlayCabinetAppPage.cabinetAppDisplayed(),true);
    }
}
