package lounge.fm;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class MainPageTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void CheckHederMainPage() {
        open("http://loungefm.com.ua/");
        $("#index").shouldHave(text("Lounge Fm"));
        $("#terrace").shouldHave(text("Terrace"));
        $("#acoustic").shouldHave(text("Acoustic"));
        $("#chill").shouldHave(text("Chill Out"));
        $("#podcasts").shouldHave(text("Podcasts"));
        $("#navbarDropdown").shouldHave(text("Radioshow")).click();
        ElementsCollection a = $$x("//a[@class='dropdown-item']");
        a.get(0).shouldHave(text("EASY GROOVES"));
        a.get(1).shouldHave(text("Chill Out Essentials"));
        a.get(2).shouldHave(text("Buddha Bar"));
        a.get(3).shouldHave(text("Deep Inside By Timo"));
        $("#about").shouldHave(text("About"));
        $("#contacts").shouldHave(text("Contacts"));
        $(".img[src='img/logo.png']").isDisplayed();
    }

    @CsvSource(value = {
            "0, http://loungefm.com.ua/grooves",
            "1, http://loungefm.com.ua/essentials",
            "2, http://loungefm.com.ua/buddha",
            "3, http://loungefm.com.ua/timo"
    })
    @ParameterizedTest(name = " Проверка перехода по пунктам выпадающего меню Радиошоу {0}")
    public void CheckTransitionsInDropdownMenuItems(String arrayNumber, String testdata) {
        open("http://loungefm.com.ua/");
        $("#navbarDropdown").shouldHave(text("Radioshow")).click();
        ElementsCollection a = $$x("//a[@class='dropdown-item']");
        a.get(Integer.parseInt(arrayNumber)).click();
        webdriver().shouldHave(url(testdata));
    }


    static Stream<Arguments> goToTheAppsStore() {
        return Stream.of(
                Arguments.of((".//a[@title='Официальное приложение Lounge FM для Android']"),
                        Arguments.of(".//a[@title='Официальное приложение Lounge FM для iOS']")
                ));
    }

    @MethodSource
    @ParameterizedTest(name = "Переход в аппстор - {0}")
    public void goToTheAppsStore(String buttons) {
        open("http://loungefm.com.ua/");
        $x(buttons).click();
        switchTo().window(1);
    }
}

