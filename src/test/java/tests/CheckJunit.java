package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckJunit {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void checkJunit() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(".Box-row.wiki-more-pages-link").$("button").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class"))
                .findElement(byText("@ExtendWith"));
    }

}
