package com.pu.thread.concurrency;

import javafx.concurrent.Task;

import java.util.concurrent.BlockingQueue;

/**
 * @DESC  中断响应：
 *  java没有抢占式中断，只提供了中断响应
 *      通过推迟中断请求的处理，更具有灵活性。
 * 当调用可中断的阻塞函数时， Thread.sleep() 或者 BlockingQueue.put:
 *          1. 传递异常
 *          2. 恢复中断状态，从而使得调用栈的上层代码可以对其进行处理。
 * @CREATE BY @Author pbj on @Date 2020/7/14 14:26
 */
public class InterruptTest {
    public static void main(String[] args) {

    }

    /**
     * 不可取消的任务在退出前恢复中断
     * @param queue
     * @return
     */
    public static Task getNextTask(BlockingQueue<Task> queue){
        boolean isInterrupted = false;
        try {
            while (true) {
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    isInterrupted = true;
                }
            }
        }finally {
            if(isInterrupted){
                Thread.currentThread().interrupt();
            }
        }
    }
}
