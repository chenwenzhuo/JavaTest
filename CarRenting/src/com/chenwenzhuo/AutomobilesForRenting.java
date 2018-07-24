package com.chenwenzhuo;

class AutomobilesForRenting {
    protected String name;
    protected int price;

    public AutomobilesForRenting(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
