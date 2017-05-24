package com.ventrol_chen.Exercise01;

/**
 * Created by --C-W-Z-- on 2017/2/18 0018.
 */
public class MyRunnable implements Runnable{
    private static int count = 0;
    private final int runnable_ID = (++count);

    MyRunnable() {
        System.out.println("Running starts! ID is :" + runnable_ID);
    }
    @Override
    public void run() {
        System.out.println(runnable_ID + " is running [1]");
        Thread.yield();
        System.out.println(runnable_ID + " is running [2]");
        Thread.yield();
        System.out.println(runnable_ID + " is running [3]");
        Thread.yield();
        System.out.println(runnable_ID + " ends running");
    }
}
