package com.pu.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/7/7 14:23
 */
public class SyncAndLock {
    static final Object lock = new Object();
    //可以实现公平锁
    static final ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        //尝试非阻塞的获得锁
        System.out.println(reentrantLock.tryLock());

        //可响应中断
        //reentrantLock.lockInterruptibly();
        reentrantLock.lock();

        try{
        }finally {
            reentrantLock.unlock();
        }
    }
}
