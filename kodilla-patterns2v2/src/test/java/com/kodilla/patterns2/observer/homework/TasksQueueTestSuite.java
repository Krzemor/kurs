package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksQueueTestSuite {

    @Test
    public void testUpdate() {
        //Given
        TasksQueue q1 = new TasksQueue("Jan");
        TasksQueue q2 = new TasksQueue("Paweł");
        TasksQueue q3 = new TasksQueue("Anna");

        Mentor m1 = new Mentor("Tomasz");
        Mentor m2 = new Mentor("Juliana");

        q1.registerObserver(m1);
        q2.registerObserver(m2);
        q3.registerObserver(m1);

        //When
        q1.addTask("Task 1");
        q1.addTask("Task 2");
        q2.addTask("Task 3");
        q2.addTask("Task 4");
        q2.addTask("Task 5");
        q3.addTask("Task 6");
        q3.addTask("Task 7");

        //Then
        assertEquals(4, m1.getCtr());
        assertEquals(3, m2.getCtr());
    }
}
