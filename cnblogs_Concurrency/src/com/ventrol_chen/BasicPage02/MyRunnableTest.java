package com.ventrol_chen.BasicPage02;

/**
 * Created by --C-W-Z-- on 2017/2/21 0021.
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        MyRunnable mRunnable = new MyRunnable();
        Thread thread_1 = new Thread(mRunnable);
        Thread thread_2 = new Thread(mRunnable);
        Thread thread_3 = new Thread(mRunnable);
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}

class MyRunnable implements Runnable {
    private volatile int tickets = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.tickets > 0) {
                System.out.println(Thread.currentThread().getName()
                        + " 卖票：ticket" + this.tickets--);
            }
        }
    }
}
