package com.ventrol_chen;

/**
 * Created by --C-W-Z-- on 2017/3/1 0001.
 */
public class Lan_Tian_Xiang {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            }
        };
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
            /*try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("skd");
        System.out.println(race);
    }
}
