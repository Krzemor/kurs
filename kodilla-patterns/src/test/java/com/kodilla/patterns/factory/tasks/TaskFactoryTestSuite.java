package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.ShapeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.chooseTask(TaskFactory.SHOPPING);

        //Then
        assertEquals("Buying bread", shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());

        shopping.executeTask();
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.chooseTask(TaskFactory.PAINTING);

        //Then
        assertEquals("Painting bedroom", shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());

        shopping.executeTask();
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.chooseTask(TaskFactory.DRIVING);

        //Then
        assertEquals("Driving to shop", shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());

        shopping.executeTask();
        assertTrue(shopping.isTaskExecuted());
    }
}
