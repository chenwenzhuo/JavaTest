package com.ventrol_chen.BasicPage09;

/**
 * Created by --C-W-Z-- on 2017/2/24 0024.
 */
public class InterruptBlockedThread {
    public static void main(String[] args) {
        ThreadToBeBlocked threadToBeBlocked = new ThreadToBeBlocked("threadToBeBlocked");
        threadToBeBlocked.start();
        threadToBeBlocked.interrupt();
    }
}

class ThreadToBeBlocked extends Thread {
    ThreadToBeBlocked(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + "(" + getState() + ")");
            sleep(10000);
            System.out.println(getName() + "(" + getState() + ")");
        } catch (InterruptedException e) {
            System.out.println(getName() + "(" + getState() + ")");
            System.out.println("InterruptedException caught in" + Thread.currentThread().getName());
            System.out.println(getName() + "(" + getState() + ")");
        }
    }
}
