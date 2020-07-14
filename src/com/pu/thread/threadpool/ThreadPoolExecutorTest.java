package com.pu.thread.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @DESC 线程池框架
 * @CREATE BY @Author pbj on @Date 2020/7/14 15:10
 */
public class ThreadPoolExecutorTest {
    private static volatile int cnt = 0;
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for(int i = 0; i < 1000; i++){
            executor.execute(new Task());
        }
        executor.shutdown();


    }
    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 执行了 " + cnt++);
            //System.out.println(cnt++);
        }
    }
}
