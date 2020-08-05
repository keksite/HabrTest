package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class TestHabr {

    @Test
    void DropDownListSholdBeVisible() {
        // Открыть habr.com
        open("https://habr.com/ru/");
        //нажать на раскрывающийся список
       $(byId("dropdown-control")).click();
       // проверить что раскрывающийся список доступен
       $(byId("dropdown")).shouldBe(visible);
    }

    @Test
    void LanguageShouldBeChangedOnRuntime() {

        open("https://habr.com/ru/");
        //Нажать кнопку смены языка
        $(byCssSelector(".btn_navbar_lang")).click();
        //Переключить язык
        $("label[for='hl_langs_en']").click();
        //Проверить что текст заголовка переключился на английски
        $(".popup__head_lang-settings").shouldBe(text("Language settings"));
    }
    @Test
    void SearchBarShouldBeVisible() {

        open("https://habr.com/ru/");
        //Кликнуть на кнопку поиска
        $(".btn_navbar_search").click();
        //Проверить что поле поиска появилось
        $("#search-form-field").shouldBe(visible);
    }
    @Test
    void LogInFormShouldBeOpened() {

        open("https://habr.com/ru/");
        //Нажать на кнопку Войти
        $("#login").click();
        // Проверить что форма логина появилась
        $("#login_form").shouldBe(visible);
    }

    @Test
    void RegistrationFormShouldBeOpened() {
        open("https://habr.com/ru/");
        //Нажать на кнопку Зарегестрироваться
        $(".btn_navbar_registration").click();
        //Проверить что форма регистрации появилась
        $("#register_form").shouldBe(visible);
    }

}