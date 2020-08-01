package tests.homework_2_First_Autotest_Launching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

  }


}
