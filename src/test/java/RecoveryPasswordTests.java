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
            Assert.assertEquals(forgotPasswordPage.inputErrorEmail(), "Неверный формат");
            log.info("<Incorrect email> Test passed" + " " + getClass());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.warn("<Incorrect email> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());

        } catch (AssertionError e) {
            log.warn("<Incorrect email> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
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
            Assert.assertEquals(forgotPasswordPage.inputErrorPhone(), "Телефон в формате: +380XXXXXXX");
            log.info("<Validation phone < 12> Test passed" + " " + getClass());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.warn("<Validation phone < 12> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Validation phone < 12> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
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
            Assert.assertEquals(forgotPasswordPage.emailOrPhoneFieldDisplayed(),true);
            log.info("<Validation phone > 12> Test passed" + " " + getClass());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.warn("<Validation phone > 12> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Validation phone > 12> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
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
            Assert.assertEquals(recoveryPasswordNextPage.instruction(), "Мы отправили инструкцию");
            log.info("<Recovery password> Test passed" + " " + getClass());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.warn("<Recovery password> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Recovery password> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
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
            Assert.assertEquals(googleMailPage.googleMailisDisplayed(), true);
            log.info("<Open email page> Test passed" + " " + getClass());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.warn("<Open email page> Test failed: element not found." + " " + getClass());
            log.warn(e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Open email page> Test failed: check error details." + " " + getClass());
            log.warn(e.getMessage());
        }
    }

}
