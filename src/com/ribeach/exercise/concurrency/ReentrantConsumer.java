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
public class ReentrantConsumer implements Runnable {
        ReentrantQueue sharedQ;

    public ReentrantConsumer(ReentrantQueue sharedQ) {
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        try {
            // Allow Q to become full before trying to consume anything
            Thread.sleep(1000);
            int num = sharedQ.get();
            System.out.println(Thread.currentThread().getName()
                        + " : Got value " + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
