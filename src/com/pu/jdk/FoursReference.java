package com.pu.jdk;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @DESC
 *  Reference对象的生命周期
 *      对象创建-JVM(GC时发现ref对象-需要回收就发送到DiscoveredList-将DiscoverList 元素移动到PendingList)
 *      -ReferenceHandler线程将pendingList的ref加入到ReferenceQueue中-从ReferenceQueue中被移除。
 *
 *      SoftReference:要发生oom之前，对其回收。 多用于缓存
 *      WeakReference：下次回收会被回收
 *      PhantomReference：无法通过虚引用来取得一个对象的实例
 *
 * @CREATE BY @Author pbj on @Date 2020/5/12 11:16
 */
public class FoursReference {
    public static void main(String[] args) {
        //strong Reference
        Object obj = new Object();
        Reference<Object> ref = null;
        SoftReference<Object> softRef = null;
        WeakReference<Object> weakRef = null;
        PhantomReference<Object> phantomRef = null;
        //soft Reference
        //weak Reference
        //Phantom Reference
    }
}
