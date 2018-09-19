package com.heythere;

public class Main {

    public static void main(String[] args) {
        RandomString_Gen_Sort randString = new RandomString_Gen_Sort();
        randString.generateRandomString();
        System.out.println("----------排序前----------");
        randString.showRandomStrings();

        randString.sortRandomString();
        System.out.println("----------排序后----------");
        randString.showRandomStrings();
    }
}
