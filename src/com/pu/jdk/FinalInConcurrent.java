package com.pu.jdk;

/**
 * @DESC final
 * final 修饰的字段不可修改，引用的话地址不可改变
 * final 修饰的方法不能重写
 * final 修饰的类不可继承
 *
 * final的重排序
 *  构造函数和对final域的读写操作不能重排序
 * final可见性
 *  被final修饰的字段在构造器中一旦被初始化完
 * 成，并且构造器没有把“this”的引用传递出去（this引用逃逸是一件很危险的事情，其他线程有可能通
 * 过这个引用访问到“初始化了一半”的对象），那么在其他线程中就能看见final字段的值。
 * @CREATE BY @Author pbj on @Date 2020/5/12 16:19
 */
public class FinalInConcurrent {
    /**
     * concurrentHashMap的Node源码
     * {
     *     final int hash;
     *     final K key;
     *     volatile V val;
     *     volatile Node<k,v> next;
     * }
     */
}
