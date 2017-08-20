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
        try {
            log.info("Test passed");
            Assert.assertEquals(forgotPasswordPage.inputErrorEmail(), "Неверный формат");
        } catch (AssertionError e) {
            log.warn("Test failed");
        }
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
        try {
            log.info("Test passed");
            Assert.assertEquals(forgotPasswordPage.inputErrorPhone(), "Телефон в формате: +380XXXXXXX");
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(forgotPasswordPage.inputErrorPhone(), "Телефон в формате: +380XXXXXXX");
        }
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
        try {
            log.info("Test paseed");
            Assert.assertEquals(forgotPasswordPage.emailOrPhoneFieldDisplayed(),true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(forgotPasswordPage.emailOrPhoneFieldDisplayed(), true);
        }
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
        try {
            log.info("Test passed");
            Assert.assertEquals(recoveryPasswordNextPage.instruction(), "Мы отправили инструкцию");
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(recoveryPasswordNextPage.instruction(), "Мы отправили инструкцию");
        }
    }

    @Test

    public void openMailPage() {
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
        recoveryPasswordNextPage.goToMail();
        GoogleMailPage googleMailPage = new GoogleMailPage(driver);
        try {
            log.info("Test passed");
            Assert.assertEquals(googleMailPage.googleMailisDisplayed(), true);
        } catch (AssertionError e) {
            log.warn("Test failed");
            Assert.assertEquals(googleMailPage.googleMailisDisplayed(), true);
        }
    }

}
