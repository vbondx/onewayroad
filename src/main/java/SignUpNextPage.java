import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;

import java.util.List;

/**
 * Created by v.bondarenko on 07.07.17.
 */
public class SignUpNextPage extends BasePage {
    public SignUpNextPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @AndroidBy (id = "editTextAlternativeEmail")
    private MobileElement editTextAlternativeEmail;

    @AndroidBy (id = "editTextAlternativePhoneNumber")
    private MobileElement editTextAlternativePhoneNumber;

    @AndroidBy (id = "editTextDateOfBirth")
    private MobileElement editTextDateOfBirth;

    @AndroidBy (id = "editTextGender")
    private MobileElement editTextGender;

    @AndroidBy (id = "editTextState")
    private MobileElement editTextState;

    @AndroidBy (id = "editTextAddress")
    private MobileElement editTextAddress;

    @AndroidBy (id = "sign_up")
    private MobileElement signUpButton;

    public boolean alternativeEmailDisplayed(){
        boolean showAlternativeEmail = editTextAlternativeEmail.isDisplayed();
        return  showAlternativeEmail;
    }


    public void editAlternativeEmail(String email){
        editTextAlternativeEmail.sendKeys(email);
    }

    public void editAtlernativePhoneNumber(String phoneNumber){
        editTextAlternativePhoneNumber.sendKeys(phoneNumber);
    }

    public void editDateOfBirth(){
        editTextDateOfBirth.click();
        MobileElement dateMenu = driver.findElementById("android:id/month_view");
        List <MobileElement> dateList = dateMenu.findElementsByClassName("android.view.View");
        dateList.get(12).click();
        MobileElement yearChooser = driver.findElementById("android:id/date_picker_header_year");
        yearChooser.click();
        String locator = ("new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).scrollIntoView(new UiSelector().text(\"2004\"))");
        driver.findElement(MobileBy.AndroidUIAutomator(locator));
        String locator1 = ("new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).scrollIntoView(new UiSelector().text(\"1999\"))");
        driver.findElement(MobileBy.AndroidUIAutomator(locator1));
        String locator2 = ("new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).scrollIntoView(new UiSelector().text(\"1995\"))");
        driver.findElement(MobileBy.AndroidUIAutomator(locator2)).click();
        MobileElement chooseDateOfBirthButton = driver.findElementById("android:id/button1");
        chooseDateOfBirthButton.click();
    }

    public void selectGenderNone(){
        editTextGender.click();
        MobileElement genderMenu = driver.findElementById("select_dialog_listview");
        List<MobileElement> genderList = genderMenu.findElementsById("text1");
        genderList.get(0).click();
    }

    public void selectGenderMale(){
        editTextGender.click();
        MobileElement genderMenu = driver.findElementById("select_dialog_listview");
        List<MobileElement> genderList = genderMenu.findElementsById("text1");
        genderList.get(1).click();
    }

    public void selectGenderFemale(){
        editTextGender.click();
        MobileElement genderMenu = driver.findElementById("select_dialog_listview");
        List<MobileElement> genderList = genderMenu.findElementsById("text1");
        genderList.get(0).click();
    }

    public void selectState(){
        editTextState.click();
        MobileElement stateMenu = driver.findElementById("select_dialog_listview");
        List<MobileElement> stateList = stateMenu.findElementsById("text1");
        stateList.get(1).click();
    }

    public void scrollToCityField() {
        String locator = ("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"com.medicom.maven.debug:id/editTextCity\"))");
        driver.findElement(MobileBy.AndroidUIAutomator(locator));
    }

    public void editAddress(String addressValue){
        editTextAddress.sendKeys(addressValue);
    }

    public void editCity(String cityValue){
        MobileElement city = driver.findElementById("editTextCity");
        city.sendKeys(cityValue);
    }

    public AfterRegisterPage goToAfterRegisterPage(){
        signUpButton.click();
        return new AfterRegisterPage(driver);
    }

}
