package com.heythere.Player;

import com.heythere.Poker.Poker;

import java.util.*;

public class Player {
    private int playerID;//玩家ID
    private String playerName;//玩家姓名
    private List<Poker> pokersInHand;//玩家手牌
    private Scanner consoleInput;//Scanner用于从控制台输入数据

    public Player() {
        this.consoleInput = new Scanner(System.in);
        //输入玩家ID和姓名
        this.playerID = enterIDFromConsole();
        System.out.println("输入玩家姓名：");
        this.playerName = consoleInput.next();
        //初始化手牌List
        pokersInHand = new ArrayList<>();
    }

    private int enterIDFromConsole() {
        System.out.println("输入玩家ID：");
        int id;

        /*
        从控制台读入玩家id，
        若读入的不是数字则抛出异常，输出提示信息并重新输入
        直到读入正确数据，跳出循环
         */
        while (true) {
            try {
                id = consoleInput.nextInt();
            } catch (InputMismatchException mismatch) {
                System.out.println("玩家ID必须为整数！");
                System.out.println("重新输入玩家ID:");
                consoleInput.nextLine();
                continue;
            }
            break;
        }
        return id;
    }

    public void playerGetPoker(Poker poker) {
        pokersInHand.add(poker);
    }

    public Poker biggestPokerInHand() {
        Poker biggestPoker = null;
        for (Poker nextPoker : pokersInHand) {
            if (null == biggestPoker || nextPoker.compareTo(biggestPoker) > 0) {
                biggestPoker = nextPoker;
            }
        }
        return biggestPoker;
    }

    public void showPokersInHand() {
        for (Poker p : pokersInHand) {
            System.out.println(p.getPokerSuit() + "：" + p.getPokerPointAsStr());
        }
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Poker> getPokersInHand() {
        return pokersInHand;
    }
}
