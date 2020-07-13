package com.pu.thread.concurrent_vector;

/**
 * @DESC Deque 和 BlockingDeque 用于工作密取
 * @CREATE BY @Author pbj on @Date 2020/7/13 20:56
 */
public class BlockingDueueQuestion {
    /**
     * 工作密取，每个线程都有一个自己的双端队列，当一个线程完成了自己双端队列的全部工作，可以从其他消费者双端队列末尾秘密的获取工作
     *
     * 作用： 确保每个线程都保持忙碌状态
     */
}
