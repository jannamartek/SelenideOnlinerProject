package com.it_academy.janna.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Configuration.browserSize;

public class WebDriverFactoryStaticThreadLocal {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        browserSize = "3840x2160";
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
