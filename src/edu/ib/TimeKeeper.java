package edu.ib;

import java.time.LocalTime;

public class TimeKeeper implements Observer {
    @Override
    public void update(LocalTime localTime) {
        System.out.println("Thanks for the update now updated: " + localTime);
    }
}
