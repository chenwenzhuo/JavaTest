package com.ventrol_chen.BasicPage10;

/**
 * Created by --C-W-Z-- on 2017/2/27 0027.
 */
public class ThreadPriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()
                + "(" + Thread.currentThread().getPriority() + ")");

        Thread t1 = new PriorityThread("t1");    // 新建t1
        Thread t2 = new PriorityThread("t2");    // 新建t2
        t1.setPriority(1);                // 设置t1的优先级为1
        t2.setPriority(10);                // 设置t2的优先级为10
        t1.start();                        // 启动t1
        t2.start();
    }
}

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + "(" + Thread.currentThread().getPriority() + ")"
                    + ", loop " + i);
        }
    }
}