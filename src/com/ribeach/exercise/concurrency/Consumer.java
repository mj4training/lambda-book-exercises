/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

import java.util.Random;

public class Consumer implements Runnable {
    private ProducerConsumerTestDrop drop;

    public Consumer(ProducerConsumerTestDrop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {
            
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                System.err.println("Thread: " + Thread.currentThread().getName()
                        + " run() interrupted due to: " + e.getMessage());
            }
        }
    }
}
