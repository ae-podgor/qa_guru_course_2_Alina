package tests.homework_2_First_Autotest_Launching;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class agrodomaSearchTests {
  private static String url = "http://agrodoma.ru/";

  @BeforeEach
  void openBrowser(){
    open(url);
  }

  @Test
  void flowerSearch() {
    String plantName = "Дионея";
    // Нажать на лупу и ввести название растения
    $(".fa-search").click();
    $(getFocusedElement()).setValue(plantName).pressEnter();
    // Проверить, что в результатах есть это растение
    $(byText("Товары, соответствующие критериям поиска")).shouldHave(text(plantName));
  }

  @Test
  void notExistItemSearch() {
    // Нажать на лупу и ввести название растения
    $(".fa-search").click();
    $(getFocusedElement()).setValue("blah-blah").pressEnter();
    // Проверить, что в результат поиска ничего нет
    $(".content").shouldHave(text("Нет товаров, соответствующих критериям поиска."));
  }
}
