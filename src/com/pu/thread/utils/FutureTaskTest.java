package com.pu.thread.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @DESC  FutureTask 实现闭锁
 *  FutureTask 实现提前加载稍后需要的数据
 *
 *  futureTask.get() 数据准备好了，加载，否则会等待加载
 * @CREATE BY @Author pbj on @Date 2020/7/13 21:24
 */
public class FutureTaskTest {

}
class PreLoader{
    private final FutureTask<Product> futureTask = new FutureTask<>(new Callable<Product>() {
        @Override
        public Product call() throws Exception {
            return loadProductInfo();
        }
    });
    private final Thread thread = new Thread(futureTask);
    public void start(){
        thread.start();
    }

    public Product get() throws ExecutionException {
        try {
            return futureTask.get();
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if(cause instanceof ExecutionException){
                throw (ExecutionException)cause;
            }
        }
        return null;
    }

    private Product loadProductInfo() {
        return new Product(1, 2);
    }
}

class Product{
    private int id;
    private int state;

    public Product(int id, int state) {
        this.id = id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
