/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Melissa
 */
public class BlockingQueueProducer implements Runnable {
    
    protected BlockingQueue<String> queue = null;

    /**
     *
     * @param queue
     */
    public BlockingQueueProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
