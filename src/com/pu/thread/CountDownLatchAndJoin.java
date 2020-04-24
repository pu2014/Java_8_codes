package com.pu.thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch llow one or more threads to wait for other threads to complete operationsa
 *      like join() but is more stronger;
 */
public class CountDownLatchAndJoin {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println(3);

    }
}
