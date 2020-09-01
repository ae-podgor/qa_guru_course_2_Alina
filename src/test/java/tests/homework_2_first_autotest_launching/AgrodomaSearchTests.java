package tests.homework_2_first_autotest_launching;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AgrodomaSearchTests extends TestBase {
    private static String url = "http://agrodoma.ru/";

    void openBrowser() {
        open(url);
    }

    @Test
    void flowerSearch() {
        openBrowser();
        String plantName = "Дионея";
        // Нажать на лупу и ввести название растения
        $(".fa-search").click();
        $(Objects.requireNonNull(getFocusedElement())).setValue(plantName).pressEnter();
        // Проверить, что в результатах есть это растение
        $(byText("Товары, соответствующие критериям поиска")).shouldHave(text(plantName));
    }

    @Test
    void notExistItemSearch() {
        openBrowser();
        // Нажать на лупу и ввести название растения
        $(".fa-search").click();
        $(Objects.requireNonNull(getFocusedElement())).setValue("blah-blah").pressEnter();
        // Проверить, что в результат поиска ничего нет
        $(".content").shouldHave(text("Нет товаров, соответствующих критериям поиска."));
    }
}
