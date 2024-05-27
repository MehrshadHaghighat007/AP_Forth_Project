package org.example.model;

import org.example.controller.ConfigController;
import org.example.view.Label;

public class FirstPanel {
    private static final int WIDTH = ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("width");
    private static final int HEIGHT = ConfigController.getConfigController().getConfig().getSizeOfTheFirstMenu().get("height");
    private static final int X_COORDINATE = ConfigController.getConfigController().getConfig().getCoordinatesOfThePanel().get("x");
    private static final int Y_COORDINATE = ConfigController.getConfigController().getConfig().getCoordinatesOfThePanel().get("y");
    private static final Label LABEL = Label.getLabel();

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

    public static Label getLABEL() {
        return LABEL;
    }
}
