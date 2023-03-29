package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.common.PropertiesLoader;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage extends CommonPage {
    public static SelenideElement
            loginLabel = $(".username-group label"),
            loginInput = $(byName("username")),
            passwordLabel = $(".password-group label"),
            passwordInput = $(byName("password")),
            loginButton = $(byText("Sign In"));

    public static ElementsCollection
            inputs = $$(byTagName("input"));


    public void verifyLoginFormVisible() {
        loginLabel.shouldBe(visible, Duration.ofSeconds(20));
        inputs.shouldHave(size(5));
    }

    public void login(String username, String password) {
        loginInput.shouldBe(visible).sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.shouldBe(enabled).click();
    }

    public void login(String username) {
        String user = PropertiesLoader.get(username);
        String password = PropertiesLoader.get("password");
        login(user, password);
    }

}
