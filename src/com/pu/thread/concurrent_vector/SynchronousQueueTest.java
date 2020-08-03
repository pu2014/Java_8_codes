package com.pu.thread.concurrent_vector;

/**
 * @DESC SynchronousQueue是一种极为特殊的阻塞队列，它没有实际的容量，任意线程（生产者线程或者消费者线程，
 * 生产类型的操作比如put，offer，消费类型的操作比如poll，take）都会等待知道获得数据或者交付完成数据才会返回，
 * 一个生产者线程的使命是将线程附着着的数据交付给一个消费者线程，而一个消费者线程则是等待一个生产者线程的数据。
 * 它们会在匹配到互斥线程的时候就会做数据交易，比如生产者线程遇到消费者线程时，或者消费者线程遇到生产者线程时，
 * 一个生产者线程就会将数据交付给消费者线程，然后共同退出。在java线程池newCachedThreadPool中就使用了这种阻塞队列。
 *
 *
 * SynchronousQueue有两个版本的Transferer实现，一种为公平交易类型，一种为非公平交易类型，公平交易类型的实现类为
 * TransferQueue，它使用队列来作为交易媒介，请求交易的线程总是先尝试跟队列头部（或者尾部）的线程进行交易，如果失败
 * 再将请求的线程添加到队列尾部，而非公平类型的实现类为TransferStack，它使用一个stack来作为交易媒介，请求交易的线
 * 程总是试图与栈顶线程进行交易，失败则添加到栈顶。所以SynchronousQueue就是使用队列和栈两种数据结构来模拟公平交易
 * 和非公平交易的。下面分别对两种交易类型进行分析。
 *
 * @CREATE BY @Author pbj on @Date 2020/8/3 11:23
 */
public class SynchronousQueueTest {
    /**
     * 对于非常大的或者无界的线程池，可以通过使用SynchronousQueue避免任务排队。以及直接将任务从生产者交给消费者。
     * 它不是真正的队列，而是一种在线程之间进行移交的机制。
     *
     * 对于Excutor, newCachedThreadPool提供比固定线程池更好的排队性能。
     * 当需要限制当前任务的数量以及满足资源管理需求时。那么可以选择固定大小的线程池。防止过载。
     */
}