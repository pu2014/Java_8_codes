package com.pu.thread.threadpool;

import java.util.concurrent.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/4 16:46
 */
public class CallableTest {
    static class Task implements Callable {

        @Override
        public Object call() throws Exception {
            String str = "my Thread name" + Thread.currentThread().getName();
            return str;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            Future future = service.submit(new Task());
            while(!future.isDone()){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
