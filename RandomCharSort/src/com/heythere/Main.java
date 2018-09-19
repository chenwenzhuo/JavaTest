package com.heythere;

import java.util.Random;

public class Main {
    private Random random;

    public Main() {
        this.random = new Random();
    }

    public void getRandomChars(char[] chars) {
        byte[] bytes = new byte[chars.length];
        random.nextBytes(bytes);

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) bytes[i];
        }

        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }
    public static void main(String[] args) {
        Main m = new Main();

        char[] someChars = new char[5];
        m.getRandomChars(someChars);
    }
}
