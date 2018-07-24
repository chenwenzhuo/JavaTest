package com.chenwenzhuo;

class PassengerCarOrBus extends AutomobilesForRenting {
    protected int guestCapacity;

    public PassengerCarOrBus(String name, int price, int guestCapacity) {
        super(name, price);
        this.guestCapacity = guestCapacity;
    }

    public int getGuestCapacity() {
        return guestCapacity;
    }
}
