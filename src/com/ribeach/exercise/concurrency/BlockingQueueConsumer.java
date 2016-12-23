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
public class BlockingQueueConsumer implements Runnable {
    
    protected BlockingQueue<String> queue = null;
    
    /**
     *
     * @param queue
     */
    public BlockingQueueConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
