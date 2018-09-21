package com.heythere.Game;

import com.heythere.Player.Player;
import com.heythere.Poker.Poker;
import com.heythere.Poker.PokerPack;

public class PokerGame {
    //牌堆
    private PokerPack pokerPack;
    //玩家
    private Player player_1, player_2;

    public PokerGame() {
        //初始化对象
        pokerPack = new PokerPack();
        player_1 = new Player();
        player_2 = new Player();
    }

    public void startGame() {
        //获得两玩家的ID和姓名
        int IDOfPlayer_1 = player_1.getPlayerID();
        int IDOfPlayer_2 = player_2.getPlayerID();
        String nameOfPlayer_1 = player_1.getPlayerName();
        String nameOfPlayer_2 = player_2.getPlayerName();

        System.out.println("---------------游戏开始---------------");
        System.out.println("---------------欢迎玩家：" + nameOfPlayer_1);
        System.out.println("---------------欢迎玩家：" + nameOfPlayer_2);

        System.out.println("给玩家发牌···");
        //从牌堆中给玩家发牌，每人两张
        for (int i = 0; i < 2; i++) {
            System.out.println("-----" + nameOfPlayer_1 + "拿牌");
            player_1.playerGetPoker(pokerPack.getPokerFromDisorder());
            System.out.println("-----" + nameOfPlayer_2 + "拿牌");
            player_2.playerGetPoker(pokerPack.getPokerFromDisorder());
        }
        System.out.println("---------------发牌结束---------------");

        //获得两玩家的最大手牌
        Poker biggestOfPlayer_1 = player_1.biggestPokerInHand();
        Poker biggestOfPlayer_2 = player_2.biggestPokerInHand();
        System.out.println("玩家：" + nameOfPlayer_1 + "的最大手牌为："
                + biggestOfPlayer_1.getPokerSuit() + "：" + biggestOfPlayer_1.getPokerPointAsStr());
        System.out.println("玩家：" + nameOfPlayer_2 + "的最大手牌为："
                + biggestOfPlayer_2.getPokerSuit() + "：" + biggestOfPlayer_2.getPokerPointAsStr());

        //比较最大手牌
        int result = biggestOfPlayer_1.compareTo(biggestOfPlayer_2);//比较的结果
        if (result > 0) {
            System.out.println("玩家" + IDOfPlayer_1 + "：" + nameOfPlayer_1 + "获胜！");

        } else if (result < 0) {
            System.out.println("玩家" + IDOfPlayer_2 + "：" + nameOfPlayer_2 + "获胜！");
        }
        System.out.println();

        System.out.println("玩家" + IDOfPlayer_1 + "：" + nameOfPlayer_1 + "的手牌有：");
        player_1.showPokersInHand();
        System.out.println("玩家" + IDOfPlayer_2 + "：" + nameOfPlayer_2 + "的手牌有：");
        player_2.showPokersInHand();
    }
}
