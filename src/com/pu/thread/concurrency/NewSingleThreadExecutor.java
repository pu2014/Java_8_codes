package com.pu.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @DESC 利用 NewSingleThreadExecutor 实现线程的排队
 * @CREATE BY @Author pbj on @Date 2020/7/7 14:02
 */
public class NewSingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(()->{
            System.out.println(1);
        });
        executorService.submit(()->{
            System.out.println(2);
        });
        executorService.submit(()->{
            System.out.println(3);
        });
        executorService.shutdown();

        LinkedBlockingDeque<Thread> queue = new LinkedBlockingDeque<>();
        queue.add(new Thread(()->{
            System.out.println(1);
        }));
        queue.add(new Thread(()->{
            System.out.println(2);
        }));
        queue.add(new Thread(()->{
            System.out.println(3);
        }));
        while(!queue.isEmpty()){
            Thread thread = queue.poll();
            thread.start();
            thread.join();
        }
    }
}
