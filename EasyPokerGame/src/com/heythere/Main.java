package com.heythere;

import com.heythere.Game.PokerGame;
import com.heythere.Player.Player;
import com.heythere.Poker.PokerPack;

public class Main {

    public static void main(String[] args) {
//        PokerPack pokerPack = new PokerPack();
//        pokerPack.showAllPokersInOrder();
//        pokerPack.showDisorderedPokers();

//        Player player = new Player();

        PokerGame pokerGame = new PokerGame();
        pokerGame.startGame();
    }
}
