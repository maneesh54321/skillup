package com.learning.twentyfour.concurrency;

import java.util.concurrent.CyclicBarrier;

public class BuildH2O {

    public static void main(String[] args) {

    }

    CyclicBarrier barrier = new CyclicBarrier(3);

    public BuildH2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }
}
