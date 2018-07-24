package com.chenwenzhuo;

class BusForRenting extends CarsForRenting {
    protected int guestCapacity;

    public BusForRenting(String name, int price, int guestCapacity) {
        super(name, price);
        this.guestCapacity = guestCapacity;
    }

    public int getGuestCapacity() {
        return guestCapacity;
    }
}
