import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.lang.annotation.AdviceName;

import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "action_login")
    private MobileElement loginButton;

    @AndroidFindBy(id = "input_layout_name")
    private MobileElement nameField;

    @AndroidFindBy (id = "input_layout_phone")
    private MobileElement phoneField;

    @AndroidFindBy (id = "input_layout_email")
    private MobileElement emailField;

    @AndroidFindBy (id = "tilPayment")
    private MobileElement paymentType;

    @AndroidFindBy (id = "select_dialog_listview")
    private MobileElement paymentListView;

    @AndroidFindBy (id = "tilDelivery")
    private MobileElement deliveryType;

    @AndroidFindBy (id = "select_dialog_listview")
    private MobileElement deliveryListView;

    @AndroidFindBy (id = "tilEdit")
    private MobileElement deliveryMethod;

    @AndroidFindBy (id = "select_dialog_listview")
    private MobileElement deliveryMethodListView;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Фамилия*']") // ALL DELIVERY TYPES
    private MobileElement lastNameField;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Город*']")    // NOVAPOSHTA, MEEST, POCHTOMATI PRIVATBANKA
    private MobileElement cityField;

    @AndroidFindBy (id = "recyclerView")
    private MobileElement cityListView;

    @AndroidFindBy (id = "search_container")
    private MobileElement searchField;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Улица*']")
    private MobileElement streetField;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Дом*']")
    private MobileElement houseField;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Квартира']")
    private MobileElement flatField;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Выберите отделение*']")   // NOVAPOSHTA, MEEST, POCHTOMATI PRIVATBANKA
    private MobileElement departmentField;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Адрес*']")    // CUSTOM DEL TYPE
    private MobileElement addressField;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='Индекс*']")   //CUSTOM DEL TYPE
    private MobileElement zipCodeField;

    @AndroidFindBy (id = "comment_editText")
    private MobileElement commentsField;

    @AndroidFindBy (xpath = "//android.widget.CheckBox")
    private MobileElement agreementCheckBox;

    @AndroidFindBy (id = "btnSendOrder")
    private MobileElement sendOrder;

     public void enterName(String name) {
         nameField.sendKeys(name);
     }

     public void enterPhone (String phone) {
         phoneField.sendKeys(phone);
     }

     public void enterEmail (String email) {
         emailField.sendKeys(email);
     }

     public void choosePaymentType(int t) {
         paymentType.click();
         List<MobileElement> paymentList = paymentListView.findElementsByClassName("android.widget.LinearLayout");
         paymentList.get(t).click();            // 1. PREORDER 2. CASH 3. CASH ON DELIVERY
     }

     public void scrollToComments() {
         String locator = ("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView(new UiSelector().resourceId(\"ua.prom.b2c:id/comment_editText\"))");
         driver.findElement(MobileBy.AndroidUIAutomator(locator));
     }

     public void chooseDevliveryType(int t) {
         deliveryType.click();
         List<MobileElement> deliveryList = deliveryListView.findElementsByClassName("android.widget.LinearLayout");
         deliveryList.get(t).click();           // DIFFERENT DELIVERY TYPES
     }

     public void chooseDeliveryMethod(int m) {
         deliveryMethod.click();
         List<MobileElement> deliveryMethodList = deliveryMethodListView.findElementsByClassName("android.widget.CheckedTextView");
         deliveryMethodList.get(m).click();     // FOR NOVAPOSHTA,POCHTOMATI (1. DEPARTMENT 2. TO ADRESS)
     }

     public void chooseCity(int c, String city) {
         searchField.sendKeys(city);
         List<MobileElement> cityList = cityListView.findElementsById("label");
         cityList.get(c).click();
     }

     public void chooseDepartment(int d, String department) {
         searchField.sendKeys(department);
         List<MobileElement> departmentList = cityListView.findElementsById("label");
         departmentList.get(d).click();
     }

     public void enterComment(String comment) {
         commentsField.sendKeys(comment);
     }

     public void clickOnCheckBox() {
         agreementCheckBox.click();
     }

     public void submit() {
         sendOrder.click();
     }

     public OrderThankYouPage createOrder() {
         sendOrder.click();
         return new OrderThankYouPage(driver);
     }
}
