package com.pu.thread.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Blocking multiple threads to the same point and openg the barrier utill the last thread comes.
 *   Can be reset. but CountDownLatch can not
 *   当线程到达栅栏时调用await方法，这个方法将阻塞直到所有线程到达栅栏位置，如果所有线程到达，栅栏将打开，此时所有线程都会被
 *   释放，栅栏重置以便下次使用。
 *
 *
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(3, new A());

    public static void main(String[] args) {
        new Thread(()->{
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }).start();

        new Thread(()->{
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        }).start();

        try{
            c.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("2");
    }
    static class A implements Runnable{

        @Override
        public void run() {
            System.out.println("3");
        }
    }
}

