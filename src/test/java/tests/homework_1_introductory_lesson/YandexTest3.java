package tests.homework_1_introductory_lesson;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class YandexTest3 {
    @Test
    void avitoSearchTest() {


        open("http://yandex.ru");

        $(byName("text")).setValue("объявления").pressEnter();

        $("html").shouldHave(text("avito.ru"));

    }

}
