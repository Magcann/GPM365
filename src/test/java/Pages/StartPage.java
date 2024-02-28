package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

public class StartPage {
    public StartPage() {
        open("https://elmadev.gazprom-media.ru");
    }

    public MainPage login (){
        //Это блок авторизации
        $(byName("authLogin")).click();
        $(byName("authLogin")).setValue("m.magnichkin");
        $(byName("password")).click();
        $(byName("password")).setValue("Password))").pressEnter();
        // EnterPass.shouldBe(Condition.visible).click();
        return new MainPage();
        }
    }

