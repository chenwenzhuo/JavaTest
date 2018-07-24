package com.chenwenzhuo;

class PickupForRenting extends CarsForRenting {
    protected int guestCapacity;
    protected int goodsCapacity;

    public PickupForRenting(String name, int price, int guestCapacity, int goodsCapacity) {
        super(name, price);
        this.guestCapacity = guestCapacity;
        this.goodsCapacity = guestCapacity;
    }

    public int getGoodsCapacity() {
        return goodsCapacity;
    }

    public int getGuestCapacity() {

        return guestCapacity;
    }
}
