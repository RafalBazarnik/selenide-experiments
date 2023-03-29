package org.example.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.common.PropertiesLoader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CommonPage {
    public void openApp() {
        closeWebDriver();
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 9000;
//        Configuration.headless = true;
        Configuration.reportsFolder = "test-result/reports";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Selenide.open(PropertiesLoader.get("baseUrl"));
    }
}
