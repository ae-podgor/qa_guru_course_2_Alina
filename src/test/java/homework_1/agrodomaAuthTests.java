package homework_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class agrodomaAuthTests {
  private static String url = "http://agrodoma.ru/";
  private static String email = "piffatko@gmail.com";
  private static String password = "Qwerty123!";
  private static String firstname = "Lilit";
  private static String lastname = "Darkmoon";


  @BeforeEach
  void openBrowser(){
    // Открыть главную страницу
    open(url);
  }

  @BeforeEach
  void goToAuthPage() {
    // Нажать на человечка
    $(".fa-user").click();
  }

  @Test
  void successfulLogin() {
    // Ввести корректные почту и пароль, нажать кнопку "Войти"
    $(byId("input-email")).setValue(email);
    $(byId("input-password")).setValue(password);
    $(byValue("Войти")).click();

    // Перейти в раздел "Основные данные"
    $x("//ul[@class='list-unstyled']//a").shouldHave(text("Основные данные")).click();

    // Проверить, что данные в профиле совпадают с нужными
    $(byId("input-firstname")).shouldHave(value(firstname));
    $(byId("input-lastname")).shouldHave(value(lastname));
    $(byId("input-email")).shouldHave(value(email));

    // Выйти из аккаунта
    $(".box-category a[href='http://agrodoma.ru/logout/']");
  }

  @Test
    void wrongEmailLogin() {
    // Ввести неправильную почту и правильный пароль, нажать кнопку "Войти"
    $(byId("input-email")).setValue("wrongemail@mail.com");
    $(byId("input-password")).setValue(password);
    $(byValue("Войти")).click();

    // Проверить, что есть сообщение об ошибке
    $(".alert-danger").shouldHave(text(" Неправильно заполнены поля E-Mail и/или пароль!"));
  }

  @Test
    void wrongPasswordLogin() {
    // Ввести правильную почту и неправильный пароль, нажать кнопку "Войти"
    $(byId("input-email")).setValue(email);
    $(byId("input-password")).setValue("Wrong123!");
    $(byValue("Войти")).click();

    // Проверить, что есть сообщение об ошибке
    $(".alert-danger").shouldHave(text(" Неправильно заполнены поля E-Mail и/или пароль!"));
  }

}
