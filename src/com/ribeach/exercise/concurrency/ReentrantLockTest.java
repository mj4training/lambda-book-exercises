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
public class ReentrantLockTest {
        public static void main(String[] args) throws Exception {

        ReentrantQueue queue = new ReentrantQueue();
        System.out.println(queue.toString());

        Runnable producer = new ReentrantProducer(queue);
        Runnable consumer = new ReentrantConsumer(queue);

        new Thread(producer, "PRODUCER").start();
        new Thread(consumer, "CONSUMER").start();

        Thread.sleep(10000);
    }
}
