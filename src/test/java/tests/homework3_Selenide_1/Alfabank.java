package tests.homework3_Selenide_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
//import static com.codeborne.selenide.ElementsCollection;

public class Alfabank {

    @Test
    void archiveDepositsCheck() {
        open("https://alfabank.ru/");
        $(byTitle("Вклады")).hover();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные депозиты")).click();
//        $(".product-cell__cell-box").shouldHave(size(3));


    }
}
