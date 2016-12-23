/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Melissa
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws Exception {
        
        // Barrier action Runnable defined as a Lambda
        Runnable barrier1Action = () -> {
            System.out.println("BarrierAction 1 executed ");
        };     

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);

        CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1);

        CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();

        Thread.sleep(4000);
    }
}
