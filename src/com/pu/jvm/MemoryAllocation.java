package com.pu.jvm;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/12 11:48
 */
public class MemoryAllocation {
    /**
     * Two method：
     * 1：指针碰撞 ->用过的放一边，没有用过的放另一边，中间一个分界指针
     * 2：空闲列表 ->列表记录那些内存可以使用
     *
     * Concurrent allocation：
     * CAS + 失败重试： CAS 乐观锁的实现方式（实现更新操作的原子性）
     * TLAB： Thraed Loacl Alloction Buffer ：为每一个线程预先在Eden区分配一块内存，JVM首先在TLAB中分配
     * 首先在TLAB中分配，当对象大于其内存时才有CAS进行分配
     */
}
