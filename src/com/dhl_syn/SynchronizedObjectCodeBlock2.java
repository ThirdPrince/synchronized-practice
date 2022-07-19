package com.dhl_syn;

/**
 * synchronized 作用：能够保证在同一时刻最多只有一个线程执行该段代码，以保证并发安全的效果。
 * synchronized 可重入
 *
 */
public class SynchronizedObjectCodeBlock2  implements Runnable{
    private static SynchronizedObjectCodeBlock2 instance1 = new SynchronizedObjectCodeBlock2();
    private static SynchronizedObjectCodeBlock2 instance2 = new SynchronizedObjectCodeBlock2();
    Object lock1 = new Object();
    Object lock2 = new Object();
    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("我是lock1对象锁的代码块的形式。我叫："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread().getName()+"运行结束");
        }
        synchronized (lock2){
            System.out.println("我是lock2对象锁的代码块的形式。我叫："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }


    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive() ){

        }
        System.out.println("main finished");
    }
}
