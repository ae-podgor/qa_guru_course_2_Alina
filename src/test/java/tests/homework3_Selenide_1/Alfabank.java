package tests.homework3_Selenide_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class Alfabank {

    @Test
    void archiveDepositsCheck() {
        open("https://alfabank.ru/");
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные депозиты")).click();
        $$(".product-cell__cell").shouldHave(size(3));
    }
}
