package com.pu.thread.concurrent_vector;

/**
 * @DESC  CopyOnWriteArrayList --> list
 *          CopyOnWriteArraySet --> set
 *
 *        copy-on-write: 只要正确发布一个对象，那么在访问对象时就不需要再进一步的同步。在每次修改时，都会创建并重新发布一个新的容器版本，从而实现可变性
 *  场景： 1.商品详情页：信息被 read 的时候多， write 的时候少不会fast-fail
 *         2. 监听机制
 * @CREATE BY @Author pbj on @Date 2020/7/13 17:32
 */
public class CopyOnWriteArrayListTest {
}
