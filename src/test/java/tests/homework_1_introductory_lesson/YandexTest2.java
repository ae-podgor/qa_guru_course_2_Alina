package tests.homework_1_introductory_lesson;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class YandexTest2 extends TestBase {
    @Test
        void javaSearchTest() {

        open("http://yandex.ru");

        $(byName("text")).setValue("java").pressEnter();

        $("html").shouldHave(text("oracle.com"));

    }
}
