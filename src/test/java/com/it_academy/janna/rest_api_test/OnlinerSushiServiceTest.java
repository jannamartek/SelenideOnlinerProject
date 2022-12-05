package com.it_academy.janna.rest_api_test;

import com.it_academy.janna.rest_api.service.OnlinerSushiService;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerSushiServiceTest {
    private final OnlinerSushiService productsService = new OnlinerSushiService();

    @Description("Проверить, что каждый объект содержит поля: id, key, name, full_name")
    @Test
    public void testProductNamesAreNotEmpty() {
        assertThat(productsService.getProducts())
                .as("Object without a name")
                .noneMatch(element -> element.getName().isEmpty());
    }

    @Description("Проверить, что все name_prefix из респонса содержат выбранный фильтр: Роллы")
    @Test
    public void testProductNamesOfTypeRollsContainsPrefixRolls() {
        assertThat(productsService.getNamePrefixes())
                .as("Name_prefix does not contain the text 'Rolls' ")
                .allMatch(element -> element.contains("Роллы"));
    }
}
