package com.pu.thread.concurrent_vector;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @DESC 阻塞队列实现生产者和消费者模型
 *
 * 2、BlockingQueue中的方法
 *
 * BlockingQueue既然是Queue的子接口，必然有Queue中的方法，上面已经列了。看一下BlockingQueue中特有的方法：
 * （1）void put(E e) throws InterruptedException
 * 把e添加进BlockingQueue中，如果BlockingQueue中没有空间，则调用线程被阻塞，进入等待状态，直到BlockingQueue中有空间再继续
 * （2）void take() throws InterruptedException
 * 取走BlockingQueue里面排在首位的对象，如果BlockingQueue为空，则调用线程被阻塞，进入等待状态，直到BlockingQueue有新的数据被加入
 * @CREATE BY @Author pbj on @Date 2020/7/13 19:48
 */
public class BlockQueuePCQuestion {
    public static void main(String[] args) {
        final BlockingQueue<Object> objectPool = new ArrayBlockingQueue<>(10);
        Thread producter = new Thread(new Product(objectPool));
        Thread consumer = new Thread(new Consumer(objectPool));
        producter.start();
        consumer.start();
    }

    static class Product implements Runnable{
        final BlockingQueue<Object> objectPool;
        public Product(BlockingQueue<Object> objectPool) {
            this.objectPool = objectPool;
        }

        @Override
        public void run() {
            int i = 0;
            while(true){
                try {
                    objectPool.put(i++ + "");
                    System.out.println("我生产了一个对象String: " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Consumer implements Runnable{
        final BlockingQueue<Object> objectPool;

        Consumer(BlockingQueue<Object> objectPool) {
            this.objectPool = objectPool;
        }

        @Override
        public void run() {
            while (true){
                try {
                    String dst = (String) objectPool.take();
                    System.out.println("我消费了: " + dst);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
