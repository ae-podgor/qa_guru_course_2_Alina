package tests.homework_2_first_autotest_launching;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Owner("apodgornova")
@Epic("Тесты сайта agrodoma.ru")
@Feature("Работа с поиском товаров")
public class AgrodomaSearchTests extends TestBase {
    private static String url = "http://agrodoma.ru/";

    void openBrowser() {
        open(url);
    }

    @Test
    @DisplayName("Пользователь должен иметь возможность найти товар после ввода ключевого слова в строку поиска")
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
    @DisplayName("Пользователь не должен найти товар, если было введено наименование несуществующего в каталоге товара")
    void notExistItemSearch() {
        openBrowser();
        // Нажать на лупу и ввести название растения
        $(".fa-search").click();
        $(Objects.requireNonNull(getFocusedElement())).setValue("blah-blah").pressEnter();
        // Проверить, что в результат поиска ничего нет
        $(".content").shouldHave(text("Нет товаров, соответствующих критериям поиска."));
    }
}
