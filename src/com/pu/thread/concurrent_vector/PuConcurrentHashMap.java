package com.pu.thread.concurrent_vector;

import java.util.ConcurrentModificationException;

/**
 * @DESC ConcurrentHashMap -- Map的安全实现
 *  1. 不会抛出 ConcurrentModificationException， 不是fast-fail机制，弱一致性的迭代器容忍并发的请修改。
 *      可以但是不保证在迭代器被构造后将修改操作反映给容器。
 *
 *
 *      Collections.synchronizedMap(Map) : 内部维护一个普通对象的Map,以及一个锁，暴露的接口会加锁
 *      HashTable： 数组构成，对数据的每一个操作都会枷加锁，不允许key和value为null， HashMap的key和value都可以为null
 *              put null 会直接抛出空指针异常，而HashMap做了特殊处理 (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *              HashTable 是fail-safe 安全失败机制，会使得你此次读取的数据不一定是最新的数据。使用null值，无法判断对应的key是否是存在还是为空，
 *              因为你无法调用contain(key)来进行判断 ConcurrentHashMap同理
 *      ConcurrentHashMap
 * @CREATE BY @Author pbj on @Date 2020/7/13 16:12
 */
public class PuConcurrentHashMap {
    /**
     * jdk1.7： （数组链表）分段锁 （reetrantLock) segment数组  segment 继承 ReetrantLock  put时 先自旋获得锁，获取失败就阻塞获得锁
     *          get过程不加锁， 利用volatile 实现，保证内存的可见性，所以每次获取时都是最新的值
     *
     *          先判断是否超过阈值再扩容
     * jdk1.8： （数组链表红黑树）不采用分段锁，CAS + syschronized 保证并发性
     *          Node{
     *              volatile Node next;
     *              volatile Object value;
     *          }
     *
     *          put 操作： 1. key定位后， 如果为空表示当前位置可以写入，CAS写入，失败自旋写入
     *                    2. 如果当前位置 == -1 需要扩容
     *                    3. synchronized 锁写入、
     *          扩容机制：1. 所在链表的个数达到了阈值8, 数组长度大于64，则会调用treeifuBin 方法把链表转换成红黑树。
     *                  2. 数组长度小于64时， 调用 tryPresize方法把数组长度扩大为两倍，然后重新调整位置
     *                  3. 新增节点之后，调用addCount()方法记录元素个数，检查是否扩容，数组元素个数达到阈值会触发 transfer方法，重新调整节点的位置
     *
     *          先加入元素 ++size判断是否需要扩容
     *          多线程并发：扩容时len*2， get()操作如果原来的元素还没有移动，返回，如果移动，get()帮助扩容。 弱一致性，返回的不一定是准确结果
     *                  volatile修饰的数组引用是强可见的，但是其元素却不一定，所以，这导致size的根据sumCount的方法并不准确
     *                  同理Iteritor的迭代器也一样，并不能准确反映最新的实际情况
     */
}
