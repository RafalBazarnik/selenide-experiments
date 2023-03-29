package org.example;

import io.cucumber.java8.En;
import org.example.pages.LoginPage;
import org.example.pages.MainPage;

public class StepDefinitions implements En {
    public StepDefinitions() {
        Given("Loop page is open", () -> new LoginPage().openApp());
        Then("Login form is visible", () -> new LoginPage().verifyLoginFormVisible());
        When("User logs as {string}", (String username) -> new LoginPage().login(username));
        Then("^(User|Manager) is logged as \"([^\"]*)\"$", (String userType, String name) -> new MainPage().verifyUserLogged(name));
    }
}
