package lounge.fm;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainPageTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
    }
    //TODO Сделать параметризацию, принимать на вход: число - элемент массива(для гет[]), текст, который нужно проверять, оригинальный элемен страницы перехода
    //TODO{0, "EASY GROOVES", локатор элемента}

    @Test
    public void CheckElementsOfMainPage() {
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
        $x("//img[@src='img/sliders/carousel_donate/fm_banner.jpg']").click();

    }
}

