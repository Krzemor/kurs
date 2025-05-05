package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .burgers(3)
                .sauce("standard")
                .ingredients("lettuce")
                .ingredients("chilli peppers")
                .ingredients("bacon")
                .ingredients("cheese")
                .build();

        // When
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        List<String> ingredients = bigmac.getIngredients();

        // Then
        assertEquals("with sesame", bun);
        assertEquals(3, burgers);
        assertEquals("standard", sauce);
        assertTrue(ingredients.contains("lettuce"));
        assertTrue(ingredients.contains("chilli peppers"));
        assertTrue(ingredients.contains("bacon"));
        assertTrue(ingredients.contains("cheese"));
        assertEquals(4, ingredients.size());

        // Optional: print for visual check
        System.out.println(bigmac);
    }
}
