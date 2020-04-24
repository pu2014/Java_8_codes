package com.pu.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
    Blocking multiple threads to the same point and openg the barrier utill the last thread comes.
    Can be reset. but CountDownLatch can not
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

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

