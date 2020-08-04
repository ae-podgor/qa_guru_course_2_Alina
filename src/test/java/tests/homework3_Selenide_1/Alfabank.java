package tests.homework3_Selenide_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
        $("h3").shouldHave(text("Архивные депозиты"));
        $$(".product-cell__cell").shouldHave(size(3));
    }

    @Test
    void insuranceTransit() {
        open("https://alfabank.ru/make-money/savings-account/");

        $(byTitle("Бесплатные сервисы для накоплений")).closest(".sub-navigation").$(byTitle("Депозиты"))
                .parent().sibling(4).preceding(0).shouldHave(text("Страхование вкладов")).click();

        $("h1").shouldHave(text("Страхование вкладов"));
    }

}
