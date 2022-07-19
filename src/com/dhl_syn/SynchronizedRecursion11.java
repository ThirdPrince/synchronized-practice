package com.dhl_syn;

import sun.jvm.hotspot.debugger.ThreadAccess;

/**
 * 证明 synchronized 可重入的
 */
public class SynchronizedRecursion11 implements Runnable{


    public  static SynchronizedRecursion11 instance = new SynchronizedRecursion11();
    private  synchronized void method1() {
        System.out.println("我是 method1  : "+ Thread.currentThread().getName());
        method2();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private  synchronized void method2() {
        System.out.println("我是 method2 我叫："+Thread.currentThread().getName());


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
