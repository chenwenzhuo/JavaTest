package com.ventrol_chen.BasicPage05;

/**
 * Created by --C-W-Z-- on 2017/2/22 0022.
 */
public class NotifyAllTest {
    private static Object object = new Object();

    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName() + " sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " notifyAll");
            object.notifyAll();
        }
    }

    static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");
                    object.wait();
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
