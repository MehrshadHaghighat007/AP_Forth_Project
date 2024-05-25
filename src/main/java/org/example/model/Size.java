package org.example.model;

import org.example.controller.ConfigController;

public class Size {
    private int widthGame;
    private int heightGame;
    private int xCoordinate;
    private int yCoordinate;
    public Size() {
        int width = ConfigController.getConfigController().getConfigControllerParameters().getConfig().getSize().get("width");
        int height = ConfigController.getConfigController().getConfigControllerParameters().getConfig().getSize().get("height");
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
