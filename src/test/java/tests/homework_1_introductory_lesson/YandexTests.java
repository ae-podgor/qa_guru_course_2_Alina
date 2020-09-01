package tests.homework_1_introductory_lesson;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Owner("apodgornova")
@Epic("Тесты сайта yandex.ru")
@Feature("Поиск различных ресурсов по ключевому слову")
class YandexTests extends TestBase {

    @DisplayName("Пользователь должен иметь возможность найти сайт selenide.org по ключевому слову Selenide")
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
    @DisplayName("Пользователь должен иметь возможность найти сайт oracle.com по ключевому слову java")
    void javaSearchTest() {

        open("http://yandex.ru");

        $(byName("text")).setValue("java").pressEnter();

        $("html").shouldHave(text("oracle.com"));

    }

    @Test
    @DisplayName("Пользователь должен иметь возможность найти сайт avito.ru по ключевому слову объявления")
    void avitoSearchTest() {


        open("http://yandex.ru");

        $(byName("text")).setValue("объявления").pressEnter();

        $("html").shouldHave(text("avito.ru"));

    }
}
