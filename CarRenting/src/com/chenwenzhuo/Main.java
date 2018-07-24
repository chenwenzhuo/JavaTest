package com.chenwenzhuo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//定义一个Scanner用于输入

        //让用户确认是否需要租车
        System.out.println("Are you willing to rent cars?");
        System.out.println("Enter 1 for yes or 0 for no.");
        int quitOrNot;
        quitOrNot = input.nextInt();
        if (0 == quitOrNot) {
            return;
        }

        //实例化所有车型
        AutomobilesForRenting[] automobilesForRentings = {
                new PassengerCarOrBus("Audi", 500, 5),
                new PassengerCarOrBus("Benz", 800, 5),
                new PassengerCarOrBus("GoldenDragon", 1000, 30),
                new PassengerCarOrBus("GoldenDragon_1", 1200, 50),
                new Trunk("Trunk_1", 1500, 5),
                new Trunk("Trunk_2", 2000, 8),
                new Pickup("GreatWall_1", 500, 4, 1),
                new Pickup("GreatWall_2", 700, 4, 2)
        };

        //输出所有车型，价格，载客量及载货量
        System.out.println("We have following autos for renting:");
        for (int i = 0; i < automobilesForRentings.length; i++) {
            System.out.print(
                    (i + 1) + ".  "
                            + automobilesForRentings[i].getName() + ","
                            + "Price:" + automobilesForRentings[i].getPrice() + ",");

            if (automobilesForRentings[i] instanceof PassengerCarOrBus) {
                PassengerCarOrBus passenger = (PassengerCarOrBus) automobilesForRentings[i];
                System.out.println("Passenger capacity:" + passenger.getGuestCapacity());
            } else if (automobilesForRentings[i] instanceof Trunk) {
                Trunk trunk = (Trunk) automobilesForRentings[i];
                System.out.println("Goods capacity:" + trunk.getGoodsCapacity());
            } else if (automobilesForRentings[i] instanceof Pickup) {
                Pickup pickup = (Pickup) automobilesForRentings[i];
                System.out.println(
                        "Passenger capacity:" + pickup.getGuestCapacity() + ","
                                + "Goods capacity:" + pickup.getGoodsCapacity());
            }
        }

        //统计总价格
        System.out.println();
        System.out.println("How many cars do you want?");
        int howManyToRent = input.nextInt();
        int totalPrice = 0;
        for (int i = 0; i < howManyToRent; i++) {
            System.out.print("Enter the number of the " + (i + 1) + " car you want:");

            int number = input.nextInt();
            while (number < 1 || number > automobilesForRentings.length) {
                System.out.print("Wrong number!Please enter a number between 1 and "
                        + automobilesForRentings.length + ":");
                number = input.nextInt();
            }

            totalPrice += automobilesForRentings[number - 1].getPrice();
        }
        System.out.println("Total price:" + totalPrice);
    }
}
