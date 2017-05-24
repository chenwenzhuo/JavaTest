package com.ventrol_chen.BasicPage05;

/**
 * Created by --C-W-Z-- on 2017/2/22 0022.
 */
public class WainTest {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");

        synchronized (t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                t1.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {

    MyThread(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify()");
            // 唤醒当前的wait线程
            notify();
        }
    }
}