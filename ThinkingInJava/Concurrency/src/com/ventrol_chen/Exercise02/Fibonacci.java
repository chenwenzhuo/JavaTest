package com.ventrol_chen.Exercise02;

/**
 * Created by --C-W-Z-- on 2017/2/18 0018.
 */
public class Fibonacci implements Runnable {
    private int length;

    Fibonacci(int length) {
        this.length = length;
    }

    @Override
    public void run() {
        if (length <= 0) {
            return;
        }
        int[] fibInts = new int[length];
        fillFibInts(fibInts);
        for (int i = 0; i < length; i++) {
            System.out.print(fibInts[i] + "  ");
        }
        System.out.println();
    }

    private void fillFibInts(int[] fibInts) {
        if (length >= 1) {
            fibInts[0] = 1;
        }
        if (length >= 2) {
            fibInts[1] = 1;
        }
        if (length >= 3) {
            for (int i = 2; i < length; i++) {
                fibInts[i] = fibInts[i - 1] + fibInts[i - 2];
            }
        }
    }
}
