package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Location;

public class GeoServiceImplTests {
    @ParameterizedTest
    @CsvSource(value = {
            "127.0.0.1, null",
            "172., RUSSIA",
            "96., USA"})
    public void testByIp(String ip, String country) {
        GeoService geoService = new GeoServiceImpl();
        Location location = geoService.byIp(ip);

        String actual = String.valueOf(location.getCountry());
        String expected = String.valueOf(country);

        Assertions.assertEquals(expected, actual);
    }
}