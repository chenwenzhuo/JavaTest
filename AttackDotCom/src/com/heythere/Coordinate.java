package com.heythere;

class Coordinate {
    //方格的横纵坐标
    private char horizontalCoordinate;
    private char verticalCoordinate;

    public char getVerticalCoordinate() {
        return verticalCoordinate;
    }

    public char getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public void setCoordinates(char h, char v) {
        this.horizontalCoordinate = h;
        this.verticalCoordinate = v;
    }

    @Override
    public String toString() {
        return "" + horizontalCoordinate + verticalCoordinate;
    }
}
