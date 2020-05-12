package com.pu.jvm;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/12 15:09
 */
public class HotSpot {
    /**
     * default： Eden : Survivor = 8 : 1
     *      Eden : From - To : Old
     *      (8/10)      (1/10) (1/10)
     *      young          old
     *      （1/3）        （2/3）
     *
     * -Xmx3550m -最大可用内存；
     * -Xms3550m -JVM促使内存为3550m；
     * -Xmn2g 年轻代大小为2G；
     * -Xss128k -设置每个线程的堆栈大小；
     * -XX:NewRatio=4:设置年轻代（包括Eden和两个Survivor区）与年老代的比值（除去持久代）设置为4，则年轻代与年老代所占比值为1：4；
     * -XX:SurvivorRatio=4：设置年轻代中Eden区与Survivor区的大小比值。设置为4，则两个Survivor区与一个Eden区的比值为2:4；
     * -XX:MaxPermSize=16m:设置持久代大小为16m；
     * -XX:MaxTenuringThreshold=0：设置垃圾最大年龄；
     *
     * CMS:
     *  初始标记：GC Roots能直接到的对象，速度很快但是存在STW
     *  并发标记：GC roots Tracing 过程， 找到存活对象且用户线程可并发执行
     *  重新标记：为了修正并发标记期间因用户程序继续运行而导致标记变动的那一部分对象进行标记STW
     *  并发清除：对标记的对象进行清除回收
     *
     *  缺点：
     *      对cpu 资源敏感
     *      无法处理浮动垃圾
     *      标记-清除 算法产生大量空间碎片
     *
     * G1：
     *  初始标记：CMS 一致
     *  并发标记：CMS 一致
     *  最终回收：CMS 一致
     *  筛选回收：对Region 的回收价值和成本排序，根据用户所期望的GC停顿时间来制定回收计划。（维护一个优先级列表）
     *
     *  JDK8 默认的是 parallel Scavenge + parallel old
     */
}
