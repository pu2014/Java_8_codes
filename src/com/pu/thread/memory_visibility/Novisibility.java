package com.pu.thread.memory_visibility;

/**
 * @DESC java线程的可见性
 * @CREATE BY @Author pbj on @Date 2020/7/2 19:51
 */
public class Novisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            while(!ready){
                Thread.yield();//让出时间片，不释放锁
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ReaderThread();
        t.start();
        //t.join();
        number = 42;
        ready = true;
    }
}
