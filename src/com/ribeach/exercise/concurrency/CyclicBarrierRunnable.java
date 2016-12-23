/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 *
 * @author Melissa
 */
public class CyclicBarrierRunnable implements Runnable {
    CyclicBarrier barrier1 = null;

    public CyclicBarrierRunnable(CyclicBarrier barrier1) {

        this.barrier1 = barrier1;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
            this.barrier1.await();

            System.out.println(Thread.currentThread().getName() + " done!");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
