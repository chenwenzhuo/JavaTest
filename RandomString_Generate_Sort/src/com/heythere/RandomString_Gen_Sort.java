package com.heythere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomString_Gen_Sort {
    private List<String> stringList;
    private Random random;

    public RandomString_Gen_Sort() {
        stringList = new ArrayList<>();
        this.random = new Random();
    }

    public void generateRandomString() {
        int count=0;//计数器，表示当前已生成的字符串数
        while (count < 10) {
            //随机生成字符串长度，调用方法生成随机字符串
            int strLen = random.nextInt(20) + 1;//加一避免长度为0
            String aString = getRandomString(strLen);

            //若List中已包含生成的字符串，则重新生成
            if (stringList.contains(aString)) {
                continue;
            }
            stringList.add(aString);
            count++;
        }
    }

    private String getRandomString(int length) {
        String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int allCharsLen = allChars.length();
        StringBuilder strBuilder = new StringBuilder();//生成过程中暂存字符串

        int posOfChar;
        for (int i = 0; i < length; i++) {
            posOfChar = random.nextInt(allCharsLen);
            strBuilder.append(allChars.charAt(posOfChar));
        }
        return strBuilder.toString();
    }

    public void showRandomStrings() {
        for (String str : stringList) {
            System.out.println(str);
        }
    }

    public void sortRandomString() {
        Collections.sort(stringList);
    }
}
