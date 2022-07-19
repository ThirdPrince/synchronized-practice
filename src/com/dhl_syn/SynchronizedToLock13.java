package com.dhl_syn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  synchronized  能保证可见性
 *  用 lock 形式表现
 *  synchronized 效率低 锁的释放情况少，试图获得锁时不能设定超时，不能中断一个正在试图获得锁的线程。
 *  synchronized 不能中断。
 *  synchronized 不够灵活。
 *  无法知道是否成功了获取了锁。
 *  优先使用 synchronized 其次在使用lock
 */
public class SynchronizedToLock13 implements Runnable{

    Lock lock = new ReentrantLock();

    public  static SynchronizedToLock13 instance = new SynchronizedToLock13();
    private  synchronized void method1() {
        System.out.println("我是 synchronized  : "+ Thread.currentThread().getName());


    }
    private   void method2() {
        lock.lock();
        try{
            System.out.println("我是 lock 我叫："+Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }



    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().endsWith("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("main finish");
    }
}
