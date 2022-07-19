package com.dhl_syn;

import com.sun.codemodel.internal.JMethod;

/**
 * 对象锁示例  方法锁
 */
public class SynchronizedObjectMethod3 implements Runnable{

    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();
    @Override
    public void run() {

        method();
    }

    private synchronized void method() {
        System.out.println("我是 method 对象锁的代码块的形式。我叫："+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        System.out.println("main");
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("main finish");
    }
}
