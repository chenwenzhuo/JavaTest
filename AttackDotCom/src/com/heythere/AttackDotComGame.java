package com.heythere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AttackDotComGame {
    private DotCom[] dotComs = new DotCom[3];

    public AttackDotComGame() {
        //用于初始化DotCom的Coordinate
        //由于有三个DotCom，必须使用三组Coordinate
        Coordinate[] coordinates_1 = new Coordinate[3];
        Coordinate[] coordinates_2 = new Coordinate[3];
        Coordinate[] coordinates_3 = new Coordinate[3];
        for (int i = 0; i < 3; i++) {
            coordinates_1[i] = new Coordinate();
            coordinates_2[i] = new Coordinate();
            coordinates_3[i] = new Coordinate();
        }

        //初始化三个DotCom
        coordinates_1[0].setCoordinates('B', '0');
        coordinates_1[1].setCoordinates('C', '0');
        coordinates_1[2].setCoordinates('D', '0');
        dotComs[0] = new DotCom(coordinates_1[0], coordinates_1[1], coordinates_1[2], "Go2.com");

        coordinates_2[0].setCoordinates('D', '2');
        coordinates_2[1].setCoordinates('D', '3');
        coordinates_2[2].setCoordinates('D', '4');
        dotComs[1] = new DotCom(coordinates_2[0], coordinates_2[1], coordinates_2[2], "Pets.com");

        coordinates_3[0].setCoordinates('G', '3');
        coordinates_3[1].setCoordinates('G', '4');
        coordinates_3[2].setCoordinates('G', '5');
        dotComs[2] = new DotCom(coordinates_3[0], coordinates_3[1], coordinates_3[2], "AskMe.com");

        System.out.println("DotComs:");
        System.out.println(dotComs[0].toString());
        System.out.println(dotComs[1].toString());
        System.out.println(dotComs[2].toString());
    }

    public void startGame() {
        int sunkDotComCount = 0;//已被击沉的DotCom数量

        //用于输入的一些对象
        String guessInput = "";
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //标志DotCom是否被击中
        boolean is_DotCom0_hit;
        boolean is_DotCom1_hit;
        boolean is_DotCom2_hit;

        while (sunkDotComCount < dotComs.length) {
            System.out.println("Enter a guess:");
            try {
                guessInput = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException occurred!");
            }

            is_DotCom0_hit = dotComs[0].isDotComHit(guessInput);
            is_DotCom1_hit = dotComs[1].isDotComHit(guessInput);
            is_DotCom2_hit = dotComs[2].isDotComHit(guessInput);
            if (is_DotCom0_hit || is_DotCom1_hit || is_DotCom2_hit) {
                if (is_DotCom0_hit && (3 == dotComs[0].getDotComHitCount())) {
                    System.out.println("Ouch!You sunk " + dotComs[0].getDotComName());
                    sunkDotComCount++;
                } else if (is_DotCom1_hit && (3 == dotComs[1].getDotComHitCount())) {
                    System.out.println("Ouch!You sunk " + dotComs[1].getDotComName());
                    sunkDotComCount++;
                } else if (is_DotCom2_hit && (3 == dotComs[2].getDotComHitCount())) {
                    System.out.println("Ouch!You sunk " + dotComs[2].getDotComName());
                    sunkDotComCount++;
                } else {
                    System.out.println("Hit");
                }
            } else {
                System.out.println("Miss");
            }
        }
        System.out.println("You have sunk all DotComs!Game is over");
    }
}
