package com.heythere;

class GuessGame {
    protected Player player_1;
    protected Player player_2;
    protected Player player_3;

    public GuessGame() {
        player_1 = new Player();
        player_2 = new Player();
        player_3 = new Player();
    }

    public void startGame() {
        int targetNumber = (int) (Math.random() * 10);//随机产生一个0~10的数字
        //三玩家所猜测的数字
        int num_1 = player_1.guessANumber();
        int num_2 = player_2.guessANumber();
        int num_3 = player_3.guessANumber();

        boolean rightOrNot = false;//标志是否有人猜对
        if (targetNumber == num_1) {
            System.out.println("Player_1 is right!");
            rightOrNot = true;
        }
        if (targetNumber == num_2) {
            System.out.println("Player_2 is right!");
            rightOrNot = true;
        }
        if (targetNumber == num_3) {
            System.out.println("Player_3 is right!");
            rightOrNot = true;
        }
        if (!rightOrNot) {
            System.out.println("No one is right!");
        }
        System.out.println("Player_1's number is " + num_1 + ".");
        System.out.println("Player_2's number is " + num_2 + ".");
        System.out.println("Player_3's number is " + num_3 + ".");
        System.out.println("Target number is " + targetNumber);

    }
}
