package com.ventrol_chen.BasicPage08;

/**
 * Created by --C-W-Z-- on 2017/2/24 0024.
 */
public class JoinTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start!");
        Thread father = new FatherThread();
        father.setName("father");
        father.start();
        try {
            father.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end!");
    }
}

class FatherThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " start!");
        Thread son = new SonThread();
        son.setName("son");
        son.start();
        try {
            son.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " end!");
    }
}

class SonThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + " start!");
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " end!");
    }
}
