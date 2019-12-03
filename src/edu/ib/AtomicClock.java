package edu.ib;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AtomicClock implements Runnable, Observable {

    private Thread worker; //wątek
    protected volatile boolean isRunning = false;
    private int interval;
    private LocalTime localTime;
    private ArrayList<Observer> observers;

    public AtomicClock() {
        interval = 2000;
        observers = new ArrayList<>();
    }

    public void start() {
        worker = new Thread(this, "Clock thread");
        worker.start();
        System.out.println("Creating new thread");
    }

    public void stop() {
        isRunning = false;
    }

    public void interrupt() {
        isRunning = false;
        worker.interrupt();
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
           // localTime = LocalTime.now();
           // System.out.println("Updating time: " + localTime);
            updateObservers();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)){
            observers.add(o);
            System.out.println(o + " connected to atomic clock");
        }
    }

    @Override
    public void removeObserver(Observer o) {

        if(observers.contains(o)){
            observers.remove(o);
            System.out.println(o + " disconnencted");
        }
    }

    @Override
    public void updateObservers() {

        for(Observer o: observers){
            localTime = LocalTime.now();
            o.update(localTime);
        }
    }
}
