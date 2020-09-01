package tests.homework_2_first_autotest_launching;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Owner("apodgornova")
@Epic("Тесты сайта agrodoma.ru")
@Feature("Авторизация на сайте")
public class AgrodomaAuthTests extends TestBase {
    private static String url = "http://agrodoma.ru/";
    private static String email = "piffatko@gmail.com";
    private static String password = "Qwerty123!";
    private static String firstname = "Lilit";
    private static String lastname = "Darkmoon";

    void goToAuthPage() {
        open(url);
        $(".fa-user").click();
    }

    @Test
    @DisplayName("Пользователь должен иметь возможность авторизоваться на сайта")
    void successfulLogin() {
        goToAuthPage();
        $("#input-email").setValue(email);
        $("#input-password").setValue(password);
        $(byValue("Войти")).click();

        // Перейти в раздел "Основные данные"
        $(byText("Основные данные")).click();
        // Проверить, что данные в профиле совпадают с нужными
        $("#input-firstname").shouldHave(value(firstname));
        $("#input-lastname").shouldHave(value(lastname));
        $("#input-email").shouldHave(value(email));

        // Выйти из аккаунта
        $(byText("Выйти")).click();
    }

    @Test
    @DisplayName("Пользователь не должен авторизоваться, если был введён неверный e-mail")
    void wrongEmailLogin() {
        goToAuthPage();
        $("#input-email").setValue("wrongemail@mail.com");
        $("#input-password").setValue(password);
        $(byValue("Войти")).click();

        // Проверить, что есть сообщение об ошибке
        $(".alert-danger").shouldHave(text(" Неправильно заполнены поля E-Mail и/или пароль!"));
    }

    @Test
    @DisplayName("Пользователь не должен авторизоваться, если был введён неверный пароль")
    void wrongPasswordLogin() {
        goToAuthPage();
        $("#input-email").setValue(email);
        $("#input-password").setValue("Wrong123!");
        $(byValue("Войти")).click();

        // Проверить, что есть сообщение об ошибке
        $(".alert-danger").shouldHave(text(" Неправильно заполнены поля E-Mail и/или пароль!"));
    }

}
