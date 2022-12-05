package com.it_academy.janna.page_ui_object_test;

import com.it_academy.janna.ui_page_object.OnlinerComponentPage;
import com.it_academy.janna.ui_page_object.OnlinerComputerAndNetworksPage;
import com.it_academy.janna.ui_page_object.OnlinerHomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerComponentPageTest extends BaseTest {
    private static OnlinerComponentPage componentsPage;

    @Step("Navigate to onliner.by and click: Каталог -> Компьютеры -> Комплектующие")
    @BeforeClass
    public static void navigateToOnlinerFindAccessoriesTabAndClick() {
        OnlinerHomePage.navigateToOnlinerHomePage()
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        componentsPage = new OnlinerComputerAndNetworksPage()
                .clickOnComputersAndNetworksLink("Комплектующие");
    }

    @Description("Check that in the section: Каталог, Компьютеры и сети, Комплектующие all items contain name")
    @Test
    public void testAllElementsContainName() {
        assertThat(componentsPage.getProductsNames())
                .as("Not all products contain name")
                .allMatch(e -> !e.isEmpty());
    }

    @Description("Check that in the section: Каталог, Компьютеры и сети, Комплектующие all items contain quantity ")
    @Test
    public void testAllElementsContainQuantity() {
        assertThat(componentsPage.getProductsDescription())
                .as("Not all products contain quantity")
                .allMatch(e -> e.contains("товар"));
    }

    @Description("Check that in the section: Каталог, Компьютеры и сети, Комплектующие all items contain price")
    @Test
    public void testAllElementsContainPrice() {
        assertThat(componentsPage.getProductsDescription())
                .as("Not all products contain price")
                .allMatch(e -> e.contains("р."));
    }
}
