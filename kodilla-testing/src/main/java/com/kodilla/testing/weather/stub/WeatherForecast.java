package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 Celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateMeanTemperature() {
        Map<String, Double> temps = temperatures.getTemperatures();
        double sum = 0;
        for(double temperature : temps.values()) {
            sum += temperature;
        }
        return sum / temps.size();
    }

    public double calculateMedianTemperature() {
        List<Double> tempList = new ArrayList<>(temperatures.getTemperatures().values());

        Collections.sort(tempList);
        int size = tempList.size();
        if (size % 2 == 0) {
            return (tempList.get(size / 2) + tempList.get(size / 2 - 1)) / 2;
        } else {
            return tempList.get(size / 2);
        }
    }
}
