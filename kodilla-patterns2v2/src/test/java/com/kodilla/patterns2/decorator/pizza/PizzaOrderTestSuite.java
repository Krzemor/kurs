package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
        assertEquals("Dough, tomato sauce, cheese", description);
    }

    @Test
    public void testPizzaWithMushroomsAndSalamiOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(24), calculatedCost);
        assertEquals("Dough, tomato sauce, cheese, mushrooms, salami", description);
    }

    @Test
    public void testPizzaWithAllAddonsOrder() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);

        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(28), calculatedCost);
        assertEquals("Dough, tomato sauce, cheese, mushrooms, olives, onion, salami", description);
    }
}
