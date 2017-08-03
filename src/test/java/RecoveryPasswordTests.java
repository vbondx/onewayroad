import org.testng.Assert;
import org.testng.annotations.Test;

public class RecoveryPasswordTests extends BaseTest {

    @Test

    public void incorrectEmail() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToForgotPasswordPage();
        RecoveryPasswordPage forgotPasswordPage = new RecoveryPasswordPage(driver);
        forgotPasswordPage.clearData();
        forgotPasswordPage.enterEmailOrPhone("minnnune@gmail,com");
        Assert.assertEquals(forgotPasswordPage.inputErrorEmailDisplayed(), true);
    }

    @Test

    public void phoneNumberSmallerThanTwelve() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToForgotPasswordPage();
        RecoveryPasswordPage forgotPasswordPage = new RecoveryPasswordPage(driver);
        forgotPasswordPage.clearData();
        forgotPasswordPage.enterEmailOrPhone("+38063235034");
        Assert.assertEquals(forgotPasswordPage.inputErrorPhoneDisplayed(),true);
    }

    @Test

    public void phoneNumberLongerThanTwelve() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToForgotPasswordPage();
        RecoveryPasswordPage forgotPasswordPage = new RecoveryPasswordPage(driver);
        forgotPasswordPage.clearData();
        forgotPasswordPage.enterEmailOrPhone("+3806323503422");
        forgotPasswordPage.submitNotValidData();
        Assert.assertEquals(forgotPasswordPage.emailOrPhoneFieldDisplayed(),true);
    }

    @Test

    public void validDataRecovery() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthProfilePage();
        UnAuthProfilePage unAuthProfilePage = new UnAuthProfilePage(driver);
        unAuthProfilePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToForgotPasswordPage();
        RecoveryPasswordPage forgotPasswordPage = new RecoveryPasswordPage(driver);
        forgotPasswordPage.clearData();
        forgotPasswordPage.enterEmailOrPhone("minnnune@gmail.com");
        forgotPasswordPage.goToNextPage();
        RecoveryPasswordNextPage recoveryPasswordNextPage = new RecoveryPasswordNextPage(driver);
        Assert.assertEquals(recoveryPasswordNextPage.instructionTextDisplayed(),true);
    }

}
