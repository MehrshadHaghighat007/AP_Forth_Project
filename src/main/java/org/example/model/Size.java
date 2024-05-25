package org.example.model;

import org.example.controller.ConfigController;
import org.example.controller.SizeCalculation;

public class Size {
    private int widthGame;
    private int heightGame;
    private int xCoordinate;
    private int yCoordinate;

    public Size() {
        SizeCalculation sizeCalculation = new SizeCalculation();
        widthGame = sizeCalculation.calculatedWidth();
        heightGame = sizeCalculation.calculatedHeight();
        xCoordinate = sizeCalculation.calculatedXCoordinate();
        yCoordinate = sizeCalculation.calculatedYCoordinate();
    }

    public int getWidthGame() {
        return widthGame;
    }

    public void setWidthGame(int widthGame) {
        this.widthGame = widthGame;
    }

    public int getHeightGame() {
        return heightGame;
    }

    public void setHeightGame(int heightGame) {
        this.heightGame = heightGame;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
