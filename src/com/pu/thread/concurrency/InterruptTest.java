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
     *
     * 在java中，从开发者角度，中断一个线程的唯一方式是调用interrupt方法。中断是通过调用Thread.interrupt()方法来做的. 这个方法通过修改了被调用线程的中断状态来告知那个线程, 说它被中断了. 对于非阻塞中的线程, 只是改变了中断状态, 即Thread.isInterrupted()将返回true。
     *  java类库中的有些类的方法也可能会调用中断，如FutureTask中的cancel方法，如果传入的参数为true，它将会在正在运行异步任务的线程上调用interrupt方法，又如ThreadPoolExecutor中的shutdownNow方法会遍历线程池中的工作线程并调用线程的interrupt方法。只不过也只是向线程发出中断信号而已，至于接收线程怎样对中断响应，则要由接收线程自己决定。
     *   在Core Java中有这样一句话：”没有任何java语言方面的需求要求一个被中断的程序应该终止。中断一个线程只是为了引起该线程的注意，被中断线程可以决定如何应对中断 “。这里分可响应中断线程和不可响应中断线程两种场景。
     *        可响应中断线程通常指线程处于阻塞状态时，如果收到中断信号时，是否会取消阻塞状态，所以也叫可取消的阻塞状态中的线程。如上面所述，可取消阻塞状态更像一种机制，java中Thread.sleep(), Object.wait(), Thread.join()等都实现了这种机制，所有当你使用sleep这些方式时，java会从语法级别强制你使用try...cacth...语句接收InterruptedException，即阻塞中的线程如果收到中断信号，会通抛出InterruptedException异常将具体响应处理转移给开发者，同时把中断状态置为true，我们可以看sleep等方法的源码，这些方法中都会调用Thread.interrupted()对中断状态进行复位。而像Thread.suspend, Thread.stop这些方式，也是因为由于没有使用可中断机制而被jdk早早Deprecated。
     *        不可响应中断线程是指阻塞中的线程或者在运行线程不会对中断信号作任何响应，如输入和输出流类会阻塞等待 I/O 完成，但是它们不抛出 InterruptedException，而且在被中断的情况下也不会退出阻塞状态. 然而，对于Socket I/O，如果一个线程关闭套接字，则那个套接字上的阻塞 I/O 操作将提前结束，并抛出一个 SocketException。java.nio 中的非阻塞 I/O 类也不支持可中断 I/O，但是同样可以通过关闭通道或者请求 Selector 上的唤醒来取消阻塞操作。通过synchronized尝试获取一个内部锁的操作（进入一个 synchronized 块）是不能被中断的，但是 本篇提到的juc ReentrantLock则支持可中断的获取模式即 tryLock(long time, TimeUnit unit)。
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
