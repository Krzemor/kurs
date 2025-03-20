package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        // Given

        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland", new BigDecimal("38000000")));
        europe.addCountry(new Country("Germany", new BigDecimal("83000000")));
        europe.addCountry(new Country("France", new BigDecimal("67000000")));

        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("China", new BigDecimal("1400000000")));
        asia.addCountry(new Country("India", new BigDecimal("1380000000")));

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(new Country("USA", new BigDecimal("331000000")));
        northAmerica.addCountry(new Country("Canada", new BigDecimal("38000000")));

        Continent southAmerica = new Continent("South America");
        southAmerica.addCountry(new Country("Brazil", new BigDecimal("213000000")));
        southAmerica.addCountry(new Country("Argentina", new BigDecimal("45000000")));

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);

        // When
        BigDecimal totalPopulation = world.getPeopleQuantity();

        // Then
        BigDecimal expectedPopulation = new BigDecimal("3595000000");
        assertEquals(expectedPopulation, totalPopulation);
    }

}
