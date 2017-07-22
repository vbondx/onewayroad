import com.fasterxml.jackson.databind.ser.Serializers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;


public class SignUpPage extends BasePage {
    public SignUpPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id="container")
    private MobileElement container;

    @AndroidFindBy (id = "sign_up")
    private MobileElement signUpButton;

    @AndroidFindBy (id = "first_name_value")
    private MobileElement firstNameField;

    @AndroidFindBy (id = "last_name_value")
    private MobileElement lastNameField;

    @AndroidFindBy (id = "email_value")
    private MobileElement emailField;

    @AndroidFindBy (id = "password_value")
    private MobileElement passwordField;

    @AndroidFindBy (id = "confirm_password_value")
    private MobileElement confirmPasswordField;


    @AndroidFindBy (id = "diagnosis_value")
    private MobileElement diagnosisField;

    @AndroidFindBy (id = "country_value")
    private MobileElement countryField;


    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.hideKeyboard();

    }

    public void enterLastName (String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail (String email) {
        emailField.sendKeys(email);
    }

    public boolean incorrectEmail(){                                                                                    //NEED TO TEST
        MobileElement incorrectEmailText = driver.findElementById("textinput_error");
        boolean showIncorrectEmailText = incorrectEmailText.isDisplayed();
        return showIncorrectEmailText;
    }

    public void enterPassword (String password){
        passwordField.sendKeys(password);
        driver.hideKeyboard();
    }

    public boolean incorrectPassoword(){                                                                                //NEED TO TEST
        MobileElement incorrectPasswordText = driver.findElementById("textinput_error");
        boolean showIncorrectPasswordText = incorrectPasswordText.isDisplayed();
        return showIncorrectPasswordText;
    }

    public void enterConfirmPassword (String confirmPassword){
        confirmPasswordField.sendKeys(confirmPassword);
        driver.hideKeyboard();
    }

    public boolean passwordNotMatch(){                                                                                  //NEED TO TEST
        MobileElement passwordNotMatchText = driver.findElementById("textinput_error");
        boolean showPasswordNotMatchText = passwordNotMatchText.isDisplayed();
        return showPasswordNotMatchText;
    }


    public void selectDiagnosisA() {
        diagnosisField.click();
        MobileElement dialogList = driver.findElementById("select_dialog_listview");
        List<MobileElement> checkButtonDaignosisList = dialogList.findElementsById("text1");
        checkButtonDaignosisList.get(0).click();

    }

    public void selectDiagnosisB() {
        diagnosisField.click();
        MobileElement dialogList = driver.findElementById("select_dialog_listview");
        List<MobileElement> checkButtonDaignosisList = dialogList.findElementsById("text1");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        checkButtonDaignosisList.get(1).click();
    }

    public void selectDiagnosisNone(){
        diagnosisField.click();
        MobileElement dialogList = driver.findElementById("select_dialog_listview");
        List<MobileElement> checkButtonDaignosisList = dialogList.findElementsById("text1");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        checkButtonDaignosisList.get(2).click();
    }

    public boolean diagnosisFieldRequired(){                                                                            // NEED TO TEST
        MobileElement diagnosisFieldRequiredText = driver.findElementById("textinput_error");
        boolean showDiagnosisFieldRequiredText = diagnosisFieldRequiredText.isDisplayed();
        return showDiagnosisFieldRequiredText;
    }

    public void selectCountryUnitedStates() {
        countryField.click();
        MobileElement countryList = driver.findElementById("contentPanel");
        List<MobileElement> checkButtonCountryList = countryList.findElementsById("text1");
        checkButtonCountryList.get(0).click();
    }

    public void selectCountryUnitedKingdom() {
        countryField.click();
        MobileElement countryList = driver.findElementById("contentPanel");
        List<MobileElement> checkButtonCountryList = countryList.findElementsById("text1");
        checkButtonCountryList.get(1).click();

    }

    public void selectCountryFrance() {
        countryField.click();
        MobileElement countryList = driver.findElementById("contentPanel");
        List<MobileElement> checkButtonCountryList = countryList.findElementsById("text1");
        checkButtonCountryList.get(2).click();
    }

    public void selectCountryUkraine() {
        countryField.click();
        MobileElement countryList = driver.findElementById("contentPanel");
        List<MobileElement> checkButtonCountryList = countryList.findElementsById("text1");
        checkButtonCountryList.get(3).click();
    }

    public boolean countryFieldRequired() {                                                                             //NEED TO TEST
        MobileElement coutryFieldRequiredText = driver.findElementById("textinput_error");
        boolean showCountryFieldRequiredText = coutryFieldRequiredText.isDisplayed();
        return showCountryFieldRequiredText;
    }

    public void selectLanguageEnglish(){
        MobileElement languageField = driver.findElementById("language_value");
        languageField.click();
        MobileElement languageList = driver.findElementById("select_dialog_listview");
        List<MobileElement> checkButtonLanguageList = languageList.findElementsById("text1");
        checkButtonLanguageList.get(0).click();
    }

    public void selectLanguageFrench(){
        MobileElement languageField = driver.findElementById("language_value");
        languageField.click();
        MobileElement languageList = driver.findElementById("select_dialog_listview");
        List<MobileElement> checkButtonLanguageList = languageList.findElementsById("text1");
        checkButtonLanguageList.get(1).click();
    }


    public void scrollToPhoneNumber() {
        String locator = ("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"com.medicom.maven.debug:id/phone_number_value\"))");
        driver.findElement(MobileBy.AndroidUIAutomator(locator));
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElementById("phone_number_value").sendKeys(phoneNumber);
    }

    public void scrollToPhoneNumberRequired(){
        String locator = ("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"com.medicom.maven.debug:id/textinput_error\"))");
        driver.findElement(MobileBy.AndroidUIAutomator(locator));
    }

    public boolean phoneNumberRequired() {                                                                              //NEED TO TEST
        MobileElement phoneNumber = driver.findElementById("phone_number_value");
        MobileElement phoneNumberRequiredText = phoneNumber.findElementById("textinput_error");
        boolean showPhoneNumberRequiredText = phoneNumberRequiredText.isDisplayed();
        return showPhoneNumberRequiredText;
    }

    public void clickOnSignUpButton(){
        signUpButton.click();
    }



    public SignUpNextPage goToSignUpNextPage(){
        signUpButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return new SignUpNextPage(driver);
    }



}
