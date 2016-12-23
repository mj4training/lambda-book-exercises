/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Melissa
 */
public class ReentrantQueue {
    private static final int CAPACITY = 4;
    private final Queue queue = new LinkedList<>();
    
    // lock and condition variables
    private final Lock aLock = new ReentrantLock(true); // Enable fairness
    private final Condition queueNotFull = aLock.newCondition();
    private final Condition queueNotEmpty = aLock.newCondition();

    public void put(int num) throws InterruptedException {
        aLock.lock();
        try {
            while (queue.size() == CAPACITY) {
                System.out.println(Thread.currentThread().getName()
                        + " : Queue is full, waiting");
                queueNotFull.await();
            }
            
            int number = num;
            boolean isAdded = queue.offer(number);
            if (isAdded) {
                System.out.printf("%s added %d into queue %n", Thread
                        .currentThread().getName(), number);

                // signal consumer thread that, queue has element now
                System.out.println(Thread.currentThread().getName()
                        + " : Signalling that queue is not empty now");
                queueNotEmpty.signalAll();
            }
        } finally {
            aLock.unlock();
        }
    }

    public int get() throws InterruptedException {
        aLock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName()
                        + " : Queue is empty, waiting");
                queueNotEmpty.await();
            }

            Integer num = (Integer)queue.poll();
            if (num != null) {
                System.out.printf("%s consumed %d from queue %n", Thread
                        .currentThread().getName(), num);

                // signal producer thread that, queue may be empty now
                System.out.println(Thread.currentThread().getName()
                        + " : Signalling that queue is not full now");
                queueNotFull.signalAll();
                return(num);
            } else {
                return(-99);
            }
        } finally {
            aLock.unlock();
        }
    }
}