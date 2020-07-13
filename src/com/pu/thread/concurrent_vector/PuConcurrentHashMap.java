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

}
