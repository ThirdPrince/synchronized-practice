package com.dhl_syn;

/**
 * 类锁
 */
public class SynchronizedClass5 implements Runnable{




    private   void method(){
        synchronized (SynchronizedClass5.class){
            System.out.println("我是 method 类锁 我叫："+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行结束");
        }

    }

    @Override
    public void run() {
        method();
    }
    public static void main(String[] args) {
        SynchronizedClass5 instance1 = new SynchronizedClass5();
        SynchronizedClass5 instance2 = new SynchronizedClass5();
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("main finish");

    }

}
