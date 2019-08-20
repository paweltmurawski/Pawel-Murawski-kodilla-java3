package com.kodilla.patterns2.observer.homework;

public interface ObservableMentors {
    void registerObserverMentor (ObserverMentor observerMentor);
    void notifyObserversMentors();
    void removeObserverMentor(ObserverMentor observerMentor);
}
