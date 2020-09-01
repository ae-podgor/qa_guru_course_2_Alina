package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class TestBase {

    @BeforeAll
    @Step("Tests setup")
    public static void beforeAll() {
        addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
        Configuration.headless = true;
    }

    @AfterEach
    @Step("Attachments")
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());

        closeWebDriver();
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }


}
