package com.heythere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AttackDotComGame {
    private DotCom[] dotComs = new DotCom[3];

    public AttackDotComGame() {
        Coordinate[] coordinates = new Coordinate[3];//用于初始化DotCom的Coordinate
        for (int i = 0; i < 3; i++) {
            coordinates[i] = new Coordinate();
        }

        int count = 0;//已初始化的DotCom的数目
        //初始化三个DotCom
        while (count < 3) {
            coordinates[0].setCoordinates('B', '0');
            coordinates[1].setCoordinates('C', '0');
            coordinates[2].setCoordinates('D', '0');
            dotComs[count] = new DotCom(coordinates[0], coordinates[1], coordinates[2], "Go2.com");
            if (!dotComs[count].isAllInitialized()) {
                continue;
            } else {
                count++;
            }

            coordinates[0].setCoordinates('D', '2');
            coordinates[1].setCoordinates('D', '3');
            coordinates[2].setCoordinates('D', '4');
            dotComs[count] = new DotCom(coordinates[0], coordinates[1], coordinates[2], "Pets.com");
            if (!dotComs[count].isAllInitialized()) {
                continue;
            } else {
                count++;
            }

            coordinates[0].setCoordinates('G', '3');
            coordinates[1].setCoordinates('G', '4');
            coordinates[2].setCoordinates('G', '5');
            dotComs[count] = new DotCom(coordinates[0], coordinates[1], coordinates[2], "AskMe.com");
            if (!dotComs[count].isAllInitialized()) {
                continue;
            } else {
                count++;
            }
        }
    }

    public void startGame() {
        int sunkDotComCount = 0;//已被击沉的DotCom数量

        String guessInput = "";
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        while (sunkDotComCount < dotComs.length) {
            System.out.println("Enter a guess:");
            try {
                guessInput = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException occurred!");
            }

            if (dotComs[0].isDotComHit(guessInput)
                    || dotComs[1].isDotComHit(guessInput)
                    || dotComs[2].isDotComHit(guessInput)) {
                if (dotComs[0].isDotComHit(guessInput) && (3 == dotComs[0].getDotComHitCount())) {
                    System.out.println("Ouch!You sunk " + dotComs[0].getDotComName());
                    sunkDotComCount++;
                } else if (dotComs[1].isDotComHit(guessInput) && (3 == dotComs[1].getDotComHitCount())) {
                    System.out.println("Ouch!You sunk " + dotComs[1].getDotComName());
                    sunkDotComCount++;
                } else if (dotComs[2].isDotComHit(guessInput) && (3 == dotComs[2].getDotComHitCount())) {
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
