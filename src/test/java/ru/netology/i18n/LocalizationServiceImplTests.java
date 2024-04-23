package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;

public class LocalizationServiceImplTests {

    @ParameterizedTest
    @CsvSource(value = {
            "RUSSIA, Добро пожаловать",
            "USA, Welcome",
            "BRAZIL, Welcome",
            "GERMANY, Welcome"})
    public void testLocale(String country, String answer) {
        LocalizationService localizationService = new LocalizationServiceImpl();

        String actual = localizationService.locale(Country.valueOf(country));
        String expected = String.valueOf(answer);

        Assertions.assertEquals(expected, actual);
    }
}
