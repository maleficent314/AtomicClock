package edu.ib;

public interface Observable {

    void registerObserver(Observer o); //możliwość dodawania sybskrybentów

    void removeObserver(Observer o);

    void updateObservers();

}
