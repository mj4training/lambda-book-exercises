/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

import static com.ribeach.exercise.concurrency.SimpleThreadTest.threadMessage;

/**
 *
 * @author Melissa
 */
public class SimpleThreadMessageLoop implements Runnable {
        @Override
        public void run() {
            String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };
            try {
                for (String importantInfo1 : importantInfo) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    SimpleThreadTest.threadMessage(importantInfo1);
                }
            } catch (InterruptedException e) {
                SimpleThreadTest.threadMessage("I wasn't done!");
            }
        }
}