package com.pu.thread.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @DESC  闭锁：countdownlatch 实现
 * @CREATE BY @Author pbj on @Date 2020/7/13 21:13
 */
public class CountDownLatchTest {
    static CountDownLatch downLatch = new CountDownLatch(30);
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                //线程都会被阻塞
                downLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " output number : " + count);
                count.addAndGet(1);
                try {
                    downLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();

    }
}
