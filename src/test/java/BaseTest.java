import com.codeborne.selenide.Configuration;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;

public class BaseTest {
    public BaseTest() {
    }

    public void setUp(String PLATFORM_AND_BROWSER) {
        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
                System.setProperty("chromeoptions.args","--disable-popup-blocking");
                break;
            case "win_firefox":
                WebDriverManager.firefoxdriver().setup();
                Configuration.browser = "firefox";
                break;
            default:
                Assert.isTrue(false, "Incorrect platform");
        }
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.fastSetValue=true;
    }

    public String RandomString(int n) {

        int length = n;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    } // генерация случайной строки


}
