package com.heythere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AttackDotComGame {
    DotCom[] dotComs = new DotCom[3];

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
        int sunkDotComs=0;//已被击沉的DotCom数量

        String guessInput = "";
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        while (sunkDotComs < dotComs.length) {
            System.out.println("Enter a guess:");
            try {
                guessInput=reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException occurred!");
            }
        }
    }
}
