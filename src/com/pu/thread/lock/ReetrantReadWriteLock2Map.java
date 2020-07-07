package com.pu.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @DESC 读写锁实现 hashmap的安全性
 * @CREATE BY @Author pbj on @Date 2020/7/7 14:47
 */
public class ReetrantReadWriteLock2Map {
    static Map<String, Object> cache = new HashMap<>();
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock r = lock.readLock();
    static Lock w = lock.writeLock();
    public static final  Object get(String key){
        r.lock();
        try{
            return cache.get(key);
        }finally {
            r.unlock();
        }
    }
    public static final void put(String key, Object val){
        w.lock();
        try{
            cache.put(key,val);
        }finally {
            w.unlock();
        }
    }
}
