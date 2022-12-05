package com.it_academy.janna.page_ui_object_test;


import com.it_academy.janna.ui_page_object.OnlinerCatalogPage;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class OnlinerCatalogPageTest extends BaseTest {

    private static final List<String> EXPECTED_SECTION = Arrays.asList
            ("Электроника", "Компьютеры и сети", "Бытовая техника",
                    "Стройка и ремонт", "Дом и сад", "Авто и мото",
                    "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда");

    @Description("Check that menu items have section list: Электроника, Компьютеры и сети, " +
            "Бытовая техника, Стройка и ремонт, Дом и сад, Авто и мото, Красота и спорт," +
            "Детям и мамам, Работа и офис, Еда")
    @Test
    public void testCheckInCatalogSections() {
        Assertions.assertThat(new OnlinerCatalogPage().getCatalogLinks())
                .as("Page sections don't contain section list")
                .containsAll(EXPECTED_SECTION);
    }
}
