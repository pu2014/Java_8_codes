package com.pu.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @DESC  线程池框架
 * @CREATE BY @Author pbj on @Date 2020/7/14 17:19
 */
public class ExecutorTest {
    public static void main(String[] args) {
        /**
         * return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *
         * 特点：核心线程数和最大线程数一致，链表阻塞队列
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);

        /**
         * new ThreadPoolExecutor(1, 1,
         *                             0L, TimeUnit.MILLISECONDS,
         *                             new LinkedBlockingQueue<Runnable>()));
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }
}
