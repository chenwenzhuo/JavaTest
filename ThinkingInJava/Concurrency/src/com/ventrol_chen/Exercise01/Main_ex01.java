package com.ventrol_chen.Exercise01;

public class Main_ex01 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(
                    new MyRunnable())
                    .start();
        }
    }
}
