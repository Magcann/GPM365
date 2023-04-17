import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class Tests  extends BaseTest{

    @Test
    public void testYandex() {
        setUp("win_firefox");
        open("http://elmadev.gazprom-media.ru");
//Это блок авторизации
        $(byName("authLogin")).click();
        $(byName("authLogin")).setValue("m.magnichkin");
        $(byName("password")).click();
        $(byName("password")).setValue("uW2vHCxhnbwWKwL");
        $(By.cssSelector(".submit-button")).click();

//выполняем навигацию на меню НСИ
        $(byText("НСИ")).shouldBe(enabled,ofSeconds(5));
        $(byText("НСИ")).click();
//выполняем навигацию на меню Бренд
        $(byText("Бренд")).shouldBe(enabled,ofSeconds(5));
        $(byText("Бренд")).click();
//Нажимаем на кнопку + Бренд
        $(byText("+ Бренд")).shouldBe(enabled,ofSeconds(5));
        $(byText("+ Бренд")).click();



        //Вводим наименование Бренда
        $(byXpath("//elma-form-control/elma-type-string/div/input")).sendKeys("auto_test_123456s"); // воткнуть переменную на имя бренд
//Выбор из справочника рекламодателей
        $(byXpath("(.//*[normalize-space(text()) and normalize-space(.)='Рекламодатель'])[1]/following::button[1]")).click();
// Выбираем из справочника  бренд
        $(byXpath("(.//*[normalize-space(text()) and normalize-space(.)='Тест отмены бренда 3'])[1]/preceding::span[8]")).shouldBe(enabled,ofSeconds(5));
        $(byXpath("(.//*[normalize-space(text()) and normalize-space(.)='Тест отмены бренда 3'])[1]/preceding::span[8]")).click();


        $(byXpath("(.//*[normalize-space(text()) and normalize-space(.)='Сегмент SMA'])[1]/following::button[1]")).shouldBe(enabled,ofSeconds(5));
        $(byXpath("(.//*[normalize-space(text()) and normalize-space(.)='Сегмент SMA'])[1]/following::button[1]")).click();


        $(byText("Жевательная конфета")).shouldBe(enabled,ofSeconds(5));
        $(byText("Жевательная конфета")).click();

        $(byXpath("//*/text()[normalize-space(.)='Сохранить']/parent::*")).shouldBe(enabled,ofSeconds(5)).click();

        $(byText("auto_test_123456s")).shouldBe(enabled,ofSeconds(5));
        $(byText("auto_test_123456s")).click();
        Selenide.sleep(5000);
    }

}
