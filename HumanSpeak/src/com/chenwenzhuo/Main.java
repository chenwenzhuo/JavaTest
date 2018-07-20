package com.chenwenzhuo;

class Main {

    public static void main(String[] args) {
        Human cn = new ChinesePeople();
        Human us = new AmericanPeople();

        cn.speak();
        us.speak();
    }
}
