package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private int ctr = 0;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(TasksQueue tasksQueue) {
        System.out.println("Mentor " + name + ": new task in " + tasksQueue.getStudentName() + "'s queue. " +
                "\n" + "Total tasks: " + tasksQueue.getTasks().size());
        ctr++;
    }

    public int getCtr() {
        return ctr;
    }

}
