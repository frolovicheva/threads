package ru.geekbrains.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLock {
    private Lock lock = new ReentrantLock();
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    void incCounter() {
        lock.lock ();
        try {
           counter++;
       } finally {
           lock.unlock ();
       }
    }
}
