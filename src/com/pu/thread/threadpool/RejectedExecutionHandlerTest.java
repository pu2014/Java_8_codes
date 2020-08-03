package com.pu.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @DESC  线程池饱和策略
 * @CREATE BY @Author pbj on @Date 2020/8/3 11:35
 */
public class RejectedExecutionHandlerTest {
    /**
     * 1. Abort 中止  抛出 rejectedExcutionException
     * 2. callerRuns 调用者运行
     *          如果所有线程均被占用，就会调用执行execute的线程执行这个任务。主进程就不会恶心execute和accept;
     *          会导致TCP层的队列满载。开始执行抛弃策略。过载蔓延。导致服务器在高并发情况下的平缓的性能降低。
     * 3. discard 丢弃
     * 4. discardOlder 丢弃旧的
     */
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                100,
                100,
                200,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>());
        //设置饱和策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

    }
}
