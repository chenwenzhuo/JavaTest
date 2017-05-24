package com.ventrol_chen.Exercise02;

/**
 * Created by --C-W-Z-- on 2017/2/18 0018.
 */
public class Main_ex02 {
    public static void main(String[] args) {
        /*Runnable fib = new Fibonacci(30);
        Thread myFibonacci = new Thread(fib);
        myFibonacci.start();*/
        for (int i = 0; i < 10; i++) {
            int length = (int) (Math.random() * 20) + 1;
            Runnable fibonacci = new Fibonacci(length);
            new Thread(fibonacci).start();
        }
    }
}
