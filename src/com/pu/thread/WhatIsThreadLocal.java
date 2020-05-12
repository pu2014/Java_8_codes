package com.pu.thread;

import javafx.concurrent.Task;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @DESC Spring使用ThreadLocal解决线程安全问题
 * @CREATE BY @Author pbj on @Date 2020/5/12 12:23
 */
public class WhatIsThreadLocal{
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public String getStr() {
        return threadLocal.get();
    }

    public  void setStr(String str) {
        threadLocal.set(str);
    }

    public static void main  (String[] args) throws Exception {
        int threads = 9;
        WhatIsThreadLocal demo = new WhatIsThreadLocal();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for(int i = 0; i < threads; i++){
            new Thread(()->{
                demo.setStr(Thread.currentThread().getName());
                System.out.println(demo.getStr());
                countDownLatch.countDown();
            }, "Thread - " + i).start();
        }
    }
}


