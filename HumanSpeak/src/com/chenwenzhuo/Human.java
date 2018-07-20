package com.chenwenzhuo;

class Human {
    protected void speak(){
        if(this instanceof ChinesePeople) {
            System.out.println("人类有说话的能力");
        }else if(this instanceof AmericanPeople){
            System.out.println("Human can speak");
        }
    }
}
