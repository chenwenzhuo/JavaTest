package com.ventrol_chen.BasicPage04;

/**
 * Created by --C-W-Z-- on 2017/2/22 0022.
 */
public class SynchronizedTest_2 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}
class MyThread extends Thread {

    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName() + " loop " + i);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}