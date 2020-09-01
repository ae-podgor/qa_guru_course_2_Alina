package tests.homework_3_selenide_1;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;


@Owner("apodgornova")
@Epic("Тесты сайта alfabank.ru")
@Feature("Работа над переходом по локаторам (ДЗ)")
@Tag("Alfabank")
public class AlfabankTests extends TestBase {

    public void openMainPage() {
        open("https://alfabank.ru/");
    }

    @Test
    @DisplayName("Тест проверяет два случая использования локаторов для выяснения их различий")
    void questionTest() {

        // Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли
        // привести к тому что, поиск найдёт разные элементы?

        open("https://alfabank.ru/make-money/savings-account/");

        // Оба теста отрабатывают... Не понимаю, в чём разница.
        $(".product-cell__result").$("h3").shouldHave(text("Процент за остаток на счете"));
        $(".product-cell__result h3").shouldHave(text("Процент за остаток на счете"));
    }

    @Test
    @DisplayName("Проверка того, что в разделе \"Архивные депозиты\" представлено 3 архивных депозита")
    void archiveDepositsCheckTest() {
        //Запрограммировать такой автотест на странице Alfabank
        //- На страничке "Вклады" перейти на подстраничку "Депозиты"
        //- Перейти по линку на "Архивные депозиты"
        //- Убедится, что представлено ровно три архивных депозита
        openMainPage();

        // Переход на страницу с архивными депозитами с главной страницы
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные депозиты")).click();

        $("h3").shouldHave(text("Архивные депозиты"));
        $$(".product-cell__cell").shouldHave(size(3));
    }

    @Test
    @DisplayName("Проверка того, что можно найти верный элемент на странице, использую селенидовские элементы")
    void insuranceTransitTest() {
        // Запрограммируйте тест переход на страницу Вклады->Страхование
        // вкладов, используя для поиска sibling(), preceding(), parent(), closest()
        openMainPage();

        $(byTitle("Вклады")).click();
        $(byTitle("Бесплатные сервисы для накоплений"))
                .closest(".sub-navigation")
                .$(byTitle("Депозиты"))
                .parent()
                .sibling(4)
                .preceding(0)
                .shouldHave(text("Страхование вкладов")).click();

        $("h1").shouldHave(text("Страхование вкладов"));
    }

}
