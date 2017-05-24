package com.ventrol_chen.BasicPage04;

/**
 * Created by --C-W-Z-- on 2017/2/22 0022.
 */
public class SynchronizedTest_1 {
    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();     // 新建“Runnable对象”

        Thread t1 = new Thread(myRunnable, "t1");  // 新建“线程t1”, t1是基于demo这个Runnable对象
        Thread t2 = new Thread(myRunnable, "t2");  // 新建“线程t2”, t2是基于demo这个Runnable对象
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
}

class MyRunnable implements Runnable {

    @Override
    public synchronized void run() {
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
