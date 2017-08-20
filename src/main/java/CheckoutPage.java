import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import javafx.scene.control.ScrollToEvent;
import org.aspectj.lang.annotation.AdviceName;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutPage extends BasePage {
    public CheckoutPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "action_login")
    private MobileElement loginButton;

    @AndroidFindBy(id = "input_layout_name")
    private MobileElement nameField;

    @AndroidFindBy(id = "input_layout_phone")
    private MobileElement phoneField;

    @AndroidFindBy(id = "input_layout_email")
    private MobileElement emailField;

    @AndroidFindBy(id = "tilPayment")
    private MobileElement paymentType;

    @AndroidFindBy(id = "select_dialog_listview")
    private MobileElement dialogListView;

    @AndroidFindBy(id = "tilDelivery")
    private MobileElement deliveryType;

    @AndroidFindBy(id = "tilEdit")
    private MobileElement deliveryMethod;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Фамилия*']") // ALL DELIVERY TYPES
    private MobileElement lastNameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Город*']")    // NOVAPOSHTA, MEEST, POCHTOMATI PRIVATBANKA
    private MobileElement cityField;

    @AndroidFindBy(id = "recyclerView")
    private MobileElement cityListView;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Регион*']")
    private MobileElement regionField;

    @AndroidFindBy(id = "search_container")
    private MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Улица*']")
    private MobileElement streetField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Дом*']")
    private MobileElement houseField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Квартира']")
    private MobileElement flatField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Выберите отделение*']")
    // NOVAPOSHTA, MEEST, POCHTOMATI PRIVATBANKA
    private MobileElement departmentField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Адрес*']")    // CUSTOM DEL TYPE
    private MobileElement addressField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Индекс*']")   //CUSTOM DEL TYPE
    private MobileElement zipCodeField;

    @AndroidFindBy(id = "comment_editText")
    private MobileElement commentsField;

    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    private MobileElement agreementCheckBox;

    @AndroidFindBy(id = "btnSendOrder")
    private MobileElement sendOrder;

    public void enterName(String name) {
        log.info("Enter name");
        nameField.sendKeys(name);
    }

    public void enterPhone(String phone) {
        log.info("Enter phone");
        phoneField.sendKeys(phone);
    }

    public void enterEmail(String email) {
        log.info("Enter email");
        emailField.sendKeys(email);
        driver.hideKeyboard();
    }

    public void choosePaymentType(int t) {
        paymentType.click();
        List<MobileElement> paymentList = dialogListView.findElementsByClassName("android.widget.LinearLayout");
        paymentList.get(t).click();            // 1. PREORDER 2. CASH 3. CASH ON DELIVERY
    }

    public void scrollDown() {
        String locator = ("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"ua.prom.b2c:id/btnSendOrder\"))");
        driver.findElement(MobileBy.AndroidUIAutomator(locator));
    }


    public void chooseDeliveryType(int t) {
        deliveryType.click();
        List<MobileElement> deliveryList = dialogListView.findElementsByXPath("//android.widget.LinearLayout");
        deliveryList.get(t).click();           // DIFFERENT DELIVERY TYPES
    }

    public void chooseDeliveryMethod(int m) {
        deliveryMethod.click();
        List<MobileElement> deliveryMethodList = dialogListView.findElementsById("text1");
        log.info("Choose delivery method" + " " + deliveryMethodList.get(m).getText());
        deliveryMethodList.get(m).click();     // FOR NOVAPOSHTA,POCHTOMATI (1. DEPARTMENT 2. TO ADDRESS)
    }

    public void chooseCity(int c, String city) {
        cityField.click();
        searchField.sendKeys(city);
        List<MobileElement> cityList = cityListView.findElementsById("label");
        log.info("Choose city" + " " + cityList.get(c).getText());
        cityList.get(c).click();
    }

    public void chooseRegion(int r) {
        regionField.click();
        List<MobileElement> regionList = dialogListView.findElementsById("text1");
        log.info("Choose region" + " " + regionList.get(r).getText());
        regionList.get(r).click();

    }

    public void chooseDepartment(int d, String department) {
        departmentField.click();
        searchField.sendKeys(department);
        List<MobileElement> departmentList = cityListView.findElementsById("label");
        log.info("Choose department" + " " + departmentList.get(d).getText());
        departmentList.get(d).click();
    }

    public void enterLastName(String lastName) {
        log.info("Enter last name");
        lastNameField.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        log.info("Enter zip code");
        zipCodeField.sendKeys(zipCode);
    }

    public void enterAddress(String address) {
        log.info("Enter address");
        addressField.sendKeys(address);
        driver.hideKeyboard();
    }

    public void enterComment(String comments) {
        log.info("Enter comment");
        commentsField.sendKeys(comments);
    }

    public void clickOnCheckBox() {
        log.info("Click on checkbox");
        agreementCheckBox.click();
    }

    public void submit() {
        log.info("Click on submit button");
        sendOrder.click();
    }

    public void scrollUp() {
        int endx = sendOrder.getLocation().getX();
        int endy = sendOrder.getLocation().getY();
        int startx = deliveryType.getLocation().getX();
        int starty = deliveryType.getLocation().getY();
        ((AndroidDriver) driver).swipe(startx, starty, endx, endy, 3000);
    }
}




