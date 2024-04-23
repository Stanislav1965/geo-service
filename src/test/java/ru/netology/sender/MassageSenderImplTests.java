package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MassageSenderImplTests {
    @Test
    public void testSendRussia() {

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.RUSSIA);

        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp("172.")).thenReturn(location);


        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");

        String actual = String.valueOf(messageSender.send(headers));
        String expected = "Добро пожаловать";

        assertEquals(expected, actual);
    }

    @Test
    public void testSendUSA() {

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.USA);

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.")).thenReturn(location);


        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");

        String actual = String.valueOf(messageSender.send(headers));
        String expected = "Welcome";

        assertEquals(expected, actual);
    }

    @Test
    public void testSendBrazil() {

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.BRAZIL)).thenReturn("Welcome");

        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.BRAZIL);

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.")).thenReturn(location);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");

        String actual = String.valueOf(messageSender.send(headers));
        String expected = "Welcome";

        assertEquals(expected, actual);
    }
}


