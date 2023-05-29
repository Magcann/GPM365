package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    SelenideElement nsiMenu = $x("//a[@title='НСИ']");
    SelenideElement brendMenu = $x("//span[@class='side-nav__item-label'][contains(text(),'Бренд')]");


    public BrendPage openBrendPage(){
        nsiMenu.shouldBe(Condition.visible).click();
        brendMenu.shouldBe(Condition.visible).click();
        return new BrendPage();

    }

}
