package com.pu.thread.lock;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * @DESC  发布安全的对象
 * 1. 线程封闭：对象封闭在该线程中
 * 2. 只读共享： 不可修改 final
 * 3. 线程安全共享： 多个线程通过对象的共有接口来进行访问
 * 4. 保护对象： 持有锁才可以访问
 * @CREATE BY @Author pbj on @Date 2020/7/7 14:55
 */
public class CreateSafeObject {
    public static void main(String[] args) {

    }
    /**
     * 封闭机制来实现线程安全（装饰器模式）
     * :Vector HashTable ：将他们的状态封装起来，并对每个公有的方法都进行同步，使得每次只有一个线程访问容器的状态
     */
    class PersonSet{
        //"this" 为锁
        private final Set<Object> mySet = new HashSet<>();

        public synchronized void addPerson(Object p){
            mySet.add(p);
        }

        public synchronized boolean isContainsPerson(Object p){
            return mySet.contains(p);
        }
    }
    /**
     * 锁机制实现
     */

    class Numbers{
        private final Object lock = new Object();
        private int count;
        void someMethod(){
            synchronized (lock){
                //dosomething
            }
        }
    }
}
