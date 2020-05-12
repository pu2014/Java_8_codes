package com.pu.jvm;

/**
 * @DESC
 *  GC:
 *  1：引用计数
 *  2：可达性算法
 *  GC roots: 虚拟机栈中引用的对象
 *            全局静态对象， static关键字
 *            常量引用， static final
 *            本地方法栈引用的对象
 * @CREATE BY @Author pbj on @Date 2020/5/12 11:38
 */
public class GCRoots {
    public static void main(String[] args) {
        //two times mark
        /**
         * first mark：如果对象没有覆盖finalize() 方法，或者finalize()方法已经被jvm执行过，则判定可回收对象
         *          如果对象有必要执行finalize()方法，则被放入F-Queue队列中， 稍后会自动建立一个低优先度的线程中触发方法
         * second mark：GC 对 F-Queue 队列中的对象进行二次标记。如果对象在 finalize () 方法中重新与引用链上的任何一个对
         * 象建立了关联，那么二次标记时则会将它移出 “即将回收” 集合。如果此时对象还没成功逃脱，那么只能被回收了。
         */
    }
}
