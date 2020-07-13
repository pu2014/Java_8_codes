package com.pu.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁（close lock）
 * CountDownLatch llow one or more threads to wait for other threads to complete operationsa
 *      like join() but is more stronger;
 */
public class CountDownLatchAndJoin {
    private String str;
    private String getStr(){
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

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

        /**
         * 测试 在多个线程访问同一个变量时候出现的异常，线程间的数据没有隔离。ThreadLocal解决
         */
        int threads = 9;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        CountDownLatchAndJoin countDownLatchAndJoin = new CountDownLatchAndJoin();
        for(int i = 0; i < threads; i++){
            Thread thread = new Thread(()->{
                countDownLatchAndJoin.setStr(Thread.currentThread().getName());
                System.out.println(countDownLatchAndJoin.getStr());
                countDownLatch.countDown();
            }, "thread - " + i);
            thread.start();
        }

    }
}
