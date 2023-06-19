package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StartPage {
    public StartPage() {
        open("http://elmadev.gazprom-media.ru");
    }

    public MainPage login (){
        //Это блок авторизации
        $(byName("authLogin")).click();
        $(byName("authLogin")).setValue("m.magnichkin");
        $(byName("password")).click();
        $(byName("password")).setValue("Password");
        $(By.cssSelector(".submit-button")).click();
        return new MainPage();
    }








}
