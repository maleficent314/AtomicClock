package edu.ib;

import java.time.LocalTime;

public class TimeCounter implements Observer {

    private int counter;

    @Override
    public void update(LocalTime localTime) {
        counter++;
        System.out.println("You have updated me " + counter + " times");
    }
}
