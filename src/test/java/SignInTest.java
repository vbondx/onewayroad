import org.testng.annotations.Test;

/**
 * Created by v.bondarenko on 22.07.17.
 */
public class SignInTest extends BaseTest {

    @Test

    public void signInPosotiveTest(){
        BluetoothProblemsPage bluetoothProblemsPage = new BluetoothProblemsPage(driver);
        SignInPage signInPage = bluetoothProblemsPage.goToSignInPage();
        signInPage.enterUsername("maventests+patient+1@gmail.com");
        signInPage.enterPassword("Password11");

    }
}
