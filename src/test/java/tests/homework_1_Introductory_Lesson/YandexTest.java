package tests.homework_1_Introductory_Lesson;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class YandexTest {
    @Test
    void selenideSearchTest() {
//        Configuration.browser = FIREFOX;
        // Открыть yandex
        open("http://yandex.ru");

        // Ввести Selenide в поиск
        $(byName("text")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
       $("html").shouldHave(text("ru.selenide.org"));
    }
}
