/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

import java.util.Random;

/**
 *
 * @author Melissa
 */

public class Producer implements Runnable {
    private ProducerConsumerTestDrop drop;

    public Producer(ProducerConsumerTestDrop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (String importantInfo1 : importantInfo) {
            drop.put(importantInfo1);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                System.err.println("Thread: " + Thread.currentThread().getName()
                        + " run() interrupted due to: " + e.getMessage());
            }
        }
        drop.put("DONE");
    }
}
