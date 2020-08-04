package com.pu.thread.threadpool;

import javax.swing.plaf.synth.SynthColorChooserUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @DESC  线程池框架
 * @CREATE BY @Author pbj on @Date 2020/7/14 17:19
 */
public class ExecutorTest {
    private static volatile int cnt = 0;
    public static void main(String[] args) {
        /**
         * return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *
         * 特点：核心线程数和最大线程数一致，链表阻塞队列
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++){
            fixedThreadPool.execute(()->{
                synchronized (Thread.class){
                    cnt++;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(cnt + Thread.currentThread().getName());
            });
            if(i == 50){
                fixedThreadPool.shutdown();
            }
        }

        /**
         * new ThreadPoolExecutor(1, 1,
         *                             0L, TimeUnit.MILLISECONDS,
         *                             new LinkedBlockingQueue<Runnable>()));
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }
}
