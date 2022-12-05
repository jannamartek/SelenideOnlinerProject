package com.it_academy.janna.page_ui_object_test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.janna.framework.WebDriverFactoryStaticThreadLocal;
import com.it_academy.janna.listener.AllureListener;
import com.it_academy.janna.ui_page_object.OnlinerHomePage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(AllureListener.class)
public class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp() {
        SelenideLogger
                .addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        WebDriverFactoryStaticThreadLocal.setDriver();
        OnlinerHomePage.navigateToOnlinerHomePage();
    }

    @Step("Close driver")
    @AfterClass
    public void closeDriver() {
        WebDriverFactoryStaticThreadLocal.closeDriver();
        LOG.info("Driver close");
    }
}
