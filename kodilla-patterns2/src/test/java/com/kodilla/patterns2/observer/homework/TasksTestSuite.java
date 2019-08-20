package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class TasksTestSuite {
    @Test
    public void testUpdateTaskList() {
        //Given
        Tasks patternsTasks = new PatternsTasks();
        Tasks webServicesTasks = new WebServicesTasks();
        Mentor johnSmith = new Mentor("John Smith");
        Mentor alexKovalsky = new Mentor("Alex Kovalsky");
        patternsTasks.registerObserverMentor(johnSmith);
        patternsTasks.registerObserverMentor(alexKovalsky);
        webServicesTasks.registerObserverMentor(alexKovalsky);
        //When
        patternsTasks.addTask("Observator");
        patternsTasks.addTask("Builder pattern");
        webServicesTasks.addTask("Heroku");
        webServicesTasks.addTask("Controller");
        patternsTasks.addTask("Singleton");
        //Then
        assertEquals(3, johnSmith.getUpdateTasksCount());
        assertEquals(5, alexKovalsky.getUpdateTasksCount());
    }
}


