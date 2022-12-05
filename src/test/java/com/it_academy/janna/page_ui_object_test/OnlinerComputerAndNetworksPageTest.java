package com.it_academy.janna.page_ui_object_test;

import com.it_academy.janna.ui_page_object.OnlinerComputerAndNetworksPage;
import com.it_academy.janna.ui_page_object.OnlinerHomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerComputerAndNetworksPageTest extends BaseTest {
    private static final List<String> EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS = Arrays.asList
            ("Ноутбуки, компьютеры, мониторы",
                    "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private static OnlinerComputerAndNetworksPage computersAndNetworksPage;

    @Step("Navigate to onliner.by and click: Каталог -> Компьютеры и сети")
    @BeforeClass
    public static void navigateToOnlinerFindComputersAndNetworksTabAndClick() {
        OnlinerHomePage.navigateToOnlinerHomePage()
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        computersAndNetworksPage = new OnlinerComputerAndNetworksPage()
                .clickOnCatalogClassifierLink();
    }

    @Description("Check that in the section: Каталог -> Компьютеры и сети submenu items contain: " +
            "Ноутбуки, компьютеры, мониторы, Комплектующие, Хранение данных, Сетевое оборудование")
    @Test
    public void testSectionComputerAndNetworkList() {
        assertThat(computersAndNetworksPage.getComputersAndNetworksLinks())
                .as("Page sections don't contain section list")
                .containsAll(EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS);
    }
}

