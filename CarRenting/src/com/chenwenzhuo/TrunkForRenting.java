package com.chenwenzhuo;

class TrunkForRenting extends CarsForRenting {
    protected int goodsCapacity;

    public TrunkForRenting(String name, int price, int goodsCapacity) {
        super(name, price);
        this.goodsCapacity = goodsCapacity;
    }

    public int getGoodsCapacity() {
        return goodsCapacity;
    }
}
