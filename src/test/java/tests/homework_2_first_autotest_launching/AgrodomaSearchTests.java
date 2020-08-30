package tests.homework_2_first_autotest_launching;

import io.qameta.allure.selenide.AllureSelenide;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Disabled
public class AgrodomaSearchTests {
    private static String url = "http://agrodoma.ru/";

    @BeforeEach
    void openBrowser() {
        open(url);
    }

    @Test
    void flowerSearch() {
        String plantName = "Дионея";
        // Нажать на лупу и ввести название растения
        $(".fa-search").click();
        $(Objects.requireNonNull(getFocusedElement())).setValue(plantName).pressEnter();
        // Проверить, что в результатах есть это растение
        $(byText("Товары, соответствующие критериям поиска")).shouldHave(text(plantName));
    }

    @Test
    void notExistItemSearch() {
        // Нажать на лупу и ввести название растения
        $(".fa-search").click();
        $(Objects.requireNonNull(getFocusedElement())).setValue("blah-blah").pressEnter();
        // Проверить, что в результат поиска ничего нет
        $(".content").shouldHave(text("Нет товаров, соответствующих критериям поиска."));
    }
}
