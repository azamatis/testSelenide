package com.test.mavenproject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    @BeforeClass
    public static void setUp() {
        Configuration.baseUrl = "https://www.wikipedia.org";
        
    }

    @Test
    public void testSearchOnWikipedia() {
        open("https://www.wikipedia.org");
        $("#searchInput").setValue("Selenide").pressEnter();
        $("#firstHeading").shouldHave(text("Selenide"));
    }
    

    @Test
    public void testReturnToMainPage() {
        open("https://www.wikipedia.org");
        $("#menu").$("a").find(By.linkText("Просмотра кода")).pressEnter();
        $("#ca-view").$("#ca-talk").click();
        $("#mw-returnto").$("a").find(By.linkText("Заглавная страница")).shouldBe(visible);
    }

    @Test
    public void testArticleParagraphs() {
        open("https://www.wikipedia.org/wiki/Selenide");
        $$(".mw-parser-output > p").shouldHave();
    }

    @Test
    public void testArticleContents() {
        open("https://www.wikipedia.org");
        $("#toc").shouldBe(visible);
    }

    @Test
    public void testChangeLanguage() {
        open("https://www.wikipedia.org");
        $(".central-featured-lang").click();
        $(".langlist").shouldBe(visible);
    }
}

