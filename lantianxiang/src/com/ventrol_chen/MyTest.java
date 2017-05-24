package com.ventrol_chen;

public class MyTest {
    private Object object = new Object();
    private static volatile int race = 0;

    static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new MyThread();
            threads[i].start();
            /*try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println(race);
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            MyTest.increase();
        }
    }
}