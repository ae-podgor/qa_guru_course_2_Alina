package tests.homework_1_introductory_lesson;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Disabled
class YandexTest2 {
    @Test
        void javaSearchTest() {

        open("http://yandex.ru");

        $(byName("text")).setValue("java").pressEnter();

        $("html").shouldHave(text("oracle.com"));

    }
}
