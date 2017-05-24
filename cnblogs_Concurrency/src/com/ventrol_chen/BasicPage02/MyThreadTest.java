package com.ventrol_chen.BasicPage02;

/**
 * Created by --C-W-Z-- on 2017/2/21 0021.
 */
public class MyThreadTest {
    public static void main(String[] args) {
        Thread mThread_1 = new MyThread();
        Thread mThread_2 = new MyThread();
        Thread mThread_3 = new MyThread();
        mThread_1.start();
        mThread_2.start();
        mThread_3.start();
    }
}

class MyThread extends Thread {
    private int tickets = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " 卖票：ticket" + tickets);
            tickets--;
        }
    }
}
