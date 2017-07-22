import http.ResendEmailRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class SignUpTest extends BaseTest {

    @Test

    public void signUpTestIncorrectPassword() {
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        SignUpPage signUpPage = signInPage.goToSignUpPage();
        signUpPage.enterFirstName("noname");
        signUpPage.enterLastName("noname");
        signUpPage.enterEmail("minnnune@gmail.com");
        signUpPage.enterPassword("incorrectpassword");
        signUpPage.enterConfirmPassword("incorrectpassword");
        signUpPage.selectDiagnosisA();
        signUpPage.selectCountryUkraine();
        signUpPage.scrollToPhoneNumber();
        signUpPage.enterPhoneNumber("0632350342");
        signUpPage.clickOnSignUpButton();
        signUpPage.incorrectPassoword();
        Assert.assertTrue(signUpPage.incorrectPassoword());
    }


    @Test

    public void signUpTestPasswordNotMatch() {
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        SignUpPage signUpPage = signInPage.goToSignUpPage();
        signUpPage.enterFirstName("noname");
        signUpPage.enterLastName("noname");
        signUpPage.enterEmail("minnnune@gmail.com");
        signUpPage.enterPassword("Password_11");
        signUpPage.enterConfirmPassword("Password_1");
        signUpPage.selectDiagnosisA();
        signUpPage.selectCountryUkraine();
        signUpPage.scrollToPhoneNumber();
        signUpPage.enterPhoneNumber("0632350342");
        signUpPage.clickOnSignUpButton();
        signUpPage.passwordNotMatch();
        Assert.assertTrue(signUpPage.passwordNotMatch());

    }


    @Test

    public void signUpTestIncorrectEmail() {
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        SignUpPage signUpPage = signInPage.goToSignUpPage();
        signUpPage.enterFirstName("noname");
        signUpPage.enterLastName("noname");
        signUpPage.enterEmail("minnnune");
        signUpPage.enterPassword("Password_11");
        signUpPage.enterConfirmPassword("Password_11");
        signUpPage.selectDiagnosisA();
        signUpPage.selectCountryUkraine();
        signUpPage.scrollToPhoneNumber();
        signUpPage.enterPhoneNumber("0632350342");
        signUpPage.clickOnSignUpButton();
        Assert.assertTrue(signUpPage.incorrectEmail());
    }

    @Test

    public void signUpTestWithoutDiagnosis() {
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        SignUpPage signUpPage = signInPage.goToSignUpPage();
        signUpPage.enterFirstName("noname");
        signUpPage.enterLastName("noname");
        signUpPage.enterEmail("minnnune@gmail.com");
        signUpPage.enterPassword("Password_11");
        signUpPage.enterConfirmPassword("Password_11");
        signUpPage.selectCountryUkraine();
        signUpPage.scrollToPhoneNumber();
        signUpPage.enterPhoneNumber("0632350342");
        signUpPage.clickOnSignUpButton();
        Assert.assertTrue(signUpPage.diagnosisFieldRequired());
    }

    @Test

    public void signUpTestWithoutCountry() {
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        SignUpPage signUpPage = signInPage.goToSignUpPage();
        signUpPage.enterFirstName("noname");
        signUpPage.enterLastName("noname");
        signUpPage.enterEmail("minnnune@gmail.com");
        signUpPage.enterPassword("Password_11");
        signUpPage.enterConfirmPassword("Password_11");
        signUpPage.selectDiagnosisA();
        signUpPage.clickOnSignUpButton();
        Assert.assertTrue(signUpPage.countryFieldRequired());

    }

    @Test

    public void signUpTestWithoutPhone() {
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        SignUpPage signUpPage = signInPage.goToSignUpPage();
        signUpPage.enterFirstName("noname");
        signUpPage.enterLastName("noname");
        signUpPage.enterEmail("minnnune@gmail.com");
        signUpPage.enterPassword("Password_11");
        signUpPage.enterConfirmPassword("Password_11");
        signUpPage.selectDiagnosisA();
        signUpPage.selectCountryUkraine();
        signUpPage.scrollToPhoneNumber();
        signUpPage.clickOnSignUpButton();
        signUpPage.scrollToPhoneNumberRequired();
        Assert.assertTrue(signUpPage.countryFieldRequired());
    }

    @Test

    public void signUpTestWithAdditionalData() {
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        SignUpPage signUpPage = signInPage.goToSignUpPage();
        signUpPage.enterFirstName("noname");
        signUpPage.enterLastName("noname");
        signUpPage.enterEmail("minnnune@gmail.com");
        signUpPage.enterPassword("Password_11");
        signUpPage.enterConfirmPassword("Password_11");
        signUpPage.selectDiagnosisA();
        signUpPage.selectCountryUkraine();
        signUpPage.scrollToPhoneNumber();
        signUpPage.enterPhoneNumber("0632350342");
        signUpPage.goToSignUpNextPage();
        SignUpNextPage signUpNextPage = new SignUpNextPage(driver);
        signUpNextPage.editDateOfBirth();
        signUpNextPage.goToAfterRegisterPage();
        AfterRegisterPage afterRegisterPage = new AfterRegisterPage(driver);
        afterRegisterPage.goToSignInPage();

    }

    @Test
    public void signUpTestResendEmail() throws IOException {
        ResendEmailRequest resendEmailRequest = new ResendEmailRequest();
        Assert.assertEquals(resendEmailRequest.resendEmailPost(), 204);

    }


}













