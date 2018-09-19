package com.heythere.Poker;

public class Poker implements Comparable<Poker> {
    private String pokerSuit;//扑克牌花色
    private int pokerPoint;//扑克牌点数

    public Poker(String suit, int point) {
        this.pokerSuit = suit;
        this.pokerPoint = point;
    }

    public String getPokerSuit() {
        return pokerSuit;
    }

    public int getPokerPoint() {
        return pokerPoint;
    }

    @Override
    public int compareTo(Poker anotherPoker) {
        //先比较两扑克牌的点数（作差），若差不为0则直接返回
        int comparePoints = this.pokerPoint - anotherPoker.getPokerPoint();
        if (0 != comparePoints) {
            return comparePoints;
        }

        //若扑克牌点数相同（差为0）则继续比较花色
        //用数字代表四种花色，方便比较
        int thisPokerSuit = transferSuitIntoInt(this.pokerSuit);
        int anotherPokerSuit = transferSuitIntoInt(anotherPoker.getPokerSuit());
        return thisPokerSuit - anotherPokerSuit;
    }

    private int transferSuitIntoInt(String pokerSuit) {
        int point = 0;
        switch (pokerSuit) {
            case "Spade":
                point = 4;
                break;
            case "Heart":
                point = 3;
                break;
            case "Club":
                point = 2;
                break;
            case "Diamond":
                point = 1;
                break;
        }
        return point;
    }
}
