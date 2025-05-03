package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "Shopping";
    public static final String PAINTING = "Painting";
    public static final String DRIVING = "Driving";

    public final Task chooseTask(final String taskType) {
        return switch (taskType) {
            case SHOPPING -> new ShoppingTask("Buying bread", "Bread", 20.5);
            case PAINTING -> new PaintingTask("Painting bedroom", "green", "walls");
            case DRIVING -> new DrivingTask("Driving to shop", "Castorama", "car");
            default -> null;
        };
    }
}
