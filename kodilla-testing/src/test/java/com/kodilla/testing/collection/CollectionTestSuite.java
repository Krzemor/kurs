package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("When exterminator with empty list, then should return empty")
    @Test
    void testOddNumbersExterminatorEmptyList () {
        //Given
        List<Integer> emptyList = new ArrayList<Integer>();
        OddNumbersExterminator o = new OddNumbersExterminator();

        //When
        List<Integer> result = o.exterminate(emptyList);

        //Then
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("When exterminator with list, then should return list without odd numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        OddNumbersExterminator o = new OddNumbersExterminator();

        //When
        List<Integer> result = o.exterminate(numList);

        //Then
        Assertions.assertEquals(expected, result);
    }
}
