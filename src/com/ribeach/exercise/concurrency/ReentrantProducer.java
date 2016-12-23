/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

/**
 *
 * @author Melissa
 */
public class ReentrantProducer implements Runnable {
        ReentrantQueue sharedQ;

    public ReentrantProducer(ReentrantQueue sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        try {
            /*
             * Demonstrates reentrancy because this thread locks for each
             * put() call
            */
            sharedQ.put(1);
            sharedQ.put(2);
            sharedQ.put(3);
            sharedQ.put(4); // This one will fill the Q
            sharedQ.put(5); // This one should wait until Q is not full
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}