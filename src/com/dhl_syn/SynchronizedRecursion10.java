package com.dhl_syn;

/**
 * 证明 synchronized 可重入的
 */
public class SynchronizedRecursion10 implements Runnable{


    public  static SynchronizedRecursion10 instance = new SynchronizedRecursion10();
    int a = 0;
    private  synchronized void method1() {
        System.out.println("我是 method1  a = "+a);
        if(a == 0){
            a++;
            method1();
        }

    }
    private  synchronized void method2() {
        System.out.println("我是 method2 的形式。我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
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
