package com.pu.thread.concurrency;

/**
 * @DESC 线程的状态： new Runnable blocking waiting time-waiting terminate
 * @CREATE BY @Author pbj on @Date 2020/7/13 21:01
 */
public class ThreadState {
    public static void main(String[] args) {

        /**
         * InterruptedException : 抛出interruptedException,说明该方法是一个阻塞方法，如
         *          果这个方法提前被中断，那么它将提前结束阻塞状态
         * 如何处理：
         *      传递 interruptException： 避开异常，传递给方法的调用者
         *      恢复中断： 不能抛出时，恢复中断状态来屏蔽中断
         */
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //恢复中断状态
            Thread.currentThread().interrupt();
        }

    }
}
