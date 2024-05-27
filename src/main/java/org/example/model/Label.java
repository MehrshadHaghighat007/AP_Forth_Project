package org.example.model;

import org.example.controller.ConfigController;

public class Label {
    private static final int WIDTH = ConfigController.getConfigController().getConfig().getLabelParameters().get("size").get("width");
    private static final int HEIGHT = ConfigController.getConfigController().getConfig().getLabelParameters().get("size").get("height");
    private static final int X_COORDINATE = ConfigController.getConfigController().getConfig().getLabelParameters().get("location").get("x");
    private static final int Y_COORDINATE = ConfigController.getConfigController().getConfig().getLabelParameters().get("location").get("y");

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getxCoordinate() {
        return X_COORDINATE;
    }

    public static int getyCoordinate() {
        return Y_COORDINATE;
    }
}
