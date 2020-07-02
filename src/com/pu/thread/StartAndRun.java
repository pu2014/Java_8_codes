package com.pu.thread;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/13 16:35
 */
public class StartAndRun {
    public static void main(String[] args) {
        StartAndRunThread thread = new StartAndRunThread();
        thread.run();
        thread.start();
    }
}
class StartAndRunThread extends Thread{
    @Override
    public void run(){
        System.out.println("The current thread is " + Thread.currentThread().getName() + " is running");
    }
}

