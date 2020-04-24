package com.pu.concurrent;

import java.util.HashMap;
import java.util.UUID;

/**
 *  Hashmap Why not for high concurrency?
 *      jdk1.7 caught in a dead loop In high concurrency;
 *      put/get is not synchronized
 *      jdk1.8 use End-insertion method to prevent dead loop
 *
 *      if t.join
 *      the current thread will wait t like
 *      {
 *          while(t.isAlive){
 *              wait(0)
 *          }
 *          notifyAll() -- jvm
 *      }
 *
 */
public class WhyHashMapCannotConcurrent {
    // jdk1.8 not dead loop
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(()->{
            for(int i = 0; i < 10000; i++){
                new Thread(()->map.put(UUID.randomUUID().toString(), ""), "ftf" + i).start();
            }
        }, "ftf");
        t.start();
        t.join(); //等待其内部的
    }
}
