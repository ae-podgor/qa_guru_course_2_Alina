package tests.homework_2_First_Autotest_Launching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class agrodomaCartTests {
  private static String url = "http://agrodoma.ru/";

  @BeforeEach
  void openBrowser(){
    // Открыть главную страницу
    open(url);
  }

  @Test
  void addingToCartFromProductPage () {
    // Навести курсор на раздел
    $(byTitle("Домашнее дерево")).hover();
    // Выбрать подраздел
    $(byText("Цитрус")).click();
    // Перейти на страницу продукта
    $(byText("Лимон комнатный")).click();
    // Добавить продукт в корзину
    $(byValue("В корзину")).click();
    // Проверить, что продукт есть в корзине
    $(byClassName("mini-cart-info")).shouldHave(text("Лимон комнатный"));
    // Удалить продукт из корзины
    $(".remove").shouldBe(visible).click();
  }

  @Test
  void addingToCartFromCatalogPage() {
    // Перейти на страницу каталога
    $(byTitle("Бонсай домашний")).click();
    // Найти карточку товара и добавить с неё продукт в корзину
    $(byText("Гинкго (бонсай)")).parent().parent().$(byValue("В корзину")).click(); // как найти просто по слову "Гинкго"?
    // Проверить, что продукт есть в корзине
    $(byClassName("mini-cart-info")).shouldHave(text("Гинкго (бонсай)"));
    // Удалить продукт из корзины
    $(".remove").shouldBe(visible).click();
  }



}
