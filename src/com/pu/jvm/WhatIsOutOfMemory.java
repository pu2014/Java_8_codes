package com.pu.jvm;

/**
 * @DESC OOM：某些对象不再被应用程序所使用，但是由于引用仍然被使用，导致被该被回收的对象不能被回收而停留在堆内存中，产生内存泄漏。
 * @CREATE BY @Author pbj on @Date 2020/5/12 12:06
 */
public class WhatIsOutOfMemory{
    public static void main(String[] args) {

        /**
         * 场景：
         *  长生命周期对象持有短生命周期对象的引用
         *  修改对象的地址（Hashset的hash值）从而无法找到该对象
         *  机器的持久连接
         *
         * 实例：ThreadLocal 内部实现时基于 ThreadLocalMap
         *  每个Thread维护一个ThreadLocalMap映射表，这个映射表的key是ThreadLocal实例本身。value存放的是真正的Object
         *  key 为弱引用 value， 下次就会被回收 为强引用 需要调用remove()
         *
         *  避免：
         *   尽早释放无用的对象
         *   使用StringBuffer 代替String
         *   少用静态变量，静态变量存放在永久代，基本不参与垃圾回收
         *   避免在循环中创建对象
         */

    }
}
