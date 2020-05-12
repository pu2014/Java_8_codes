package com.pu.jdk;

import java.util.HashMap;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/12 15:41
 */
public class HowHashMapResize {

     static final int TREEIFY_THRESHOLD = 8;

     /**
     * The bin count threshold for untreeifying a (split) bin during a
     * resize operation. Should be less than TREEIFY_THRESHOLD, and at
     * most 6 to mesh with shrinkage detection under removal.
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     */
    static final int MIN_TREEIFY_CAPACITY = 64;
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(20);

        /**
         * 注意：
         *  1.链表长度大于8 的时候就会调用 treeifyBin方法转化为红黑树，但是在treeifyBin方法内部却有一个判断，
         *  当只有数组长度大于64的时候，才会进行树形化，否则就只是resize扩容。
         *  2.因为链表过长而数组过短，会经常发生 hash碰撞，这个时候树形化其实是治标不治本，因为引起链表过长的根
         *  本原因是数组过短。所以执行树形化之前，会先检查数组长度，如果长度小于 64，则对数组进行扩容，而不是进行树形化。
         *  3.因此，真正发生树形化的时候，是数组长度大于64并且链表长度大于8 的时候才会发生的。
         */

        /**
         * resize 函数：
         *  数组null 为空：创建新的数组
         *  数组不为空，容量和阈值*2（容量*负载因子），创建一个二倍的数组。然后把原有的数组都转移到新数组中
         *  扩容后的 数组大小即为 2 的 N+1 次方，则其中元素的 数组索引为其 hash 值的后 N+1 位确定，比原来多了一位。
         *  转移数据不在跟1.7一样重新计算hash值（计算hash值耗时巨大），只需要看索引中新增的是bit位是1还是0
         */
    }
}
