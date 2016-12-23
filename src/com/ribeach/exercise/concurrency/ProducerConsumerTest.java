/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ribeach.exercise.concurrency;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        ProducerConsumerTestDrop drop = new ProducerConsumerTestDrop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}