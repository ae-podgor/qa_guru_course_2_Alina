package tests.homework_3_selenide_1;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Tag("Alfabank")
public class AlfabankTests extends TestBase {

    public void openMainPage() {
        open("https://alfabank.ru/");
    }

    @Test
        // Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли
        // привести к тому что, поиск найдёт разные элементы?

        // Оба теста отрабатывают... Не понимаю, в чём разница.
    void questionTest() {
        open("https://alfabank.ru/make-money/savings-account/");

        $(".product-cell__result").$("h3").shouldHave(text("Процент за остаток на счете"));
        $(".product-cell__result h3").shouldHave(text("Процент за остаток на счете"));
    }

    @Test
    void archiveDepositsCheckTest() {
        openMainPage();

        // Переход на страницу с архивными депозитами с главной страницы
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные депозиты")).click();

        $("h3").shouldHave(text("Архивные депозиты"));
        $$(".product-cell__cell").shouldHave(size(3));
    }

    @Test
        // Запрограммируйте тест переход на страницу Вклады->Страхование
        // вкладов, используя для поиска sibling(), preceding(), parent(), closest()
    void insuranceTransitTest() {
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
