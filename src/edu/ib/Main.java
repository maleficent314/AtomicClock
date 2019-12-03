package edu.ib;

public class Main {

    public static void main(String[] args) {
        AtomicClock atomicClock = new AtomicClock();
        TimeKeeper timeKeeper = new TimeKeeper();
        atomicClock.registerObserver(timeKeeper);
        TimeCounter timeCounter = new TimeCounter();
        atomicClock.registerObserver(timeCounter);
        atomicClock.start();

       /* AtomicClock[] madness = new AtomicClock[1000];
        for (int i = 0; i < madness.length; i++) {
            madness[i] = new AtomicClock();
            madness[i].start();
        } */

    }
}
