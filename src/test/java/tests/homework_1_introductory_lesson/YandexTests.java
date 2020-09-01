package tests.homework_1_introductory_lesson;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



class YandexTests extends TestBase {
    @Test
        void selenideSearchTest() {
        // Открыть yandex
        open("http://yandex.ru");

        // Ввести Selenide в поиск
        $(byName("text")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void javaSearchTest() {

        open("http://yandex.ru");

        $(byName("text")).setValue("java").pressEnter();

        $("html").shouldHave(text("oracle.com"));

    }

    @Test
    void avitoSearchTest() {


        open("http://yandex.ru");

        $(byName("text")).setValue("объявления").pressEnter();

        $("html").shouldHave(text("avito.ru"));

    }
}
