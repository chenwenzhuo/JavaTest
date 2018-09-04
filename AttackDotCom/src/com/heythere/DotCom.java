package com.heythere;

import org.jetbrains.annotations.NotNull;

class DotCom {
    private Coordinate[] coordinates = new Coordinate[3];//DotCom所占的三个方格坐标
    private boolean[] isCoordinateHit = new boolean[3];//标志三个方格是否被击中
    private String dotComName;
    private int dotComHitCount;//DotCom被击中的次数
    private boolean isAllInitialized = false;//标志DotCom的三个坐标是否都被初始化

    public DotCom(Coordinate co_1, Coordinate co_2, Coordinate co_3, String dotComName) {
        //判断传入的坐标值是否有效
        if (!isCoordinateLegal(co_1, co_2, co_3)) {
            System.out.println("Illegal coordinates!DotCom is not initiated.");
            return;
        }
        this.coordinates[0] = co_1;
        this.coordinates[1] = co_2;
        this.coordinates[2] = co_3;
        this.dotComName = dotComName;
        isAllInitialized = true;
        dotComHitCount = 0;

        for (int i = 0; i < 3; i++) {
            isCoordinateHit[i] = false;
        }
    }

    private boolean isCoordinateLegal
            (@NotNull Coordinate co_1, @NotNull Coordinate co_2, @NotNull Coordinate co_3) {
        String allVerticalCoordinates = "ABCDEFG";
        String allHorizontalCoordinates = "1234567";

        //尝试3个坐标的所有可能组合情况
        //123，132，213，231，312，321
        String h_sorted_Co_1 = ""
                + co_1.getHorizontalCoordinate()
                + co_2.getHorizontalCoordinate()
                + co_3.getHorizontalCoordinate();
        String v_sortedCo_1 = ""
                + co_1.getVerticalCoordinate()
                + co_2.getVerticalCoordinate()
                + co_3.getVerticalCoordinate();
        String h_sorted_Co_2 = ""
                + co_1.getHorizontalCoordinate()
                + co_3.getHorizontalCoordinate()
                + co_2.getHorizontalCoordinate();
        String v_sortedCo_2 = ""
                + co_1.getVerticalCoordinate()
                + co_3.getVerticalCoordinate()
                + co_2.getVerticalCoordinate();
        String h_sorted_Co_3 = ""
                + co_2.getHorizontalCoordinate()
                + co_1.getHorizontalCoordinate()
                + co_3.getHorizontalCoordinate();
        String v_sortedCo_3 = ""
                + co_2.getVerticalCoordinate()
                + co_1.getVerticalCoordinate()
                + co_3.getVerticalCoordinate();
        String h_sorted_Co_4 = ""
                + co_2.getHorizontalCoordinate()
                + co_3.getHorizontalCoordinate()
                + co_1.getHorizontalCoordinate();
        String v_sortedCo_4 = ""
                + co_2.getVerticalCoordinate()
                + co_3.getVerticalCoordinate()
                + co_1.getVerticalCoordinate();
        String h_sorted_Co_5 = ""
                + co_3.getHorizontalCoordinate()
                + co_1.getHorizontalCoordinate()
                + co_2.getHorizontalCoordinate();
        String v_sortedCo_5 = ""
                + co_3.getVerticalCoordinate()
                + co_1.getVerticalCoordinate()
                + co_2.getVerticalCoordinate();
        String h_sorted_Co_6 = ""
                + co_3.getHorizontalCoordinate()
                + co_2.getHorizontalCoordinate()
                + co_1.getHorizontalCoordinate();
        String v_sortedCo_6 = ""
                + co_3.getVerticalCoordinate()
                + co_2.getVerticalCoordinate()
                + co_1.getVerticalCoordinate();
        return allHorizontalCoordinates.contains(h_sorted_Co_1) || allVerticalCoordinates.contains(v_sortedCo_1)
                || allHorizontalCoordinates.contains(h_sorted_Co_2) || allVerticalCoordinates.contains(v_sortedCo_2)
                || allHorizontalCoordinates.contains(h_sorted_Co_3) || allVerticalCoordinates.contains(v_sortedCo_3)
                || allHorizontalCoordinates.contains(h_sorted_Co_4) || allVerticalCoordinates.contains(v_sortedCo_4)
                || allHorizontalCoordinates.contains(h_sorted_Co_5) || allVerticalCoordinates.contains(v_sortedCo_5)
                || allHorizontalCoordinates.contains(h_sorted_Co_6) || allVerticalCoordinates.contains(v_sortedCo_6);
    }

    public boolean isDotComHit(String guess) {
        if (isCoordinateHit[0] && isCoordinateHit[1] && isCoordinateHit[2]) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (guess.equals(coordinates[i].toString()) && !isCoordinateHit[i]) {
                isCoordinateHit[i] = true;
                dotComHitCount++;
                return true;
            }
        }
        return false;
    }

    public String getDotComName() {
        return this.dotComName;
    }

    public void setDotComName(String dotComName) {
        this.dotComName = dotComName;
    }

    public boolean isAllInitialized() {
        return this.isAllInitialized;
    }

    public void setAllInitialized(boolean allInitialized) {
        this.isAllInitialized = allInitialized;
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }

    public int getDotComHitCount() {
        return dotComHitCount;
    }

    public String toString() {
        return coordinates[0].toString() +
                coordinates[1].toString() +
                coordinates[2].toString() +
                "   " + dotComName;
    }
}
