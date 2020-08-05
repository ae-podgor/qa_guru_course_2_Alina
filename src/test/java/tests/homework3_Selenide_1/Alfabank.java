package tests.homework3_Selenide_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

import static com.codeborne.selenide.CollectionCondition.*;

public class Alfabank {

    @BeforeEach
    void openMainPage() {
        open("https://alfabank.ru/");
    }

    @Test
    void question() {
        $(byTitle("Вклады")).click();

        //Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли
        //привести к тому что, поиск найдёт разные элементы?

        // Оба теста отрабатывают... Не понимаю, в чём разница.

        $(".product-cell__result").$("h3").shouldHave(text("Процент за остаток на счете"));
        $(".product-cell__result h3").shouldHave(text("Процент за остаток на счете"));
    }

    @Test
    void archiveDepositsCheck() {
        // Переход на страницу с архивными депозитами с главной страницы
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные депозиты")).click();
        // Assertions
        $("h3").shouldHave(text("Архивные депозиты"));
        $$(".product-cell__cell").shouldHave(size(3));
    }

    @Test
    void insuranceTransit() {
        // Запрограммируйте тест переход на страницу Вклады->Страхование
        // вкладов, используя для поиска sibling(), preceding(), parent(), closest()
        $(byTitle("Вклады")).click();

        // Использовала сразу все четыре метода.
        $(byTitle("Бесплатные сервисы для накоплений")).closest(".sub-navigation").$(byTitle("Депозиты"))
                .parent().sibling(4).preceding(0).shouldHave(text("Страхование вкладов")).click();
        // Assertion
        $("h1").shouldHave(text("Страхование вкладов"));
    }

}
