package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends CommonPage {
    public static SelenideElement
            userLoggedName = $(".btn-user");

    public static ElementsCollection
            navOptions = $$(byTagName(".nav-menu-links div"));

    public void verifyUserLogged(String name) {
        userLoggedName.shouldBe(Condition.visible, Duration.ofSeconds(10)).shouldHave(Condition.text(name));
    }
}
