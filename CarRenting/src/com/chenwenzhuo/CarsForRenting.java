package com.chenwenzhuo;

class CarsForRenting {
    protected String name;
    protected int price;

    public CarsForRenting(String name, int price) {
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
