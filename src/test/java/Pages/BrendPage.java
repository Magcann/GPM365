package Pages;

import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.ous.jtoml.impl.Token.TokenType.Key;

public class BrendPage {

    SelenideElement brendAddButton = $x("//button[@class=\"btn btn-primary\"][contains(text(),'Бренд')]");
    SelenideElement nameBrend = $x("//elma-form-control/elma-type-string/div/input");
    SelenideElement chooseRD = $x("(.//*[normalize-space(text()) and normalize-space(.)='Рекламодатель'])[1]/following::button[1]");
    SelenideElement RD_op1 =$x("//td[@class=\"cell___name ng-star-inserted\"][1]");
   // SelenideElement RD_op1 =$x("//tr[@class=\"p-element p-selectable-row ng-star-inserted\"][1]");
    SelenideElement RD_op2_segment =$x("(.//*[normalize-space(text()) and normalize-space(.)='Сегмент SMA'])[1]/following::button[1]");
    SelenideElement RD_segment =$x("//td[@class=\"cell___name ng-star-inserted\"]//span[@class=\"ng-star-inserted\"]");
    SelenideElement saveButton =$x("//button[@data-test=\"createVacancyB\"][contains(text(),\"Сохранить\")]");
    ElementsCollection createdNameBrend =$$x("//span[@class=\"ng-star-inserted\"]");
    SelenideElement searchInput = $x("//div[@class=\"nav-search\"]/input");
    ElementsCollection searchResults = $$x("//span[@class=\"ng-star-inserted\"]");

    public BrendPage brendAdd(String brendName) {
        brendAddButton.shouldBe(visible).click();
        nameBrend.shouldBe(visible).setValue(brendName); // воткнуть переменную на имя бренд
        chooseRD.shouldBe(visible).click();
        RD_op1.shouldBe(visible).click();
        RD_op2_segment.shouldBe(visible).click();
        RD_segment.shouldBe(visible).click();
        sleep(1000);
        saveButton.shouldBe(visible).click();
        return this;
    }


    public ElementsCollection searchBrend(String searchString){
        searchInput.shouldBe(visible).setValue(searchString).sendKeys(Keys.ENTER);
        return searchResults;
    }





    public void openBrendAdd(){
        brendAddButton.shouldBe(visible).click();

    }

}
