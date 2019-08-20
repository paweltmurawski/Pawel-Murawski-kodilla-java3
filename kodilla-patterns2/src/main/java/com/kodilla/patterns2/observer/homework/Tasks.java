package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Tasks implements ObservableMentors {
    private final List<ObserverMentor> observersMentors;
    private final List<String> tasksList;
    private final String name;

    public Tasks(String name) {
        observersMentors = new ArrayList<>();
        tasksList = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasksList.add(task);
        notifyObserversMentors();
    }

    @Override
    public void registerObserverMentor(ObserverMentor observerMentor) {
        observersMentors.add(observerMentor);
    }

    @Override
    public void notifyObserversMentors() {
        for (ObserverMentor observerMentor : observersMentors) {
            observerMentor.updateTasksList(this);
        }
    }

    @Override
    public void removeObserverMentor(ObserverMentor observerMentor) {
        observersMentors.remove(observerMentor);
    }

    public List<String> getTasksList() {
        return tasksList;
    }

    public String getName() {
        return name;
    }
}
