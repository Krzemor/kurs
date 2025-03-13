package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeEach
    public void setUp() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);                                      // [15]
        temperaturesMap.put("Krakow", 26.2);                                       // [16]
        temperaturesMap.put("Wroclaw", 24.8);                                      // [17]
        temperaturesMap.put("Warszawa", 25.2);                                     // [18]
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateMeanTemperature() {
        //When
        double meanTemperature = weatherForecast.calculateMeanTemperature();

        //Then
        Assertions.assertEquals(25.56, meanTemperature);
    }

    @Test
    void testCalculateMedianTemperature() {
        //Then
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        //When
        Assertions.assertEquals(25.5, medianTemperature);
    }
}
