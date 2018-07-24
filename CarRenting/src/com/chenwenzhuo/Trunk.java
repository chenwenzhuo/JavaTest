package com.chenwenzhuo;

class Trunk extends AutomobilesForRenting {
    protected int goodsCapacity;

    public Trunk(String name, int price, int goodsCapacity) {
        super(name, price);
        this.goodsCapacity = goodsCapacity;
    }

    public int getGoodsCapacity() {
        return goodsCapacity;
    }
}
