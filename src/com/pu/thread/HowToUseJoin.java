package com.pu.thread;

/**
 * join() and (wait() notify() notifyAll()) : Inter-thread synchronization mechanism;
 * des: When we call the *join()* method on a thread, the calling thread goes into a waiting state.
 *  It remains in a waiting state until the referenced thread is terminated
 */
public class HowToUseJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new SampleJoinThread(3);
        t2.start();
        System.out.println("Invoking join");
        t2.join();
        System.out.println("Returned from join");
        System.out.println(t2.isAlive());
    }

}
class SampleJoinThread extends Thread {

    public int processingCount;

    SampleJoinThread(int processingCount) {
        this.processingCount = processingCount;
        System.out.println("Thread created!");
    }


    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
        }

        System.out.println("Thread " + this.getName() + " exiting");
    }
}