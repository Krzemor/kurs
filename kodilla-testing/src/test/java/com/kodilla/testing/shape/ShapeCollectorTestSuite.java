package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape squere = new Square(2);

        //When
        collector.addFigure(squere);

        //Then
        assertEquals(1, collector.getFiguresQuantity());
    }

    @Nested
    @DisplayName("Tests for removing")
    class TestRemoving{
        @Test
        public void testRemoveFigure() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            Shape squere = new Square(2);
            collector.addFigure(squere);

            //When
            boolean removed = collector.removeFigure(squere);

            //Then
            assertTrue(removed);
            assertEquals(0, collector.getFiguresQuantity());
        }

        @Test
        public void testRemoveFigureNotExisting(){
            //Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(3);

            //When
            boolean removed = collector.removeFigure(circle);

            //Then
            assertFalse(removed);
        }
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape triangle = new Triangle(4, 5);
        collector.addFigure(triangle);

        //When
        Shape retrivedFigure = collector.getFigure(0);

        //Then
        assertEquals(triangle, retrivedFigure);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        collector.addFigure(new Square(3));
        collector.addFigure(new Circle(2));
        collector.addFigure(new Triangle(4, 5));

        //When
        String result = collector.showFigures();

        //Then
        assertEquals("Square, Circle, Triangle", result);
    }
}
