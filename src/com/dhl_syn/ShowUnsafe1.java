package com.dhl_syn;

/**
 *
 * i++ 虽然是一行代码，但是实际上至少包含了一下三个动作
 * 1，读取 i的值
 * 2，计算 i 的值
 * 3，把 i+1 的计算结果写回到内存中
 */
public class ShowUnsafe1 implements Runnable {
    static ShowUnsafe1 r = new ShowUnsafe1();
    static int i = 0;

    @Override
    public void run() {

        while (i < 1000000){
            i++;
           // System.out.println("i="+i);
        }
//        for (int j = 0; j < 100000; j++) {
//            i++;
//        }

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main i =" + i);

    }
}
