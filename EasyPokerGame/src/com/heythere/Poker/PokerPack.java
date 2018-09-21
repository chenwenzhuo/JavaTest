package com.heythere.Poker;

import java.util.*;

public class PokerPack {
    private List<Poker> orderedPokers;//洗牌前有序的牌
    private Set<Poker> disorderedPokers;//洗牌后无序的牌

    private Random random;//用于在洗牌时产生随机数
    private Iterator<Poker> iterator;

    public PokerPack() {
        //初始化List与Set
        orderedPokers = new ArrayList<>();
        disorderedPokers = new HashSet<>();

        random = new Random();

        //在List中生成有序的牌
        generatePokersToList();
        //洗牌
        makePokersDisorder();
        //洗牌后（disorderedPokers不为空时），获得其迭代器
        iterator = disorderedPokers.iterator();
    }

    private void makePokersDisorder() {
        System.out.println("---------------洗牌---------------");
        int pokerQuantity = orderedPokers.size();//生成的牌的总数

        int count = 0;//乱序牌堆里牌数量计数器
        int index;//随机生成index，取出有序牌堆中index位置的牌放入无序牌堆
        while (count < pokerQuantity) {
            index = random.nextInt(52);

            Poker aPoker = orderedPokers.get(index);
            if (disorderedPokers.contains(aPoker)) {
                continue;
            }
            disorderedPokers.add(aPoker);
            count++;
        }
        System.out.println("-------------洗牌完毕-------------");
    }

    private void generatePokersToList() {
        String[] pokerSuits = {"Spade", "Heart", "Club", "Diamond"};

        //生成扑克牌
        System.out.println("---------------创建扑克牌---------------");
        String suit;
        for (int i = 0; i < 4; i++) {
            suit = pokerSuits[i];
            for (int j = 0; j < 13; j++) {
                Poker aPoker = new Poker(suit, j + 1);
                orderedPokers.add(aPoker);
            }
        }
        System.out.println("-------------扑克牌创建完毕-------------");
        showAllPokersInOrder();
    }


    public void showAllPokersInOrder() {
        System.out.println("生成的扑克牌：");

        int counter = 0;//输出时的换行计数器
        int oneLine = orderedPokers.size() / 4;//一行的输出数量
        for (Poker p : orderedPokers) {
            if (counter != 0 && 0 == counter % oneLine) {
                System.out.println();
            }
            System.out.print(p.getPokerSuit() + ":" + p.getPokerPointAsStr()+"     ");
            counter++;
        }
        System.out.println();
    }

    public void showDisorderedPokers() {
        System.out.println("洗牌后：");
        for (Poker p : disorderedPokers) {
            System.out.print(p.getPokerSuit() + ":" + p.getPokerPointAsStr());
        }
    }

    /*private void getPokerPointAsStr(Poker p) {
        int point = p.getPokerPoint();
        *//*
        点数为1到10则直接输出，
        为11到13则输出J、Q、K
         *//*
        switch (point) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println(point);
                break;
            case 11:
                System.out.println("J");
                break;
            case 12:
                System.out.println("Q");
                break;
            case 13:
                System.out.println("K");
                break;
        }
    }*/

    public Poker getPokerFromDisorder() {

        return iterator.next();
    }
}
