package com.pu.thread.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/7/13 21:38
 */
public class SemaphoreTest {
}
class BoundingHashSet<T>{
    private final Set<T> set;
    private final Semaphore semaphore;

    BoundingHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        semaphore.acquire();
        boolean res = false;
        try{
            res = set.add(t);
            return res;
        }finally {
            if(!res){
                semaphore.release();
            }
        }
    }
    public boolean remove(T t){
        boolean res = set.remove(t);
        if(res){
            semaphore.release();
        }
        return res;
    }

}
