package com.kodilla.patterns2.observer.homework;

public class Mentor implements ObserverMentor {
    private final String mentorName;
    private int updateTasksCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void updateTasksList(Tasks tasks) {
        System.out.println("Mentor " + mentorName + " have " + tasks.getName() + "\n" +
                "total: " + tasks.getTasksList().size() + " tasks to check");
        updateTasksCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateTasksCount() {
        return updateTasksCount;
    }
}
