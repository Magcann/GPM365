import Pages.BrendPage;
import Pages.MainPage;
import Pages.StartPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.Main;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

public class Tests  extends BaseTest{

    @Test
    public void start(){
        setUp("win_firefox");
        String name = RandomString(10);

        StartPage start = new StartPage();
        SelenideElement element = start.login().openBrendPage().brendAdd(name).searchBrend(name).get(2);
       // ElementsCollection elements = start.login().openBrendPage().brendAdd(name).searchBrend(name);


       Assert.assertEquals(name, element.getText());
     //   Assert.assertTrue(elements.stream().map(SelenideElement::getText).anyMatch(s -> s.contains(name)));
        Assert.assertEquals("Полученное значение имени не совпадает с ожидаемым", "name1", element.getText());

        sleep(5000);

    }

}
